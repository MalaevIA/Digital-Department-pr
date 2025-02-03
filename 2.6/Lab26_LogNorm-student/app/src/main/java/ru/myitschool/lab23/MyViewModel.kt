package ru.myitschool.lab23

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel : ViewModel() {
    val result = MutableLiveData<Double>()
    fun setValue(d: Double){
        result.value = d
    }
}