package com.utkuulasaltin.bluevalleyshop.data.remote.source

import com.utkuulasaltin.bluevalleyshop.data.model.UserResponse
import com.utkuulasaltin.bluevalleyshop.data.remote.utils.DataState
import kotlinx.coroutines.flow.Flow

interface UsersRemoteDataSource {
    suspend fun getUser(userId: Int) : Flow<DataState<UserResponse>>
}