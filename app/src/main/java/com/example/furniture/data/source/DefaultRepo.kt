package com.example.myapplication.data.soure


import com.example.furniture.data.entity.HomeModel
import com.example.furniture.domain.IHomeDataSource
import com.example.furniture.domain.IHomeRepo
import retrofit2.Response
import javax.inject.Inject


class DefaultRepo @Inject constructor(
    private val productsRemoteDataSource: IHomeDataSource,
    private val productsLocalDataSource: IHomeDataSource,
) : IHomeRepo {

    override suspend fun getHome(): Response<HomeModel>? {
       return productsRemoteDataSource.getHome()
    }
}





