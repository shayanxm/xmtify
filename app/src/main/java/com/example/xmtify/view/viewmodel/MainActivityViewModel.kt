package com.example.xmtify.view.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.xmtify.model.DataModel

class MainActivityViewModel : ViewModel(){
    private val model = DataModel(userEmail = "Here's the updated text!")

    // Create MutableLiveData which MainFragment can subscribe to
    // When this data changes, it triggers the UI to do an update
    val uiTextLiveData = MutableLiveData<String>()

    // Get the updated text from our model and post the value to MainFragment
    fun getUpdatedText() {
        val updatedText = model.userEmail
        uiTextLiveData.postValue(updatedText)
    }
}