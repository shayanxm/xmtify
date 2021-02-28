package com.example.xmtify.di

import com.example.xmtify.XmtifyApplication
import com.example.xmtify.repository.UserListRepository
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ActivityBindingModule::class,
        AppModule::class]
)
interface AppComponent : AndroidInjector<DaggerApplication> {
//    fun inject(userListRepository: UserListRepository)


    //sharedperefrences
    fun inject(application: XmtifyApplication)
    override fun inject(instance: DaggerApplication?)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: XmtifyApplication): Builder
        fun build(): AppComponent
    }

}