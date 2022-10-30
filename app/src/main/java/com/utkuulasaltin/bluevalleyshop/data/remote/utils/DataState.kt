package com.utkuulasaltin.bluevalleyshop.data.remote.utils

import com.utkuulasaltin.bluevalleyshop.data.model.ApiError

sealed class DataState<T> {
    data class Success<T>(val data: T): DataState<T>()
    data class Error<T>(val message: ApiError?): DataState<T>()
    class Loading<T>: DataState<T>()
}
