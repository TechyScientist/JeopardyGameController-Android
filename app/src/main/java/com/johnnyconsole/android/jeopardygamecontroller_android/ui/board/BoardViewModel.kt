package com.johnnyconsole.android.jeopardygamecontroller_android.ui.board

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BoardViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is the Board Fragment"
    }
    val text: LiveData<String> = _text
}