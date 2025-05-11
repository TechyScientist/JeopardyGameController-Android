package com.johnnyconsole.android.jeopardygamecontroller_android.ui.export_board

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ExportBoardViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is the Export Board Fragment"
    }
    val text: LiveData<String> = _text
}