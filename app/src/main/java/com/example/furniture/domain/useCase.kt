package com.example.furniture.domain

import com.example.furniture.data.entity.HomeModel
import retrofit2.Response


suspend fun showAllHome(
    productsRepo: IHomeRepo
): Response<HomeModel>? =
    productsRepo.getHome()

