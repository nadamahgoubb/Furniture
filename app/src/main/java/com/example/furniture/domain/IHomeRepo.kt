package com.example.furniture.domain

import com.example.furniture.data.entity.HomeModel
import retrofit2.Response

interface IHomeRepo {


    suspend fun getHome(): Response<HomeModel>?
}

interface IHomeDataSource {

    suspend fun getHome(): Response<HomeModel>?
}
