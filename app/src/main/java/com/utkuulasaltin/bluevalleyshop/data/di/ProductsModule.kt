package com.utkuulasaltin.bluevalleyshop.data.di

import com.utkuulasaltin.bluevalleyshop.data.remote.api.ProductsService
import com.utkuulasaltin.bluevalleyshop.data.remote.source.ProductsRemoteDataSource
import com.utkuulasaltin.bluevalleyshop.data.remote.source.impl.ProductsRemoteDataSourceImpl
import com.utkuulasaltin.bluevalleyshop.domain.repository.ProductsRepository
import com.utkuulasaltin.bluevalleyshop.domain.repository.impl.ProductsRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ProductsModule {

    @Singleton
    @Provides
    fun provideProductsService(retrofit: Retrofit) = retrofit.create(ProductsService::class.java)

    @Singleton
    @Provides
    fun provideProductsRemoteDataSource(productsService: ProductsService): ProductsRemoteDataSource =
        ProductsRemoteDataSourceImpl(productsService)

    @Singleton
    @Provides
    fun provideProductsRepository(productsRemoteDataSource: ProductsRemoteDataSource): ProductsRepository =
        ProductsRepositoryImpl(productsRemoteDataSource)
}