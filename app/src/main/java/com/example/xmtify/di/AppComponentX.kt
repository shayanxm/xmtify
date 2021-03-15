package com.example.xmtify.di

import android.app.Application
import com.example.xmtify.data.generator.UserGenerator
import com.example.xmtify.model.User
import com.example.xmtify.view.ui.activities.MainActivity
import com.example.xmtify.view.ui.activities.SplashActivity
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModuleX::class])
interface AppComponentX {
    fun inject(mainActivity: MainActivity)
    fun inject(userGenerator: UserGenerator)
    fun inject(splashActivity: SplashActivity)


    @Component.Builder
    interface Builder {

        fun build(): AppComponentX

        @BindsInstance
        fun application(application: Application): Builder
    }

}