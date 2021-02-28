package com.example.xmtify

import android.app.Application
import com.example.xmtify.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class XmtifyApplication:DaggerApplication() {
    companion object {
        lateinit var instance:XmtifyApplication
    }
    init {
        instance=this
    }

    override fun onCreate() {
        super.onCreate()
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
    val appComponent=DaggerAppComponent.builder()
        .application(this)
        .build()
        appComponent.inject(this)
        return appComponent
    }

}