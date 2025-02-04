package ru.myitschool.lab23

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import ru.myitschool.lab23.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding :ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.content.showAction.setOnClickListener{
            binding.content.summaryText.apply {
                val checkedStates = listOf(
                    binding.content.chipMaterial?.let { "com.google.android.material.chip.Chip:${it.isChecked}" },
                ).filterNotNull().joinToString()
                text = checkedStates
            }
        }
    }


}
