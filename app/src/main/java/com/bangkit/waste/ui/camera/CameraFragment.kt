package com.bangkit.waste.ui.camera

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
import com.android.volley.AuthFailureError
import com.android.volley.NetworkResponse
import com.android.volley.Response
import com.android.volley.VolleyLog
import com.android.volley.toolbox.HttpHeaderParser
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.bangkit.waste.databinding.FragmentCameraBinding
import com.google.common.util.concurrent.ListenableFuture
import org.json.JSONObject
import java.io.UnsupportedEncodingException
import java.nio.ByteBuffer


class CameraFragment : Fragment() {

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

    fun bindPreview(cameraProvider : ProcessCameraProvider) {
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
    
    fun bindAnalysis(cameraProvider : ProcessCameraProvider) {
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
    
    fun bindCapture(cameraProvider : ProcessCameraProvider) {
        imageCapture = ImageCapture.Builder()
            .setTargetRotation(requireView().display.rotation).setTargetResolution(Size(256, 256))
            .build()

        cameraProvider.bindToLifecycle(this as LifecycleOwner, cameraSelector!!, imageCapture,
            imageAnalysis, preview)
    }

    fun onCaptureClick() {
        val cameraExecutor = ContextCompat.getMainExecutor(requireContext())
        imageCapture?.takePicture(cameraExecutor,
            object : ImageCapture.OnImageCapturedCallback() {
                override fun onError(error: ImageCaptureException)
                {
                    // insert your code here.
                }

                override fun onCaptureSuccess(image: ImageProxy) {
                    val imageInBase64String = imageProxyToBase64String(image)
                    Log.d("ZXC b64", imageInBase64String)
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
            val url =
                "https://us-central1-cosmic-quarter-312712.cloudfunctions.net/waste-classifier"
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
                    Response.ErrorListener { error -> Log.e("VOLLEY", error.toString()) }) {
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