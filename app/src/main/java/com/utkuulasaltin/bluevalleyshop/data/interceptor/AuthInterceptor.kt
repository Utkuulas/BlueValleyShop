package com.utkuulasaltin.bluevalleyshop.data.interceptor

import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class AuthInterceptor @Inject constructor(): Interceptor{
    override fun intercept(chain: Interceptor.Chain): Response {
        val requestBuilder = chain.request()

        return  chain.proceed(requestBuilder)
    }

}