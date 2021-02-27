package com.example.xmtify.di

import com.example.xmtify.data.network.XmtifityApiService
import com.example.xmtify.data.network.XmtifyApi
import com.example.xmtify.model.User
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {
    @Singleton
    @Provides
    fun provideApi():XmtifyApi=XmtifityApiService.getClient()

    @Provides
    fun provideUserList()=ArrayList<User>()
}