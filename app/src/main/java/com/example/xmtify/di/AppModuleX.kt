package com.example.xmtify.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.example.xmtify.data.generator.UserGenerator
import com.example.xmtify.data.network.XmtifityApiService
import com.example.xmtify.data.network.XmtifyApi
import com.example.xmtify.model.User
import dagger.Module
import dagger.Provides
import javax.inject.Singleton
@Module
class AppModuleX {
    @Singleton
    @Provides
    fun provideApi(): XmtifyApi = XmtifityApiService.getClient()

@Singleton
    @Provides
    fun provideUser()= User()

    @Provides
    @Singleton
    fun provideSharedPref(context: Application):UserGenerator=
        UserGenerator(context)

    @Provides
    @Singleton
    fun  provideShared(context: Application): SharedPreferences {
        return context.getSharedPreferences("PATH", Context.MODE_PRIVATE)

    }

//    @Provides
//    @Singleton
//    fun provideContext(context: Application):Application{
//        return context
//    }

}