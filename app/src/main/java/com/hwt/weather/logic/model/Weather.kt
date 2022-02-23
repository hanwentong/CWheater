package com.hwt.weather.logic.model

/**
 *  作者 : hwt
 *  日期 : 2022/2/22 14:43
 *  描述 :
 */
data class Weather(val realtime: RealtimeResponse.Realtime, val daily: DailResponse.Daily)
