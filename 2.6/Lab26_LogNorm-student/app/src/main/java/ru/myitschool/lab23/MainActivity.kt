package ru.myitschool.lab23

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import ru.myitschool.lab23.databinding.ActivityMainBinding
import java.util.Random
import kotlin.math.exp
import kotlin.math.sqrt


class MainActivity : AppCompatActivity() {
    private lateinit var viewModel : MyViewModel
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding  = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this)[MyViewModel::class.java]
        observeViewModel()
        initView()
    }
    private fun observeViewModel(){
        viewModel.result.observe(this) {
            binding.content.randomNumberResult.text = it.toString()
        }
    }
    private fun initView(){
        binding.content.getRandomNum.setOnClickListener{
            val mu = binding.content.meanVal.text.toString().toDoubleOrNull() ?: 0.0
            val sigma2 = binding.content.varianceValue.text.toString().toDoubleOrNull() ?: 1.0
            viewModel.setValue(exp(sqrt(sigma2) * Random().nextGaussian() + mu))
        }
    }
}
