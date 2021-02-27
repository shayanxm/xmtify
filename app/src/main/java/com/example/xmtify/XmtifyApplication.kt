package com.example.xmtify

import android.app.Application

class XmtifyApplication:Application() {
    companion object {
        lateinit var instance:XmtifyApplication
    }
    init {
        instance=this
    }

    override fun onCreate() {
        super.onCreate()
    }
}