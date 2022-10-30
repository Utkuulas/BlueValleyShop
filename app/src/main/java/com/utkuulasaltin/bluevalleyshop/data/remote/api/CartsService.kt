package com.utkuulasaltin.bluevalleyshop.data.remote.api

import com.utkuulasaltin.bluevalleyshop.data.model.CartResponse
import com.utkuulasaltin.bluevalleyshop.data.model.Product
import retrofit2.Response
import retrofit2.http.*

interface CartsService {
    @GET("carts")
    suspend fun getCarts(): Response<CartResponse>

    @GET("carts/{id}")
    suspend fun getCartById(@Path("{id}") id: Int): Response<CartResponse>

    @PUT("carts/{id}")
    suspend fun updateCart(
        @Path("{id}") id: Int,
        @Field("products") products: List<Product>
    ): Response<CartResponse>

    @DELETE("carts/{id}")
    suspend fun deleteCart(@Path("{id}") id: Int): Response<CartResponse>
}