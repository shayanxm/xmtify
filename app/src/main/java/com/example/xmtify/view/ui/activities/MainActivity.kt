package com.example.xmtify.view.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.example.xmtify.R
import com.example.xmtify.XmtifyApplication
import com.example.xmtify.data.generator.UserGenerator
import com.example.xmtify.data.network.XmtifyApi
import com.example.xmtify.di.DaggerAppComponentX

import com.example.xmtify.model.User
import com.example.xmtify.view.ui.fragment.MainFragment

import dagger.android.DaggerApplication_MembersInjector.create
import javax.inject.Inject

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    @Inject
    lateinit var user:User
@Inject
lateinit var userGenerator: UserGenerator
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {

            // Adds our fragment
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add<MainFragment>(R.id.fragment_container_view)
            }}


        setContentView(R.layout.activity_main)

DaggerAppComponentX.create().inject(this)
//        Log.e("rxisworking","justmain")
//
//      DaggerAppComponentX.create().inject(this)
//     Log.e("rxisworking","from main user is : ${user.displayName}")
//   //     var userGenerator:UserGenerator
//       // userGenerator= UserGenerator()
//      //  userGenerator.getUser()
//     //   userGenerator.getUser()
//        Log.e("rxisworking","from main user is : sdfasdf}")
//        Log.e("order","main")
//        Log.e("red","from main user is : ${user.displayName}")
//        Log.e("red","from main user is : ${user.email}")
    }
}