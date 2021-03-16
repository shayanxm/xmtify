package com.example.xmtify.view.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.xmtify.model.DataModel
import com.example.xmtify.repository.UserRepo

class MainActivityViewModel : ViewModel(){
    private val model = DataModel(userEmail = "Here's the updated text!")
//private val user
    // Create MutableLiveData which MainFragment can subscribe to
    // When this data changes, it triggers the UI to do an update
    val uiTextLiveData = MutableLiveData<String>()

    // Get the updated text from our model and post the value to MainFragment
    fun getUpdatedText() {
        val updatedText =UserRepo.useremail
Log.e("wrokins","justwordk")
        Log.e("wrokins",UserRepo.useremail)
        uiTextLiveData.postValue(updatedText)
    }
}