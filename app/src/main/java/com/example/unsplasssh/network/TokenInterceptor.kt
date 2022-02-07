package com.example.unsplasssh.network

import com.example.unsplasssh.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

class TokenInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
            .header("Authorization", "Client-ID ${BuildConfig.CLIENT_ID}")
            .build()

        return chain.proceed(request = request)
    }
}