package ru.myitschool.lab23

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import ru.myitschool.lab23.databinding.ActivityMainBinding
import kotlin.math.ln
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.content.getRandomNums.setOnClickListener {
            val intent:Intent = Intent(this, MainActivity2::class.java)
            val n :Int  = binding.content.sizeParam.text.toString().toIntOrNull()?:0
            val k :Int = binding.content.shapeParam.text.toString().toIntOrNull()?:0
            val lambda : Double = binding.content.rateParam.text.toString().toDouble()
            intent.putExtra("n",n)
            intent.putExtra("k",k)
            intent.putExtra("lambda",lambda)
            startActivity(intent)
        }

    }
}
