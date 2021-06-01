package com.bangkit.waste.model

import kotlinx.serialization.Serializable

@Serializable
data class Category(
    val id: Int,
    val name: String
)

@Serializable
data class CategoryContainer(
    val category: List<Category>
)