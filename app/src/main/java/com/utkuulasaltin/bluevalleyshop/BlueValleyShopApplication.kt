package com.utkuulasaltin.bluevalleyshop

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class BlueValleyShopApplication : Application() {
    override fun onCreate() {
        super.onCreate()
    }
}