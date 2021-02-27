package com.example.xmtify.data.network

import com.example.xmtify.model.UserList
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Query

interface XmtifyApi {
    @GET("extend")
    fun getTest(
        @Query("api_key") apiKey: String
    ): Flowable<UserList>

}