package com.example.viewpaygerexample

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    private var _homeliveData = MutableLiveData<String>()
    val homeliveData: LiveData<String> get() = _homeliveData


}