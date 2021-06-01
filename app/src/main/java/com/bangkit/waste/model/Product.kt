package com.bangkit.waste.model

data class Product(
    val id: Int,
    val name: String,
    val image: String, // image url
    val categoryId: Int,
    val ingredient: List<String>,
    val step: List<String>,
    val linkYt: String,
    val favorite: Boolean
)