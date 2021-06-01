package com.bangkit.waste.ui.camera

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.bangkit.waste.adapter.CategoryAdapter
import com.bangkit.waste.data.Datasource
import com.bangkit.waste.databinding.ActivityCategoriesBinding

class CategoriesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityCategoriesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val productDataset = Datasource().loadCategories()

        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(this@CategoriesActivity)
            adapter = CategoryAdapter(this@CategoriesActivity, productDataset)
        }
    }
}