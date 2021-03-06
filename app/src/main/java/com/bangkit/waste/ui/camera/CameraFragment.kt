package com.bangkit.waste.ui.camera

import android.Manifest
import android.content.Intent
import android.os.Bundle
import android.util.Base64
import android.util.Log
import android.util.Size
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.camera.core.*
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProvider
import com.android.volley.*
import com.android.volley.toolbox.HttpHeaderParser
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.bangkit.waste.databinding.FragmentCameraBinding
import com.bangkit.waste.utils.CameraUtility
import com.bangkit.waste.utils.Constant
import com.google.common.util.concurrent.ListenableFuture
import org.json.JSONObject
import pub.devrel.easypermissions.AppSettingsDialog
import pub.devrel.easypermissions.EasyPermissions
import java.io.UnsupportedEncodingException
import java.nio.ByteBuffer


class CameraFragment : Fragment(), EasyPermissions.PermissionCallbacks {

    private lateinit var cameraViewModel: CameraViewModel
    private var _binding: FragmentCameraBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    
    private lateinit var cameraProviderFuture : ListenableFuture<ProcessCameraProvider>
    private var cameraProvider : ProcessCameraProvider? = null
    private var cameraSelector : CameraSelector? = null
    private var preview : Preview? = null
    private var isFreeze : Boolean = true
    private var imageAnalysis : ImageAnalysis? = null
    private var imageCapture : ImageCapture? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        requestPermissions()
        cameraViewModel =
            ViewModelProvider(this).get(CameraViewModel::class.java)
      
        cameraProviderFuture = ProcessCameraProvider.getInstance(requireContext())

        _binding = FragmentCameraBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        cameraProviderFuture.addListener({
            cameraProvider = cameraProviderFuture.get()
            bindPreview(cameraProvider!!)
            bindAnalysis(cameraProvider!!)
            bindCapture(cameraProvider!!)
            binding.classifyButton.isEnabled = true
        }, ContextCompat.getMainExecutor(requireContext()))
        

