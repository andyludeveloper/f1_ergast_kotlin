package com.andylu.f1_ergast_kotlin.model

import com.google.gson.annotations.SerializedName

data class API(
    @SerializedName("MRData")
    val mrData: MRData
)

data class MRData(

    val xmlns: String,
    val series: String,
    val url: String,
    val limit: String,
    val offset: String,
    val total: String,
    @SerializedName("DriverTable")
    val driverTable: DriverTable
)

data class DriverTable(
    @SerializedName("Drivers")
    val drivers: List<Driver>
)

data class Driver(
    val dateOfBirth: String,
    val driverId: String,
    val familyName: String,
    val givenName: String,
    val nationality: String,
    val url: String
)