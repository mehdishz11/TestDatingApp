package com.practice.testDatingApp.utils.retrofit

import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class TokenInterceptor @Inject constructor() :
    Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()
        val originalHttpUrl = original.url
        val requestBuilder = original.newBuilder()
            .addHeader("Accept", "application/json")
            .addHeader("Content-Type", "application/json")
            .url(originalHttpUrl)

        requestBuilder.addHeader("x-api-key", "WELDY")

        val request = requestBuilder.build()
        return chain.proceed(request)
    }
}