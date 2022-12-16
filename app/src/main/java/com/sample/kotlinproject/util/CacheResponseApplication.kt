package com.sample.kotlinproject.util

import android.app.Application
import android.content.Context

class CacheResponseApplication :Application(){
    override fun onCreate() {
        super.onCreate()
        appContext = applicationContext
    }

    companion object {

        lateinit  var appContext: Context

    }
}