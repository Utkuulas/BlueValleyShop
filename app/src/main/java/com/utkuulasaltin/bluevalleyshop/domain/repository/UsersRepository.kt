package com.utkuulasaltin.bluevalleyshop.domain.repository

import com.utkuulasaltin.bluevalleyshop.data.model.UserResponse
import com.utkuulasaltin.bluevalleyshop.data.remote.utils.DataState
import kotlinx.coroutines.flow.Flow

interface UsersRepository {
    suspend fun getUser(userId: Int): Flow<DataState<UserResponse>>
}