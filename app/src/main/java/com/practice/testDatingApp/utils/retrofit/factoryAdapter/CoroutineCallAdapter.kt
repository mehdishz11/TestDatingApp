package com.practice.testDatingApp.utils.retrofit.factoryAdapter

import retrofit2.Call
import retrofit2.CallAdapter
import retrofit2.Retrofit
import java.lang.reflect.Type

class CoroutineCallAdapter<T>(private val successType: Type,private val retrofit: Retrofit) : CallAdapter<T, Call<T?>> {
    override fun responseType(): Type {
        return successType
    }
    override fun adapt(call: Call<T>): Call<T?> {
        return CoroutineCall(call,retrofit)
    }
}
