package com.practice.testDatingApp.utils.retrofit.factoryAdapter.exception

import java.io.IOException

internal class RetrofitExceptionCreator {

    companion object {

        fun handleException(throwable: Throwable): CoroutineRetrofitException {
            if (throwable is IOException) {
                val additionalMessage = if (!throwable.localizedMessage.isNullOrEmpty()) {
                    " (${throwable.localizedMessage!!})"
                } else {
                    ""
                }

                return CoroutineRetrofitException(
                    "Network error!, please try again later",
                    throwable,
                    throwable.hashCode()
                )
            }
            return CoroutineRetrofitException(throwable, -200)
        }

        fun handleException(message: String?, errorCode: Int): CoroutineRetrofitException {
            return CoroutineRetrofitException(message, Throwable(""), errorCode)
        }

        fun handleException(
            message: String?,
            errorCode: Int,
            errorCodeString: String?,
            errorCodeDescString: String?
        ): CoroutineRetrofitException {
            return CoroutineRetrofitException(
                message,
                Throwable(""),
                errorCode,
                errorCodeString,
                errorCodeDescString
            )
        }

    }

}