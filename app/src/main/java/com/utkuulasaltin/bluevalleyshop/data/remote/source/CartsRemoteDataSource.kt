package com.utkuulasaltin.bluevalleyshop.data.remote.source

import com.utkuulasaltin.bluevalleyshop.data.model.CartResponse
import com.utkuulasaltin.bluevalleyshop.data.remote.utils.DataState
import kotlinx.coroutines.flow.Flow

interface CartsRemoteDataSource {
    suspend fun getCart(cartId: Int) : Flow<DataState<CartResponse>>
}