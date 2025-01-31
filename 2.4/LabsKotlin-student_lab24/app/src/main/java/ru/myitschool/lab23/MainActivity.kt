package ru.myitschool.lab23

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.myitschool.lab23.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var lower = 0
    private var upper = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        lower =
            if (intent.extras?.get("lower") != null) intent.extras?.get("lower") as Int else 0
        upper =
            if (intent.extras?.get("upper") != null) intent.extras?.get("upper") as Int else 1
    }
}

