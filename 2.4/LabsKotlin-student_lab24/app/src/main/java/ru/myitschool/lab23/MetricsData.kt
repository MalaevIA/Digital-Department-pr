package ru.myitschool.lab24

import android.content.Context
import ru.myitschool.lab23.R
import kotlin.math.pow

class MetricsData(context: Context, private val lower: Int, private val upper: Int) {

    private val units: List<String> = context.resources.getStringArray(R.array.text_view_captions).toList()
    private val ten : Double = 10.0
    private val conversionFactors = mapOf(
        "Metres" to 1.0,
        "Inches" to 39.3701,
        "Feet" to 3.28084,
        "Yards" to 1.09361,
        "Miles" to 0.000621371,
        "Yottametres" to ten.pow(-24),
        "Zettametres" to ten.pow(-21),
        "Exametres" to ten.pow(-18),
        "Petametres" to ten.pow(-15),
        "Terametres" to ten.pow(-12),
        "Gigametres" to ten.pow(-9),
        "Megametres" to ten.pow(-6),
        "Kilometres" to ten.pow(-3),
        "Hectometres" to ten.pow(-2),
        "Decametres" to ten.pow(-1),
        "Decimetres" to ten,
        "Centimetres" to ten.pow(2),
        "Millimetres" to ten.pow(3),
        "Micrometres" to ten.pow(6),
        "Nanometres" to ten.pow(9),
        "Picometres" to ten.pow(12),
        "Femtometres" to ten.pow(15),
        "Attometres" to ten.pow(18),
        "Zeptometres" to ten.pow(21),
        "Yoctometres" to ten.pow(24)
    )

    fun getFilteredUnits(): List<String> {
        return units.subList(lower, upper + 1)
    }

    fun convertFromMetres(value: Double): List<Double> {
        return getFilteredUnits().map { unit ->
            conversionFactors[unit]?.times(value) ?: value
        }
    }
}

//fun FromAnyToMetres(value: Double, fromIndex: Int): Double {
//    when(fromIndex){
//        0-> return value * 0.0254
//        1-> return value * 0.9144
//        2-> return value * 0.3048
//        3-> return value * 1609.34
//        4-> return value * ten.pow(-24)
//        5-> return value * ten.pow(-21)
//        6-> return value * ten.pow(-18)
//        7-> return value * ten.pow(-15)
//        8-> return value * ten.pow(-12)
//        9-> return value * ten.pow(-9)
//        10-> return value * ten.pow(-6)
//        11-> return value * ten.pow(-3)
//        12-> return value * ten.pow(-2)
//        13-> return value/10
//        14-> return value
//        15-> return value * ten
//        16-> return value * ten.pow(2)
//        17-> return value * ten.pow(3)
//        18-> return value * ten.pow(6)
//        19-> return value * ten.pow(9)
//        20-> return value * ten.pow(12)
//        21-> return value * ten.pow(15)
//        22-> return value * ten.pow(18)
//        23-> return value * ten.pow(21)
//        24-> return value * ten.pow(24)
//    }
//    return TODO("Provide the return value")
//}