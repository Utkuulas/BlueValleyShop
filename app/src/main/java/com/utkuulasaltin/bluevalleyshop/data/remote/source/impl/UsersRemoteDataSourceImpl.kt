package com.utkuulasaltin.bluevalleyshop.data.remote.source.impl

import com.utkuulasaltin.bluevalleyshop.data.model.UserResponse
import com.utkuulasaltin.bluevalleyshop.data.remote.api.UsersService
import com.utkuulasaltin.bluevalleyshop.data.remote.source.UsersRemoteDataSource
import com.utkuulasaltin.bluevalleyshop.data.remote.utils.DataState
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UsersRemoteDataSourceImpl @Inject constructor(val usersService: UsersService): BaseRemoteDataSource(), UsersRemoteDataSource {
    override suspend fun getUser(userId: Int): Flow<DataState<UserResponse>> {
        return getResult { usersService.getUserById(userId) }
    }
}