package com.andylu.f1_ergast_kotlin.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.andylu.f1_ergast_kotlin.model.Driver
import com.andylu.f1_ergast_kotlin.repository.F1DriverRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DriverViewModel
@Inject
constructor(private val repository: F1DriverRepository) : ViewModel() {
    init {
        loadData()
    }

    private var _data = MutableLiveData<List<Driver>>()
    val data: LiveData<List<Driver>> = _data

    private fun loadData() {
        viewModelScope.launch {
            repository.getF1Drivers().let { response ->
                if (response.isSuccessful) {
                    _data.postValue(response.body()!!.mrData.driverTable.drivers)
                } else {
                    Log.d("DataViewModel", "onFailure: ${response.message()}")
                }
            }
        }
    }
}