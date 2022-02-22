package com.hwt.weather.logic.model

import com.google.gson.annotations.SerializedName

/**
 *  作者 : hwt
 *  日期 : 2022/2/21 15:56
 *  描述 :
 */
data class PlaceResponse(val status: String, val places: List<Place>)

data class Place(
    val name: String,
    val location: Location,
    @SerializedName("formatted_address") val address: String
)

data class Location(val lng: String, val lat: String)