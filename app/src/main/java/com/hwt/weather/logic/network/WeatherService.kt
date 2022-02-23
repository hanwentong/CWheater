package com.hwt.weather.logic.network

import com.hwt.weather.MyApplication
import com.hwt.weather.logic.model.DailResponse
import com.hwt.weather.logic.model.RealtimeResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

/**
 *  作者 : hwt
 *  日期 : 2022/2/22 14:45
 *  描述 :
 */
interface WeatherService {

    @GET("v2.5/${MyApplication.TOKEN}/{lng},{lat}/realtime.json")
    fun getRealtimeWeather(@Path("lng") lng: String, @Path("lat") lat: String)
            : Call<RealtimeResponse>

    @GET("v2.5/${MyApplication.TOKEN}/{lng},{lat}/daily.json")
    fun getDailyWeather(@Path("lng") lng: String, @Path("lat") lat: String)
            : Call<DailResponse>
}