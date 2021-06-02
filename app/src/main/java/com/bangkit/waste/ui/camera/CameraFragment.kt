package com.bangkit.waste.ui.camera

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.camera.core.CameraSelector
import androidx.camera.core.Preview
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


class CameraFragment : Fragment() {

    private lateinit var cameraViewModel: CameraViewModel
    private var _binding: FragmentCameraBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    
    private lateinit var cameraProviderFuture : ListenableFuture<ProcessCameraProvider>
    private var cameraProvider : ProcessCameraProvider? = null

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
            binding.classifyButton.isEnabled = true
        }, ContextCompat.getMainExecutor(requireContext()))
        

        binding.classifyButton.setOnClickListener {

            binding.classifyButton.isEnabled = false
            Toast.makeText(requireContext(), "Classifying object...",Toast.LENGTH_SHORT).show()
            
            try {
                val requestQueue = Volley.newRequestQueue(requireContext())
                val url = "https://us-central1-cosmic-quarter-312712.cloudfunctions.net/waste-classifier"
                val jsonBody = JSONObject()
                jsonBody.put("image", "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")
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

    override fun onResume() {
        super.onResume()

        if (cameraProvider != null) {
            binding.classifyButton.isEnabled = true
            
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun bindPreview(cameraProvider : ProcessCameraProvider) {
        val preview : Preview = Preview.Builder()
            .build()

        val cameraSelector : CameraSelector = CameraSelector.Builder()
            .requireLensFacing(CameraSelector.LENS_FACING_BACK)
            .build()

        preview.setSurfaceProvider(binding.previewView.surfaceProvider)

        var camera = cameraProvider.bindToLifecycle(this as LifecycleOwner, cameraSelector, preview)
    }
    
}