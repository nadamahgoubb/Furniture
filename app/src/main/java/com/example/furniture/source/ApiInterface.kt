package com.example.furniture.source


import com.example.furniture.data.entity.HomeModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header

interface ApiInterface {
    @GET("home")
    suspend fun getHomeRequests(@Header("lang") lang: String,
                              @Header("token_customer") token: String): Response<HomeModel>

}
