package com.hwt.weather.logic.network

import com.hwt.weather.MyApplication
import com.hwt.weather.logic.model.PlaceResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 *  作者 : hwt
 *  日期 : 2022/2/21 16:02
 *  描述 :
 */
interface PlaceService {

    @GET("v2/place?token=${MyApplication.TOKEN}&lang=zh_CN")
    fun searchPlaces(@Query("query") query: String): Call<PlaceResponse>

}