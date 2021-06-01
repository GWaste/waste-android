package com.bangkit.waste.model

data class Ukm(
    val id: Int,
    val name: String,
    val productId: List<Int>,
    val status: Int,
    val map: Map<String, String>,
    val contact: Map<String, String>
)