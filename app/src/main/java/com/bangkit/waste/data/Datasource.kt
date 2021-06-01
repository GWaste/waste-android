package com.bangkit.waste.data

import com.bangkit.waste.model.Material
import com.bangkit.waste.model.Product

class Datasource {
    fun loadMaterials(): List<Material> {
        return listOf(
            Material("Cardboard"),
            Material("Glass"),
            Material("Metal"),
            Material("Paper"),
            Material("Plastic"),
        )
    }    
    
    fun loadProducts(): List<Product> {
        return listOf(
            Product("Tempat Tisu"),
            Product("Produk 2"),
            Product("Produk 3"),
            Product("Produk 4"),
            Product("Produk 5"),
            Product("Produk 6"),
        )
    }
    
    fun loadFavoriteProducts(): List<Product> {
        return listOf(
            Product("Tempat Tisu"),
            Product("Produk 3"),
            Product("Produk 6"),
        )
    }
}