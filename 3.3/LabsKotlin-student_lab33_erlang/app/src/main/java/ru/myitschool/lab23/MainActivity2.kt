package ru.myitschool.lab23

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.math.ln
import kotlin.random.Random

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val n = intent.getIntExtra("n",0)
        val k = intent.getIntExtra("k",0)
        val lambda = intent.getDoubleExtra("lambda",0.0)
        val rv : RecyclerView = findViewById(R.id.generated_list)
        rv.adapter = NumberAdapter(generateErlangRandomNumbers(n,k,lambda))
        rv.layoutManager = LinearLayoutManager(this)
    }
    fun generateErlangRandomNumbers(n: Int, k: Int, lambda: Double): List<Double> {
        return List(n) {
            (-1 / lambda) * (1..k).sumOf { ln(Random.nextDouble(0.0, 1.0)) }
        }
    }
}