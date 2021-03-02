package com.example.viewpaygerexample.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.viewpaygerexample.R
import com.example.viewpaygerexample.`object`.Apple

class HomeViewModel(application: Application) : AndroidViewModel(application) {

    private val mContext = getApplication<Application>().applicationContext
    private var _homeliveData = MutableLiveData<List<Apple>>()
    val homeliveData: LiveData<List<Apple>> get() = _homeliveData

    init {
        val newList = ArrayList<Apple>()
        newList.add(Apple("1", R.drawable.h1))
        newList.add(Apple("2", R.drawable.h2))
        newList.add(Apple("3", R.drawable.h3))
        newList.add(Apple("4", R.drawable.h4))
        newList.add(Apple("5", R.drawable.h5))
        newList.add(Apple("6", R.drawable.h6))
        newList.add(Apple("7", R.drawable.h1))
        newList.add(Apple("8", R.drawable.h3))
        newList.add(Apple("9", R.drawable.h4))
        newList.add(Apple("10", R.drawable.h3))
        newList.add(Apple("11", R.drawable.h6))
        newList.add(Apple("12", R.drawable.h2))
        newList.add(Apple("13", R.drawable.h1))
        newList.add(Apple("14", R.drawable.h3))
        newList.add(Apple("15", R.drawable.h5))
        newList.add(Apple("16", R.drawable.h7))

        _homeliveData.value = newList
    }

    fun delete(data: Apple) {
        val listData = ArrayList(_homeliveData.value)
        val newList = ArrayList<Apple>()
        for (item in listData) {
            if (data.title != item.title) {
                newList.add(item)
            }
        }
        _homeliveData.value = newList
    }
}