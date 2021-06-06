package com.bangkit.waste.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
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

            binding.waButton.setOnClickListener {
                val url = "https://api.whatsapp.com/send?phone=" + ukm.contact.whatsapp + "&text=text=Halo%2C%20saya%20ingin%20bertanya%20suatu%20produk..."
                val i = Intent(Intent.ACTION_VIEW)
                i.data = Uri.parse(url)
                startActivity(i)
            }

            binding.igButton.setOnClickListener {
                val url = "https://instagram.com/" + (ukm.contact.instagram?.replace(
                    '@',
                    '\u0000'
                ) ?: '\u0000')
                val i = Intent(Intent.ACTION_VIEW)
                i.data = Uri.parse(url)
                startActivity(i)
            }

            if (ukm.contact.facebook != null) {

                binding.fbButton.setOnClickListener {
                    val url = "https://facebook.com/" + ukm.contact.facebook
                    val i = Intent(Intent.ACTION_VIEW)
                    i.data = Uri.parse(url)
                    startActivity(i)
                }
            } else {
                binding.fbButton.visibility = GONE
            }

        } catch (e: Exception) {
            binding.contactButtons.visibility = GONE
            binding.addressCard.visibility = GONE
            binding.addressText.visibility = GONE
        }

    }
}