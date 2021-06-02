package com.bangkit.waste.ui.camera

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.bangkit.waste.adapter.CategoryAdapter
import com.bangkit.waste.data.Datasource
import com.bangkit.waste.databinding.ActivityCategoriesBinding
import com.bangkit.waste.model.CategoryResult
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

class CategoriesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityCategoriesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var jsonString = ""

        val b = intent.extras
        b?.let {
            jsonString = it.getString("response", "")
        }

        val result = Json.decodeFromString<List<CategoryResult>>(jsonString).sortedBy { 
            -it.confident
        }.take(2)
        
        val productDataset = Datasource().loadCategories()

        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(this@CategoriesActivity)
            adapter = CategoryAdapter(this@CategoriesActivity, result, productDataset)
        }
    }
}