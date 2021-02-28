package com.example.xmtify.di

import com.example.xmtify.view.ui.activities.SplashActivity
import dagger.Binds
import dagger.Module

@Module
abstract class SplashActivityModule {
    @Binds
    internal abstract fun provideSplashActivity(activity:SplashActivity):SplashActivity
}