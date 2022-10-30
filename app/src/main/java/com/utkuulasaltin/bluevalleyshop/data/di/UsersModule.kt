package com.utkuulasaltin.bluevalleyshop.data.di

import com.utkuulasaltin.bluevalleyshop.data.remote.api.UsersService
import com.utkuulasaltin.bluevalleyshop.data.remote.source.UsersRemoteDataSource
import com.utkuulasaltin.bluevalleyshop.data.remote.source.impl.UsersRemoteDataSourceImpl
import com.utkuulasaltin.bluevalleyshop.domain.repository.UsersRepository
import com.utkuulasaltin.bluevalleyshop.domain.repository.impl.UsersRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UsersModule {

    @Singleton
    @Provides
    fun provideUsersService(retrofit: Retrofit) = retrofit.create(UsersService::class.java)

    @Singleton
    @Provides
    fun provideUsersRemoteDataSource(usersService: UsersService): UsersRemoteDataSource =
        UsersRemoteDataSourceImpl(usersService)

    @Singleton
    @Provides
    fun provideUsersRepository(usersRemoteDataSource: UsersRemoteDataSource): UsersRepository =
        UsersRepositoryImpl(usersRemoteDataSource)
}