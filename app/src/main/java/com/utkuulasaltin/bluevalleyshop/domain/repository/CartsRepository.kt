package com.utkuulasaltin.bluevalleyshop.domain.repository

import com.utkuulasaltin.bluevalleyshop.data.model.CartResponse
import com.utkuulasaltin.bluevalleyshop.data.remote.utils.DataState
import kotlinx.coroutines.flow.Flow

interface CartsRepository {
    suspend fun getCart(cartId: Int): Flow<DataState<CartResponse>>
}