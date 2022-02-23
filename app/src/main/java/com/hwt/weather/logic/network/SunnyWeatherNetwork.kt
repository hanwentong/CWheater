package com.hwt.weather.logic.network

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

/**
 *  作者 : hwt
 *  日期 : 2022/2/21 16:17
 *  描述 :
 */
object SunnyWeatherNetwork {

    private val weatherService = ServiceCreator.create<WeatherService>()

    suspend fun getDail(lng: String, lat: String) = weatherService.getDailyWeather(lng, lat).await()

    suspend fun getRealTime(lng: String, lat: String) =
        weatherService.getRealtimeWeather(lng, lat).await()

    private val placeService = ServiceCreator.create<PlaceService>()

    suspend fun searchPlaces(query: String) = placeService.searchPlaces(query).await()

    private suspend fun <T> Call<T>.await(): T {
        return suspendCoroutine { continuation ->
            enqueue(object : Callback<T> {
                override fun onResponse(call: Call<T>, response: Response<T>) {
                    val body = response.body()
                    if (body != null) continuation.resume(body)
                    else continuation.resumeWithException(
                        RuntimeException("response body is null")
                    )
                }

                override fun onFailure(call: Call<T>, t: Throwable) {
                    continuation.resumeWithException(t)
                }
            })
        }
    }
}