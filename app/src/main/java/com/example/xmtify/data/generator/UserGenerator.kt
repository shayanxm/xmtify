package com.example.xmtify.data.generator

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import com.example.xmtify.data.network.XmtifyApi
import com.example.xmtify.di.DaggerAppComponent
import com.example.xmtify.di.DaggerAppComponentX
import com.example.xmtify.model.User
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Consumer
import io.reactivex.processors.PublishProcessor
import io.reactivex.schedulers.Schedulers
import java.util.*
import javax.inject.Inject


class UserGenerator(context: Context) {
    @Inject
    lateinit var xmtifyApi: XmtifyApi
    @Inject
    lateinit var sharedPreferences: SharedPreferences
    var compositeDisposable = CompositeDisposable()

    var disposable: Disposable? = null

    init {
        Log.e("order","gene init")

        DaggerAppComponentX.builder().application(context.applicationContext as Application).build().inject(this)
        Log.e("xxx","justlunching")
        getUser()
    }
    public fun getUser() {
//        var tokenx = getFromSharedPrefences()
//        xmtifyApi.getUserInfo(tokenx)
//            .onSubscribe(Schedulers.io())

        Log.e("xxx","just called ")




//
//            val choresChanged = PublishProcessor.create<Unit>() //Think of a Unit as of void in Java
//
//        val userFlowable = choresChanged
//            .flatMap { xmtifyApi.getUserInfo(getFromSharedPrefences()) }
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())


//
//        val compositeDisposable = CompositeDisposable()
//        compositeDisposable.add(
//            xmtifyApi.getUserInfo("BQALyt1nRCORtMhqSuZd9dNGu_c1lLtCS6rIBh0uq6Hy0HJhjt4ztR7tCBxlDZaEa_zoELlAoKNNSDTMERuLeGJDaPZg0-WQW-v-CTkeZcFSru7EAi4iIueo01q0E2Bc2g_c9W1kLjghqRlo2vqtyAU")
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribeOn(Schedulers.io())
//                .subscribe({response -> onResponse(response)}, {t -> onFailure(t) }))
//
//
//

getfun()
        getFromSharedPrefences()

        Log.e("xxx","getfzzzz")




        }

    private fun getfun() {
        Log.e("xxx","getf")
        Log.e("order","create")
        disposable =
            xmtifyApi.getUserInfo("Bearer "+getFromSharedPrefences())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    { result -> Log.e("xxxz",result.displayName+result.email+result.id+"suuxxx") },
                    { error ->    Log.e("xxxz",(error.message)) }
                )
    }
    private fun getFromSharedPrefences(): String {
        //   val sharedPref = this.getPreferences(Context.MODE_PRIVATE)

        val defultValue = "x"
        val token = sharedPreferences.getString("TOKEN", defultValue)
        Log.e("orderx",token)
        return token!!
    }
    private fun onFailure(t: Throwable) {
    //    Toast.makeText(this,t.message, Toast.LENGTH_SHORT).show()
        t.localizedMessage
        Log.e("rxisworking","failed "+t.localizedMessage)
    }

    private fun onResponse(response: User) {
        Log.e("rxisworking","response with${response.displayName} ")
      //  progress_bar.visibility = View.GONE
//        recyclerView.apply {
//            setHasFixedSize(true)
//            layoutManager = LinearLayoutManager(this@MainActivity)
//            adapter =
//                MoviesAdapter(response.results)
//        }

    }
}