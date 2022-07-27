package com.example.myapplication.data.soure

import android.util.Log
import com.example.furniture.data.entity.HomeModel
import com.example.furniture.domain.IHomeDataSource
import com.example.furniture.source.ApiInterface

import retrofit2.Response
import javax.inject.Inject


class HomeRemoteDataSource @Inject constructor(
    private val apiInterface: ApiInterface
) : IHomeDataSource {

    override suspend fun getHome(): Response<HomeModel>? {
        return try {
            return apiInterface.getHomeRequests("en","")
        } catch (e: Exception) {
            Log.d("product ",e.message.toString())
            return  null
        }    }

}





