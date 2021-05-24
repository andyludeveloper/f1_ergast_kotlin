package com.andylu.f1_ergast_kotlin.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.andylu.f1_ergast_kotlin.model.API
import com.andylu.f1_ergast_kotlin.model.Driver
import com.andylu.f1_ergast_kotlin.service.F1ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class DriverViewModel : ViewModel() {
    private val baseUrl = "https://ergast.com/api/"
    private val retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    private val api = retrofit.create(F1ApiService::class.java)

    init {
        loadData()
    }

    private var _data = MutableLiveData<List<Driver>>()
    val data: LiveData<List<Driver>> = _data

    private fun loadData() {
        api.getData(10).enqueue(object : Callback<API> {

            override fun onResponse(call: Call<API>, response: Response<API>) {
                _data.value = response.body()!!.mrData.driverTable.drivers
            }

            override fun onFailure(call: Call<API>, t: Throwable) {
                Log.d("DataViewModel", "onFailure: ${t.message}")
            }
        })
    }
}