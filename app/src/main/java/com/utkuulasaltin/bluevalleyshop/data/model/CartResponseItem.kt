package com.utkuulasaltin.bluevalleyshop.data.model


import com.google.gson.annotations.SerializedName

data class CartResponseItem(
    @SerializedName("date")
    val date: String?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("products")
    val products: List<Product?>?,
    @SerializedName("userId")
    val userId: Int?,
    @SerializedName("__v")
    val v: Int?
)