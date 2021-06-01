package com.bangkit.waste.ui.camera

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.bangkit.waste.adapter.ProductAdapter
import com.bangkit.waste.data.Datasource
import com.bangkit.waste.databinding.ActivityCategoriesBinding

class ProductsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityCategoriesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        var categoryId = 0
        var categoryName = "Category not found!"
        
        val b = intent.extras
        b?.let { 
            categoryId = it.getInt("category_id", 0)
            categoryName = it.getString("category_name", "Category not found!")
        }

        // Set activity title
        title = categoryName
        
        val productDataset = Datasource().loadProductsFromCategory(categoryId)

        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(this@ProductsActivity)
            adapter = ProductAdapter(this@ProductsActivity, productDataset)
        }
    }
}