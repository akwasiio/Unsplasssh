package com.example.unsplasssh

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DataSource @Inject constructor(private val unsplashService: UnsplashService) {
    suspend fun getImages(page: Int) = unsplashService.getImages(page)
}