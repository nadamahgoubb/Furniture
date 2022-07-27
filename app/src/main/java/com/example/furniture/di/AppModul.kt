package com.example.furniture.di


import com.example.furniture.domain.IHomeDataSource
import com.example.furniture.domain.IHomeRepo
import com.example.furniture.source.ApiInterface
import com.example.myapplication.data.soure.DefaultRepo
import com.example.myapplication.data.soure.HomeRemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModul() {


    @Singleton
    @Provides
    fun provideRemoteProductsDataSource(
        api: ApiInterface
    ): IHomeDataSource = HomeRemoteDataSource(api)


    @Singleton
    @Provides
    fun provideDefaultProductRepository(
        remote: IHomeDataSource ,
      local: IHomeDataSource):IHomeRepo  = DefaultRepo(remote, local )  as IHomeRepo

}
 /*   @Singleton
    @RemoteProductDataSource
    @Provides
    fun provideRemoteProductsDataSource(
        api: ApiInterface
    ): IHomeDataSource = HomeRemoteDataSource(api)


    @Singleton
    @Provides
    fun provideDefaultProductRepository(
        @RemoteProductDataSource remote: IHomeDataSource,
        @LocalProductDataSource local: IHomeDataSource
    )
    = DefaultRepo(remote, local ) as IHomeRepo
    @LocalProductDataSource
    @Singleton
    @Provides

    fun provideLocalProductDataSource(
    ): IHomeDataSource = HomeLocalDataSource()


    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class RemoteProductDataSource

    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class LocalProductDataSource


*/
