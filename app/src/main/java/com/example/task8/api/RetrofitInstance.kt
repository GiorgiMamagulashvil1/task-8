package com.example.task8.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private val retrofit: Retrofit by lazy {
        return@lazy Retrofit.Builder().baseUrl("https://reqres.in/")
            .addConverterFactory(GsonConverterFactory.create()).build()
    }

    val api: ApiService by lazy {
        return@lazy retrofit.create(ApiService::class.java)
    }
}