        binding.classifyButton.setOnClickListener {

            cameraProvider?.unbind(preview)
            isFreeze = true
            
            binding.classifyButton.isEnabled = false
            Toast.makeText(requireContext(), "Classifying object...",Toast.LENGTH_SHORT).show()
            onCaptureClick()
        }
        
    }

    private fun requestPermissions() {
        if (CameraUtility.hasPermission(requireContext())) {
            return
        }

        EasyPermissions.requestPermissions(
            this,
            "You need to accept camera permissions to use this app.",
            0,
            Manifest.permission.CAMERA
        )
    }

    override fun onPermissionsDenied(requestCode: Int, perms: MutableList<String>) {
        if (EasyPermissions.somePermissionPermanentlyDenied(this, perms)) {
            AppSettingsDialog.Builder(this).build().show()
        } else {
            requestPermissions()
        }
    }

    override fun onPermissionsGranted(requestCode: Int, perms: MutableList<String>) {}

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this)
    }

    override fun onResume() {
        super.onResume()

        cameraProvider?.let {
            binding.classifyButton.isEnabled = true
            bindPreview(it)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun bindPreview(cameraProvider : ProcessCameraProvider) {
        if (isFreeze) {
            isFreeze = false
            
            preview = Preview.Builder()
                .build()
    
            cameraSelector = CameraSelector.Builder()
                .requireLensFacing(CameraSelector.LENS_FACING_BACK)
                .build()
    
            preview!!.setSurfaceProvider(binding.previewView.surfaceProvider)
    
            cameraProvider.bindToLifecycle(this as LifecycleOwner, cameraSelector!!, preview)
                 
        }
    }
    
    private fun bindAnalysis(cameraProvider : ProcessCameraProvider) {
        imageAnalysis = ImageAnalysis.Builder()
            .setTargetResolution(Size(1280, 720))
            .setBackpressureStrategy(ImageAnalysis.STRATEGY_KEEP_ONLY_LATEST)
            .build()

//        imageAnalysis?.setAnalyzer(executor, ImageAnalysis.Analyzer { image ->
//            val rotationDegrees = image.imageInfo.rotationDegrees
//            // insert your code here.
//        })

        cameraProvider.bindToLifecycle(this as LifecycleOwner, cameraSelector!!, imageAnalysis, preview)
    }
    
    private fun bindCapture(cameraProvider : ProcessCameraProvider) {
        imageCapture = ImageCapture.Builder()
            .setTargetRotation(requireView().display.rotation).setTargetResolution(Size(400, 300))
            .build()

        cameraProvider.bindToLifecycle(this as LifecycleOwner, cameraSelector!!, imageCapture,
            imageAnalysis, preview)
    }

    private fun onCaptureClick() {
        val cameraExecutor = ContextCompat.getMainExecutor(requireContext())
        imageCapture?.takePicture(cameraExecutor,
            object : ImageCapture.OnImageCapturedCallback() {
                override fun onError(error: ImageCaptureException)
                {
                    // insert your code here.
                }

                override fun onCaptureSuccess(image: ImageProxy) {
                    val imageInBase64String = imageProxyToBase64String(image)
                    requestClassify(imageInBase64String)
                }
            })
    }

    private fun imageProxyToBase64String(image: ImageProxy): String {
        val buffer: ByteBuffer = image.planes[0].buffer
        val bytes = ByteArray(buffer.remaining())
        
        buffer.get(bytes)
        return Base64.encodeToString(bytes, Base64.DEFAULT)
//        val bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.size)
    }


    private fun requestClassify(base64String: String) {
        try {
            val requestQueue = Volley.newRequestQueue(requireContext())
            val url = Constant.MODEL_URL
            val jsonBody = JSONObject()
            jsonBody.put(
                "image",
                base64String
            )
            val requestBody = jsonBody.toString()
            val stringRequest: StringRequest =
                object : StringRequest(
                    Method.POST, url,
                    Response.Listener { response ->
                        if (response != null) {
                            Log.i("VOLLEY", response)

                            val b = Bundle()
                            b.putString("response", response)

                            val i = Intent(requireContext(), CategoriesActivity::class.java)
                            i.putExtras(b)

                            startActivity(i)

                            binding.classifyButton.isEnabled = true
                        }
                    },
                    Response.ErrorListener { error ->
                        Log.e("VOLLEY", error.toString() ?: "")
                        Toast.makeText(requireContext(), error.toString() ?: "",Toast.LENGTH_SHORT).show()
                        binding.classifyButton.isEnabled = true
                        cameraProvider?.let { cp ->
                            bindPreview(cp)
                        }
                    }) {
                    override fun getBodyContentType(): String {
                        return "application/json; charset=utf-8"
                    }


                    @Throws(AuthFailureError::class)
                    override fun getBody(): ByteArray? {
                        return try {
                            requestBody.toByteArray(charset("utf-8"))
                        } catch (uee: UnsupportedEncodingException) {
                            VolleyLog.wtf(
                                "Unsupported Encoding while trying to get the bytes of %s using %s",
                                requestBody,
                                "utf-8"
                            )
                            null
                        }
                    }

                    override fun getRetryPolicy(): RetryPolicy {
                        return DefaultRetryPolicy(
                            15000,
                            DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                            DefaultRetryPolicy.DEFAULT_BACKOFF_MULT
                        )

                    }

                    override fun parseNetworkResponse(response: NetworkResponse): Response<String> {
                        val responseString = response.data.decodeToString()
                        return Response.success(
                            responseString,
                            HttpHeaderParser.parseCacheHeaders(response)
                        )
                    }                    
                }
            requestQueue.add(stringRequest)
        } catch (e: Exception) {
            binding.classifyButton.isEnabled = true
        }
    }
    
}