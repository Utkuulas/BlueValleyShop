package com.utkuulasaltin.bluevalleyshop.domain.repository.impl

import com.utkuulasaltin.bluevalleyshop.data.model.ProductResponse
import com.utkuulasaltin.bluevalleyshop.data.remote.source.ProductsRemoteDataSource
import com.utkuulasaltin.bluevalleyshop.data.remote.utils.DataState
import com.utkuulasaltin.bluevalleyshop.domain.repository.ProductsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ProductsRepositoryImpl @Inject constructor(private val productsRemoteDataSource: ProductsRemoteDataSource): ProductsRepository {
    override suspend fun getProductDetail(productId: Int): Flow<DataState<ProductResponse>> {
        return productsRemoteDataSource.getProduct(productId)
    }

    override suspend fun getProducts(): Flow<DataState<ProductResponse>> {
        return productsRemoteDataSource.getProducts()
    }

}