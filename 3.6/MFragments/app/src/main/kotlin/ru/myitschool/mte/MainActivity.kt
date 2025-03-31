package ru.myitschool.mte

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import ru.myitschool.mte.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val handler = Handler(Looper.getMainLooper())
    private var fragmentSwitchRunnable: Runnable? = null
    private var isSwitching = false
    private var currentFragment = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val startBtn = findViewById<Button>(R.id.start_btn)
        val stopBtn = findViewById<Button>(R.id.stop_btn)

        startBtn.setOnClickListener {
            if (!isSwitching) {
                isSwitching = true
                startFragmentSwitching()
            }
        }
        stopBtn.setOnClickListener {
            isSwitching = false
            fragmentSwitchRunnable?.let { handler.removeCallbacks(it) }
        }
    }
    private fun startFragmentSwitching() {
        fragmentSwitchRunnable = object : Runnable {
            override fun run() {
                val fragment = if (currentFragment == 0) {
                    FirstFragment()
                } else {
                    ProceedingFragment()
                }
                supportFragmentManager.beginTransaction()
                    .replace(R.id.output_fragment, fragment)
                    .commit()

                currentFragment = (currentFragment + 1) % 2

                if (isSwitching) {
                    handler.postDelayed(this, 3000)
                }
            }
        }
        handler.post(fragmentSwitchRunnable!!)
    }
}
