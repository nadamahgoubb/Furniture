package com.example.furniture.data.source


import com.example.furniture.data.entity.HomeModel
import com.example.furniture.domain.IHomeDataSource
import retrofit2.Response


class HomeLocalDataSource  () :IHomeDataSource{


    override suspend fun getHome(): Response<HomeModel>? {
        TODO("Not yet implemented")
    }

}





