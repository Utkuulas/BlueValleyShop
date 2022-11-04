package com.utkuulasaltin.bluevalleyshop.domain.repository

import com.utkuulasaltin.bluevalleyshop.data.model.ProductResponse
import com.utkuulasaltin.bluevalleyshop.data.model.ProductResponseItem
import com.utkuulasaltin.bluevalleyshop.data.remote.utils.DataState
import kotlinx.coroutines.flow.Flow

interface ProductsRepository {
    suspend fun getProductDetail(productId: Int): Flow<DataState<ProductResponse>>
    suspend fun getProducts(): Flow<DataState<ProductResponse>>
}