package com.andylu.f1_ergast_kotlin.repository

import com.andylu.f1_ergast_kotlin.service.F1ApiService
import javax.inject.Inject

class F1DriverRepository
@Inject
constructor(private val apiService: F1ApiService) {
    suspend fun getF1Drivers() = apiService.getData(10)
}