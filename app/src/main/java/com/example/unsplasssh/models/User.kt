package com.example.unsplasssh.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class User(
    val username: String,
    val name: String,
    @SerialName("profile_image") val profileImage: ProfileImage
)
