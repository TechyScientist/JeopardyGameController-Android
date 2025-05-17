package com.johnnyconsole.android.jeopardygamecontroller_android.ui.sendtoboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SendToBoardViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is the Send To Board Fragment"
    }
    val text: LiveData<String> = _text
}