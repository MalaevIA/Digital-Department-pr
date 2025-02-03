package ru.myitschool.lab23

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import ru.myitschool.lab23.databinding.ActivityMainBinding
import java.util.Random


class MainActivity : AppCompatActivity() {
    private lateinit var viewModel : MyViewModel
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding  = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this).get(MyViewModel::class.java)
        observeViewModel()
        initView()
    }
    fun observeViewModel(){
        viewModel.result.observe(this) {
            binding.content.randomNumberResult.text = it.toString()
        }
    }
    fun initView(){
        binding.content.getRandomNum.setOnClickListener{
            val mu = binding.content.meanVal.text.toString().toDouble()
            val sigma2 = binding.content.varianceValue.text.toString().toDouble()
            viewModel.setValue(Math.exp(Math.sqrt(sigma2) * Random().nextGaussian() + mu))
        }
    }
}
