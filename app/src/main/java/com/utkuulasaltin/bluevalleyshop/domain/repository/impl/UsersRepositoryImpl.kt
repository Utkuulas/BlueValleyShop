package com.utkuulasaltin.bluevalleyshop.domain.repository.impl

import com.utkuulasaltin.bluevalleyshop.data.model.UserResponse
import com.utkuulasaltin.bluevalleyshop.data.remote.source.UsersRemoteDataSource
import com.utkuulasaltin.bluevalleyshop.data.remote.utils.DataState
import com.utkuulasaltin.bluevalleyshop.domain.repository.UsersRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UsersRepositoryImpl @Inject constructor(private val usersRemoteDataSource: UsersRemoteDataSource): UsersRepository {
    override suspend fun getUser(userId: Int): Flow<DataState<UserResponse>> {
        return usersRemoteDataSource.getUser(userId)
    }

}