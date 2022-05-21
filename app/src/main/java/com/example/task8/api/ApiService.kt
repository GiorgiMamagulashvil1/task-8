package com.example.task8.api

import com.example.task8.model.Resources
import com.example.task8.model.ResourcesDto
import com.example.task8.model.SingleResourceDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("/api/unknown")
    suspend fun getResources(): Response<ResourcesDto>

    @GET("/api/unknown/{id}")
    suspend fun getSingleResource(
        @Path("id") id: Int
    ): Response<SingleResourceDto>

}