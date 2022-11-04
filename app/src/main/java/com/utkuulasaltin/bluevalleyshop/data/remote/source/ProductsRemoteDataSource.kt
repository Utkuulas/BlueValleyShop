package com.utkuulasaltin.bluevalleyshop.data.remote.source

import com.utkuulasaltin.bluevalleyshop.data.model.ProductResponse
import com.utkuulasaltin.bluevalleyshop.data.model.ProductResponseItem
import com.utkuulasaltin.bluevalleyshop.data.remote.utils.DataState
import kotlinx.coroutines.flow.Flow

interface ProductsRemoteDataSource {
    suspend fun getProduct(productId: Int) : Flow<DataState<ProductResponse>>
    suspend fun getProducts(): Flow<DataState<ProductResponse>>
}