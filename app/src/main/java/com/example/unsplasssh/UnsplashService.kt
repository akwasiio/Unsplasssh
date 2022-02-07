package com.example.unsplasssh

import com.example.unsplasssh.models.Photo
import retrofit2.http.GET
import retrofit2.http.Query

interface UnsplashService {
    @GET("photos")
    suspend fun getImages(@Query("page") page: Int): List<Photo>
}