package com.utkuulasaltin.bluevalleyshop.data.di

import com.utkuulasaltin.bluevalleyshop.data.remote.api.CartsService
import com.utkuulasaltin.bluevalleyshop.data.remote.source.CartsRemoteDataSource
import com.utkuulasaltin.bluevalleyshop.data.remote.source.impl.CartsRemoteDataSourceImpl
import com.utkuulasaltin.bluevalleyshop.domain.repository.CartsRepository
import com.utkuulasaltin.bluevalleyshop.domain.repository.impl.CartsRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class CartsModule {

    @Singleton
    @Provides
    fun provideCartsService(retrofit: Retrofit) = retrofit.create(CartsService::class.java)

    @Singleton
    @Provides
    fun provideCartsRemoteDataSource(cartsService: CartsService): CartsRemoteDataSource =
        CartsRemoteDataSourceImpl(cartsService)

    @Singleton
    @Provides
    fun provideCartsRepository(cartsRemoteDataSource: CartsRemoteDataSource): CartsRepository =
        CartsRepositoryImpl(cartsRemoteDataSource)
}