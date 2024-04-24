package com.practice.testDatingApp.utils.retrofit.factoryAdapter.exception

class CoroutineRetrofitException(
    message: String?,
    throwable: Throwable?,
    private val mainErrorCode: Int,
    private val mainErrorCodeString: String?=null,
    private val mainErrorCodeDescString: String?=null,
) : RuntimeException(message, throwable) {
    constructor(throwable: Throwable?, errorCode: Int) : this(
        throwable?.message,
        throwable,
        errorCode
    )

    val errorCode: Int
        get() = mainErrorCode

    val errorCodeString : String
        get() = mainErrorCodeString?:""

    val errorDescString : String
        get() = mainErrorCodeDescString?:""
}