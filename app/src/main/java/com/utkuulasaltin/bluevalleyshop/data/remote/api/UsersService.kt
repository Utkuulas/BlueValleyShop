package com.utkuulasaltin.bluevalleyshop.data.remote.api

import com.utkuulasaltin.bluevalleyshop.data.model.UserResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface UsersService {
    @GET("users")
    suspend fun getUsers(): Response<UserResponse>

    @GET("products/{id}")
    suspend fun getUserById(@Path("{id}") id: Int): Response<UserResponse>
}