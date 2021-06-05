package com.bangkit.waste.ui

import android.os.Bundle
import android.view.View.GONE
import androidx.appcompat.app.AppCompatActivity
import com.bangkit.waste.data.Datasource
import com.bangkit.waste.databinding.ActivityUkmBinding

class UkmActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityUkmBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var productId = 0

        val b = intent.extras
        b?.let {
            productId = it.getInt("product_id", 0)
        }

        val dataset = Datasource().loadUkms()
        
        try {
            val ukm = dataset.first { it.productId.contains(productId) }
            binding.nameText.text = ukm.name
            binding.addressText.text = ukm.map.location
        } catch (e: Exception) {
            binding.contactButtons.visibility = GONE
            binding.addressText.visibility = GONE
        }
        
    }
}