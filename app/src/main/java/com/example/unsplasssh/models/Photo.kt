package com.example.unsplasssh.models

import kotlinx.serialization.Serializable

@Serializable
data class Photo(
//    @Json(name = "alt_description") val contentDescription: String,
    val urls: Urls,
    val user: User
)
