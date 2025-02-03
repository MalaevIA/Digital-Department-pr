package ru.myitschool.lab23

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import ru.myitschool.lab23.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    lateinit var viewModel : MyViewModel
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding  = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this).get(MyViewModel::class.java)
        observeViewModel()
        binding.content.getRandomNum.setOnClickListener{
            viewModel.result.value = viewModel.generateLogNormal()
        }
    }
    fun observeViewModel(){
        viewModel.mu.observe(this, Observer{
            binding.content.meanVal.setText(it.toString())
        })
        viewModel.sigma2.observe(this, Observer{
            binding.content.varianceValue.setText(it.toString())
        })
        viewModel.result.observe(this, Observer{
            binding.content.randomNumberResult.text = it.toString()
        })

    }
}
