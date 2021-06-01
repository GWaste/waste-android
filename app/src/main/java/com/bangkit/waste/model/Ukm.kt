package com.bangkit.waste.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Ukm(
    val id: Int,
    val name: String,
    @SerialName("product_id") val productId: List<Int>,
    val status: Int,
    val map: UkmMap,
    val contact: UkmContact
)

@Serializable
data class UkmMap(
    val location: String,
    val position: String?,
)

@Serializable
data class UkmContact(
    val whatsapp: String?,
    val instagram: String?,
    val facebook: String?,
)

@Serializable
data class UkmContainer(
    val ukm: List<Ukm>
)