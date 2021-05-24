package com.andylu.f1_ergast_kotlin.service

import com.andylu.f1_ergast_kotlin.model.API
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface F1ApiService {
    @GET("f1/drivers.json")
    fun getData(@Query("limit") limit:Int): Call<API>
}