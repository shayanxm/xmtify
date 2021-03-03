package com.example.xmtify.view.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.xmtify.R
import com.example.xmtify.XmtifyApplication
import com.example.xmtify.data.generator.UserGenerator
import com.example.xmtify.data.network.XmtifyApi
import com.example.xmtify.di.DaggerAppComponentX

import com.example.xmtify.model.User

import dagger.android.DaggerApplication_MembersInjector.create
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var user:User
@Inject
lateinit var userGenerator: UserGenerator
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

DaggerAppComponentX.create().inject(this)
        Log.e("rxisworking","justmain")

      DaggerAppComponentX.create().inject(this)
     Log.e("rxisworking","from main user is : ${user.displayName}")
   //     var userGenerator:UserGenerator
       // userGenerator= UserGenerator()
      //  userGenerator.getUser()
     //   userGenerator.getUser()
        Log.e("rxisworking","from main user is : sdfasdf}")
        Log.e("order","main")
        Log.e("red","from main user is : ${user.displayName}")
        Log.e("red","from main user is : ${user.email}")
    }
}