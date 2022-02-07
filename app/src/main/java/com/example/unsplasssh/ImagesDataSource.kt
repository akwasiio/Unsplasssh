package com.example.unsplasssh

import com.example.unsplasssh.network.UnsplashService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ImagesDataSource @Inject constructor(private val unsplashService: UnsplashService) {
    suspend fun getImages(page: Int) = unsplashService.getImages(page)
}