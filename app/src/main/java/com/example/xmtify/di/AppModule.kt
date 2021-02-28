package com.example.xmtify.di

import android.content.Context
import android.content.SharedPreferences
import com.example.xmtify.XmtifyApplication
import com.example.xmtify.data.network.XmtifityApiService
import com.example.xmtify.data.network.XmtifyApi
import com.example.xmtify.model.User
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
abstract class AppModule {
//    @Singleton
//    @Provides
//    fun provideApi():XmtifyApi=XmtifityApiService.getClient()
//
//    @Provides
//    fun provideUserList()=ArrayList<User>()



    //shared pref
@Binds
abstract fun provideContext(application: XmtifyApplication):Context

@Module
companion object{
    @JvmStatic
    @Provides
    fun provideSharedPrefernces(context: Context):SharedPreferences=
        context.getSharedPreferences("sharedPreferences",Context.MODE_PRIVATE)
}
}