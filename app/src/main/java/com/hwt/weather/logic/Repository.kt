package com.hwt.weather.logic

import androidx.lifecycle.liveData
import com.hwt.weather.logic.model.Place
import com.hwt.weather.logic.network.SunnyWeatherNetwork
import kotlinx.coroutines.Dispatchers

/**
 *  作者 : hwt
 *  日期 : 2022/2/21 17:03
 *  描述 :
 */
object Repository {

    fun searchPlaces(query: String) = liveData(Dispatchers.IO) {
        val result = try {
            val placeResponse = SunnyWeatherNetwork.searchPlaces(query)
            if (placeResponse.status == "ok") {
                val places = placeResponse.places
                Result.success(places)
            } else {
                Result.failure(RuntimeException("response status is ${placeResponse.status}"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
        emit(result)

    }
}