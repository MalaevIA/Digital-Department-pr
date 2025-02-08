package ru.myitschool.lab23

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import ru.myitschool.lab23.databinding.ActivityMainBinding
import kotlin.math.ln
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding!!.root)

    }
    fun generateErlangRandomNumbers(n: Int, k: Int, lambda: Double): List<Double> {
        return List(n) {
            (-1 / lambda) * (1..k).sumOf { ln(Random.nextDouble(0.0, 1.0)) }
        }
    }
}
