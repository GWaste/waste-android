package com.bangkit.waste

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.bangkit.waste.adapter.IngredientAdapter
import com.bangkit.waste.adapter.StepAdapter
import com.bangkit.waste.data.Datasource
import com.bangkit.waste.databinding.ActivityIngredientsBinding
import com.bangkit.waste.databinding.ActivityStepBinding

class IngredientsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        val binding = ActivityIngredientsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var productId = 0

        val b = intent.extras
        b?.let {
            productId = it.getInt("product_id", 0)
        }

        val dataset = Datasource().loadProducts()
        val product = dataset.first { it.id == productId }

        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(this@IngredientsActivity)
            adapter = IngredientAdapter(this@IngredientsActivity, product.ingredient)
        }
    }
}