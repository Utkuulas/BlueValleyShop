package com.utkuulasaltin.bluevalleyshop.domain.repository.impl

import com.utkuulasaltin.bluevalleyshop.data.model.CartResponse
import com.utkuulasaltin.bluevalleyshop.data.remote.source.CartsRemoteDataSource
import com.utkuulasaltin.bluevalleyshop.data.remote.utils.DataState
import com.utkuulasaltin.bluevalleyshop.domain.repository.CartsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CartsRepositoryImpl @Inject constructor(private val cartsRemoteDataSource: CartsRemoteDataSource): CartsRepository {
    override suspend fun getCart(cartId: Int): Flow<DataState<CartResponse>> {
        return cartsRemoteDataSource.getCart(cartId)
    }
}