package ru.myitschool.lab23

import android.content.Context
import kotlin.math.pow
import kotlin.time.times

class MetricsData(context: Context, private val lower: Int, private val upper: Int) {

    val units : List<String> = context.resources.getStringArray(R.array.text_view_captions).toList()
    val ten : Double = 10.0
    // Фильтруем список по границам lower-upper
    fun getFilteredUnits(): List<String> {
        return units.subList(lower, upper + 1)
    }
    fun FromAnyToMetres(value: Double, fromIndex: Int): Double {
        when(fromIndex){
            0-> return value * 0.0254
            1-> return value * 0.9144
            2-> return value * 0.3048
            3-> return value * 1609.34
            4-> return value * ten.pow(-24)
            5-> return value * ten.pow(-21)
            6-> return value * ten.pow(-18)
            7-> return value * ten.pow(-15)
            8-> return value * ten.pow(-12)
            9-> return value * ten.pow(-9)
            10-> return value * ten.pow(-6)
            11-> return value * ten.pow(-3)
            12-> return value * ten.pow(-2)
            13-> return value/10
            14-> return value
            15-> return value * ten
            16-> return value * ten.pow(2)
            17-> return value * ten.pow(3)
            18-> return value * ten.pow(6)
            19-> return value * ten.pow(9)
            20-> return value * ten.pow(12)
            21-> return value * ten.pow(15)
            22-> return value * ten.pow(18)
            23-> return value * ten.pow(21)
            24-> return value * ten.pow(24)
        }
        return TODO("Provide the return value")
    }
    fun FromMetresToOther(){

    }
    // Простая заглушка для пересчёта (замени логику на нужную)
    fun convert(value: Double, fromIndex: Int, toIndex: Int) {

        return
    }
}