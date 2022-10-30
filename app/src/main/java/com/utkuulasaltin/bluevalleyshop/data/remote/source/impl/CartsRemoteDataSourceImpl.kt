package com.utkuulasaltin.bluevalleyshop.data.remote.source.impl

import com.utkuulasaltin.bluevalleyshop.data.model.CartResponse
import com.utkuulasaltin.bluevalleyshop.data.remote.api.CartsService
import com.utkuulasaltin.bluevalleyshop.data.remote.source.CartsRemoteDataSource
import com.utkuulasaltin.bluevalleyshop.data.remote.utils.DataState
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CartsRemoteDataSourceImpl @Inject constructor(val cartsService: CartsService) : BaseRemoteDataSource(), CartsRemoteDataSource  {
    override suspend fun getCart(cartId: Int): Flow<DataState<CartResponse>> {
        return getResult { cartsService.getCartById(cartId) }
    }
}