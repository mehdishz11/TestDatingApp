package com.practice.testDatingApp.utils.retrofit.factoryAdapter

import com.practice.testDatingApp.utils.retrofit.factoryAdapter.exception.RetrofitExceptionCreator
import okhttp3.Request
import okio.Timeout
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class CoroutineCall<T>(private val delegate: Call<T>, private val retrofit: Retrofit) : Call<T?> {

    override fun clone(): Call<T?> {
        return CoroutineCall(delegate.clone(),retrofit)
    }

    override fun execute(): Response<T?> {
        throw UnsupportedOperationException("NetworkResponseCall doesn't support execute")
    }

    override fun enqueue(callback: Callback<T?>) {
        return delegate.enqueue(object : Callback<T?> {
            override fun onResponse(call: Call<T?>, response: Response<T?>) {
                if (response.isSuccessful) {
                    callback.onResponse(call, response)
                } else {
                    callback.onFailure(call,
                        RetrofitExceptionCreator.handleException("Network Error, Try again!",response.code()))
                }
            }
            override fun onFailure(call: Call<T?>, t: Throwable) {
                callback.onFailure(call, RetrofitExceptionCreator.handleException(t))
            }
        })
    }

    override fun isExecuted(): Boolean = delegate.isExecuted

    override fun cancel() = delegate.cancel()

    override fun isCanceled(): Boolean = delegate.isCanceled


    override fun request(): Request = delegate.request()

    override fun timeout(): Timeout {
        return Timeout.NONE
    }

}