package com.hwt.weather.logic.dao

import android.content.Context
import androidx.core.content.edit
import com.google.gson.Gson
import com.hwt.weather.MyApplication
import com.hwt.weather.logic.model.Place

/**
 *  作者 : hwt
 *  日期 : 2022/2/23 10:24
 *  描述 :
 */
object PlaceDao {

    fun savePlace(place: Place) {
        sharedPreferences().edit {
            putString("place", Gson().toJson(place))
        }
    }

    fun getSavePlace(): Place {
        val placeJson = sharedPreferences().getString("place", "")
        return Gson().fromJson(placeJson, Place::class.java)
    }

    fun isPlaceSaved() = sharedPreferences().contains("place")

    private fun sharedPreferences() =
        MyApplication.context.getSharedPreferences("sunny_weather", Context.MODE_PRIVATE)

}