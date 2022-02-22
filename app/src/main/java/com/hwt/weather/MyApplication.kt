package com.hwt.weather

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context

/**
 *  作者 : hwt
 *  日期 : 2022/2/21 15:51
 *  描述 :
 */
class MyApplication : Application() {

    companion object {

        // 填入你申请到的令牌值
        const val TOKEN = "BNBRvBveaD2VfHVI"

        @SuppressLint("StaticFieldLeak")
        lateinit var context: Context
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }

}