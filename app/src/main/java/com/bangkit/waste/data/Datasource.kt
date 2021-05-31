package com.bangkit.waste.data

import com.bangkit.waste.model.Product

class Datasource {
    fun loadProducts(): List<Product> {
        return listOf<Product>(
            Product("Tempat Tisu"),
            Product("Produk 2")
        )
    }
    
    fun loadFavoriteProducts(): List<Product> {
        return listOf<Product>(
            Product("Tempat Tisu")
        )
    }
}