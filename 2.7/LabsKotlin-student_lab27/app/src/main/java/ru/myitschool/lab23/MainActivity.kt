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
                    binding.content.checkBoxMaterial?.let { "com.google.android.material.checkbox.MaterialCheckBox:${it.isChecked}" },
                    binding.content.switchMaterial?.let { "com.google.android.material.switchmaterial.SwitchMaterial:${it.isChecked}" },
                    binding.content.toggleButton?.let { "androidx.appcompat.widget.AppCompatToggleButton:${it.isChecked}" }
                ).filterNotNull().joinToString()
                text = checkedStates
            }
        }
    }


}
