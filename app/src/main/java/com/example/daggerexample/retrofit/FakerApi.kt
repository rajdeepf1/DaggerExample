package com.example.daggerexample.retrofit

import com.example.daggerexample.models.Product
import retrofit2.Response
import retrofit2.http.GET

interface FakerApi {
    @GET("products")
    suspend fun getProducts(): Response<List<Product>>
}