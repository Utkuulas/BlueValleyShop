package com.utkuulasaltin.bluevalleyshop.data.remote.api

import com.utkuulasaltin.bluevalleyshop.data.model.ProductResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ProductsService {
    @GET("products")
    suspend fun getProducts(): Response<ProductResponse>

    @GET("products/{id}")
    suspend fun getProductById(@Path("{id}") id: Int): Response<ProductResponse>
}