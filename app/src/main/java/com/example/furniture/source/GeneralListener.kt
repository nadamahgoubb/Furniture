package com.example.furniture.source

interface GeneralListener<T> {
    fun getApiResponse(
        status: Int, message: String?,
        tApiResponse: T
    )
}



