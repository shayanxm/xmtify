package com.example.xmtify.di

import com.example.xmtify.repository.UserListRepository
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
    fun inject(userListRepository: UserListRepository)
}