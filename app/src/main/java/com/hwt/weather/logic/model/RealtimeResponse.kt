package com.hwt.weather.logic.model

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName

/**
 *  作者 : hwt
 *  日期 : 2022/2/22 13:57
 *  描述 :
 */

data class RealtimeResponse(val status: String, val result: Result) {

    data class Result(val realtime: Realtime)

    data class Realtime(
        val skycon: String, val temperature: Float,
        @SerializedName("air_quality") val airQuality: AirQuality

    )

    data class AirQuality(val aqi: AQI)

    data class AQI(val chn: Float)
}