package com.example.xmtify.di

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
    @Singleton
    @Provides
    fun provideUserGenerator()=UserGenerator()


}