package com.utkuulasaltin.bluevalleyshop.data.remote.source.impl

import com.utkuulasaltin.bluevalleyshop.data.model.ProductResponse
import com.utkuulasaltin.bluevalleyshop.data.remote.api.ProductsService
import com.utkuulasaltin.bluevalleyshop.data.remote.source.ProductsRemoteDataSource
import com.utkuulasaltin.bluevalleyshop.data.remote.utils.DataState
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ProductsRemoteDataSourceImpl @Inject constructor(val productsService: ProductsService): BaseRemoteDataSource(), ProductsRemoteDataSource {
    override suspend fun getProduct(productId: Int): Flow<DataState<ProductResponse>> {
        return getResult { productsService.getProductById(productId) }
    }

}