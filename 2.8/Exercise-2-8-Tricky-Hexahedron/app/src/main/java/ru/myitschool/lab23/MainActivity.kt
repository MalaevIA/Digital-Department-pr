package ru.myitschool.lab23

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import ru.myitschool.lab23.databinding.ActivityMainBinding
import kotlin.math.pow
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val array: Array<String> = resources.getStringArray(R.array.formulas_array)
        val adapter = ArrayAdapter(
            this, android.R.layout.simple_list_item_1,
            array
        )
        val res = binding.container.solution
        val btnCalc = binding.container.calculate
        binding.container.spinner.adapter = adapter
        binding.container.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

                when(position){

                    0-> btnCalc.setOnClickListener{
                        val a = binding.container.sideA.text.toString().toDoubleOrNull()?:0.0
                        val b = binding.container.sideB.text.toString().toDoubleOrNull()?:0.0
                        val c = binding.container.sideC.text.toString().toDoubleOrNull()?:0.0
                        res.text = sumP(a,b,c)
                    }
                    1-> btnCalc.setOnClickListener{
                        val a = binding.container.sideA.text.toString().toDoubleOrNull()?:0.0
                        val b = binding.container.sideB.text.toString().toDoubleOrNull()?:0.0
                        val c = binding.container.sideC.text.toString().toDoubleOrNull()?:0.0
                        res.text = lengthP(a,b,c)
                    }
                    2-> btnCalc.setOnClickListener {
                        val a = binding.container.sideA.text.toString().toDoubleOrNull()?:0.0
                        val b = binding.container.sideB.text.toString().toDoubleOrNull()?:0.0
                        val c = binding.container.sideC.text.toString().toDoubleOrNull()?:0.0
                        res.text = squareP(a,b,c)
                    }
                    3-> btnCalc.setOnClickListener {
                        val a = binding.container.sideA.text.toString().toDoubleOrNull()?:0.0
                        val b = binding.container.sideB.text.toString().toDoubleOrNull()?:0.0
                        val c = binding.container.sideC.text.toString().toDoubleOrNull()?:0.0
                        res.text = volumeP(a,b,c)
                    }
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }
        }

    }
    private fun sumP(a: Double, b: Double, c:Double):String{
        return (4*(a + b + c)).toString()
    }
    private fun lengthP(a: Double, b: Double, c:Double):String{
        return sqrt((a).pow(2) + (b).pow(2) + (c).pow(2)).toString()
    }
    private fun squareP(a: Double, b: Double, c:Double):String{
        return (2 * (a * b + b * c + a * c)).toString()
    }private fun volumeP(a: Double, b: Double, c:Double):String{
        return (a * b * c).toString()
    }

}
