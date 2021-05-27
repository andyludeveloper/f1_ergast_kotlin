package com.andylu.f1_ergast_kotlin.service

import com.andylu.f1_ergast_kotlin.model.API
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface F1ApiService {
    @GET("f1/drivers.json")
    suspend fun getData(@Query("limit") limit:Int): Response<API>
}