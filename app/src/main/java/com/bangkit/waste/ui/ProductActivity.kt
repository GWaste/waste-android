package com.bangkit.waste.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bangkit.waste.data.Datasource
import com.bangkit.waste.databinding.ActivityProductBinding
import com.squareup.picasso.Picasso

class ProductActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityProductBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var productId = 0

        val b = intent.extras
        b?.let {
            productId = it.getInt("product_id", 0)
        }
        
        val dataset = Datasource().loadProducts()
        val product = dataset.first { it.id == productId }

        title = product.name
        Picasso.get().load(product.image).into(binding.imageView)
        
        binding.stepCard.setOnClickListener {
            val sb = Bundle()
            sb.putInt("product_id", productId)

            val i = Intent(this@ProductActivity, StepActivity::class.java)
            i.putExtras(sb)
            
            startActivity(i)
        }
        
        binding.ukmCard.setOnClickListener {
            val ub = Bundle()
            ub.putInt("product_id", productId)

            val i = Intent(this@ProductActivity, UkmActivity::class.java)
            i.putExtras(ub)

            startActivity(i)
        }
    }
}