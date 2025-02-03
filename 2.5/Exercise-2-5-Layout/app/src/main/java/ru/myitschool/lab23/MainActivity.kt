package ru.myitschool.lab23

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import ru.myitschool.lab23.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var binding: ActivityMainBinding? = null
    private var score: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding!!.root)
        binding!!.button1.setOnClickListener{
            score++
            binding!!.scoreText.text = score.toString()
        }
        binding!!.button2.setOnClickListener{
            score++
            binding!!.scoreText.text = score.toString()
        }
        binding!!.button3.setOnClickListener{
            score++
            binding!!.scoreText.text = score.toString()
        }
        binding!!.button4.setOnClickListener{
            score++
            binding!!.scoreText.text = score.toString()
        }
        binding!!.scoreText.setOnClickListener{ view ->
            score = 0
            binding!!.scoreText.text = score.toString()
            Snackbar.make(view, "100%", Snackbar.LENGTH_SHORT).show()
        }
    }
} /*
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}
*/

