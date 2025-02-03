package ru.myitschool.lab23

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.math.exp
import kotlin.math.sqrt

class MyViewModel : ViewModel() {
    val mu = MutableLiveData<Double>()
    val sigma2 = MutableLiveData<Double>()
    val result = MutableLiveData<Double>()
    fun generateLogNormal(): Double {
        val sigma = sqrt((sigma2.value ?: 1.0))
        val random = java.util.Random() // Используем java.util.Random
        val normalValue = random.nextGaussian() // Генерация нормального числа
        return exp((mu.value ?: 0.0) + sigma * normalValue) // Преобразование в логнормальное
    }
}