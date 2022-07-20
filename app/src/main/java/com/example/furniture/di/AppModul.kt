package com.example.furniture.di


import com.example.furniture.source.ApiInterface
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
/*

    @Singleton
    @RemoteProductDataSource
    @Provides
    fun provideRemoteProductsDataSource(
        api: ApiInterface
    ): IProductsDataSource = ProductsRemoteDataSource(api)


    @Singleton
    @Provides
    fun provideDefaultProductRepository(
        @RemoteProductDataSource remote: IProductsDataSource,
        @LocalProductDataSource local: IProductsDataSource
    )
    = DefaultRepo(remote, local ) as IProductsRepository
    @LocalProductDataSource
    @Singleton
    @Provides

    fun provideLocalProductDataSource(
    ): IProductsDataSource = ProductsLocalDataSource()


    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class RemoteProductDataSource

    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class LocalProductDataSource

*/

}