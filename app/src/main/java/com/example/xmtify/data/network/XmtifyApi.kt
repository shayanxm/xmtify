package com.example.xmtify.data.network

import com.example.xmtify.model.User
import com.example.xmtify.model.UserList
import io.reactivex.Flowable
import io.reactivex.Observer
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface XmtifyApi {
//    @GET("extend")
//    fun getTest(
//        @Query("api_key") apiKey: String
//    ): Flowable<UserList>
    @GET("/v1/me")
    fun getUserInfo(
        @Header("Authorization") token: String
    ): Flowable<User>

}