package com.delta.soft

import android.app.Application

class MyApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        RemoteConfigUtils.init()
    }
}