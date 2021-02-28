package com.example.xmtify.view.ui.activities

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.xmtify.R
import com.example.xmtify.internal.AUTH_TOKEN_REQUEST_CODE
import com.example.xmtify.internal.CLIENT_IDX
import com.example.xmtify.internal.REDIRECT_URIX
import com.example.xmtify.internal.SCOPE
import com.spotify.sdk.android.auth.*
import com.spotify.sdk.android.auth.AccountsQueryParameters.CLIENT_ID
import com.spotify.sdk.android.auth.AccountsQueryParameters.REDIRECT_URI
import com.spotify.sdk.android.auth.AuthorizationResponse
import com.spotify.sdk.android.auth.LoginActivity.REQUEST_CODE


/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
class SplashActivity : AppCompatActivity() {

    lateinit private var editor: SharedPreferences.Editor
    lateinit private var sharedPreferences: SharedPreferences

    private lateinit var fullscreenContent: TextView
    private lateinit var fullscreenContentControls: LinearLayout
    private val hideHandler = Handler()

    @SuppressLint("InlinedApi")
    private val hidePart2Runnable = Runnable {
        // Delayed removal of status and navigation bar

        // Note that some of these constants are new as of API 16 (Jelly Bean)
        // and API 19 (KitKat). It is safe to use them, as they are inlined
        // at compile-time and do nothing on earlier devices.
        fullscreenContent.systemUiVisibility =
            View.SYSTEM_UI_FLAG_LOW_PROFILE or
                    View.SYSTEM_UI_FLAG_FULLSCREEN or
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE or
                    View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY or
                    View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION or
                    View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
    }
    private val showPart2Runnable = Runnable {
        // Delayed display of UI elements
        supportActionBar?.show()
        fullscreenContentControls.visibility = View.VISIBLE
    }
    private var isFullscreen: Boolean = false


    /**
     * Touch listener to use for in-layout UI controls to delay hiding the
     * system UI. This is to prevent the jarring behavior of controls going away
     * while interacting with activity UI.
     */
    private val delayHideTouchListener = View.OnTouchListener { view, motionEvent ->
        when (motionEvent.action) {
            MotionEvent.ACTION_DOWN -> if (AUTO_HIDE) {

            }
            MotionEvent.ACTION_UP -> view.performClick()
            else -> {
            }
        }
        false
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_splash)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        isFullscreen = true

        // Set up the user interaction to manually show or hide the system UI.
        fullscreenContent = findViewById(R.id.fullscreen_content)
        fullscreenContent.setOnClickListener { toggle() }


//        var tokenx = getFromSharedPrefences()
//        Log.e("tokinini", tokenx)
//
        getFromSharedPrefences().let {
            if (it != null && it != "") {
                startMainActivity()
            } else {
                openPage()
            }
        }




    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)

        // Trigger the initial hide() shortly after the activity has been
        // created, to briefly hint to the user that UI controls

    }

    private fun toggle() {
        if (isFullscreen) {
            hide()
        } else {
            show()
        }
    }

    private fun hide() {
        // Hide UI first
        supportActionBar?.hide()

        isFullscreen = false

        // Schedule a runnable to remove the status and navigation bar after a delay
        hideHandler.removeCallbacks(showPart2Runnable)
        hideHandler.postDelayed(hidePart2Runnable, UI_ANIMATION_DELAY.toLong())
    }

    private fun show() {
        // Show the system bar
        fullscreenContent.systemUiVisibility =
            View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or
                    View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
        isFullscreen = true

        // Schedule a runnable to display UI elements after a delay
        hideHandler.removeCallbacks(hidePart2Runnable)
        hideHandler.postDelayed(showPart2Runnable, UI_ANIMATION_DELAY.toLong())
    }

    /**
     * Schedules a call to hide() in [delayMillis], canceling any
     * previously scheduled calls.
     */

    companion object {
        /**
         * Whether or not the system UI should be auto-hidden after
         * [AUTO_HIDE_DELAY_MILLIS] milliseconds.
         */
        private const val AUTO_HIDE = true

        /**
         * If [AUTO_HIDE] is set, the number of milliseconds to wait after
         * user interaction before hiding the system UI.
         */
        private const val AUTO_HIDE_DELAY_MILLIS = 3000

        /**
         * Some older devices needs a small delay between UI widget updates
         * and a change of the status and navigation bar.
         */
        private const val UI_ANIMATION_DELAY = 300
    }

    private fun authenticatesSpotify() {
        var builder = AuthorizationRequest.Builder(
            CLIENT_IDX,
            AuthorizationResponse.Type.TOKEN,
            REDIRECT_URI
        )

        builder.setScopes(arrayOf<String>(SCOPE))
        var request = builder.build()
        AuthorizationClient.openLoginActivity(this, REQUEST_CODE, request)

    }

//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//        if (requestCode == REQUEST_CODE) {
//            val response: AuthorizationResponse = AuthorizationClient.getResponse(
//                resultCode,
//                intent
//            )
//            when (response.type) {
//                AuthorizationResponse.Type.TOKEN -> {
//                    editor = getSharedPreferences("SPOTIFY", 0).edit()
//
//                    editor.putString("token", response.getAccessToken())
//                    Log.d("STARTING", "GOT AUTH TOKEN")
//                    editor.apply()
//                    //waitForUserInfo()
//                }
//                else -> {
////todo
//                }
//            }
//        }
//
//    }
//
//
//


//    private fun waitForUserInfo() {
//        val userService = UserService(queue, msharedPreferences)
//        val user=User()
//        userService.get {
//            val user: User = userService.getUser()
//            editor = getSharedPreferences("SPOTIFY", 0).edit()
//            editor.putString("userid", user.id)
//            Log.d("STARTING", "GOT USER INFORMATION")
//            editor.commit()
//            startMainActivity()
//        }

    //   }
    private fun startMainActivity() {
        val newintent = Intent(this@SplashActivity, MainActivity::class.java)
        startActivity(newintent)
    }

    private fun openPage() {
        val request: AuthorizationRequest =
            getAuthenticationRequest(AuthorizationResponse.Type.TOKEN)!!
        AuthorizationClient.openLoginActivity(this, AUTH_TOKEN_REQUEST_CODE, request)
    }

    private fun getAuthenticationRequest(type: AuthorizationResponse.Type): AuthorizationRequest? {
        return AuthorizationRequest.Builder(
            CLIENT_IDX,
            type,
            getRedirectUri().toString()
        )
            .setShowDialog(false)
            .setScopes(arrayOf("user-read-email"))
            .setCampaign("your-campaign-token")
            .build()
    }

    private fun getRedirectUri(): Uri? {
        return Uri.parse(REDIRECT_URIX)
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        val response = AuthorizationClient.getResponse(resultCode, data)
        if (AUTH_TOKEN_REQUEST_CODE == requestCode) {

            var mAccessToken = ""

            mAccessToken = response.accessToken
            Log.e("showex", "$mAccessToken")
            saveToSharedPrefences(mAccessToken)
            startMainActivity()
        }
    }

    private fun saveToSharedPrefences(token: String) {
        val sharedPrefef = this.getPreferences(Context.MODE_PRIVATE) ?: return
        with(sharedPrefef.edit()) {
            putString(getString(R.string.TOKEN), token)
            apply()
        }
    }

    private fun getFromSharedPrefences(): String {
        val sharedPref = this.getPreferences(Context.MODE_PRIVATE)
        val defultValue = ""
        val token = sharedPref.getString(getString(R.string.TOKEN), defultValue)
        return token!!
    }
}