package com.bangkit.waste.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Product(
    val id: Int,
    val name: String,
    val image: String, // image url
    @SerialName("category_id") val categoryId: Int,
    val ingredient: List<String>,
    val step: List<String>,
    @SerialName("link_yt") val linkYt: String,
    val favorite: Boolean
)

@Serializable
data class ProductContainer(
    val products: List<Product>
)