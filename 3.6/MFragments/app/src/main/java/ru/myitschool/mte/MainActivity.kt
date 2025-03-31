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
    private var currentFragment = 0 // 0 – FirstFragment, 1 – ProceedingFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Ищем кнопки по id
        val startBtn = findViewById<Button>(R.id.start_btn)
        val stopBtn = findViewById<Button>(R.id.stop_btn)

        // По нажатию на start_btn запускаем переключение фрагментов
        startBtn.setOnClickListener {
            if (!isSwitching) {
                isSwitching = true
                startFragmentSwitching()
            }
        }

        // По нажатию на stop_btn прекращаем переключение
        stopBtn.setOnClickListener {
            isSwitching = false
            fragmentSwitchRunnable?.let { handler.removeCallbacks(it) }
        }
    }

    // Метод для запуска периодического переключения фрагментов
    private fun startFragmentSwitching() {
        fragmentSwitchRunnable = object : Runnable {
            override fun run() {
                // Определяем, какой фрагмент отображать
                val fragment = if (currentFragment == 0) {
                    FirstFragment()
                } else {
                    ProceedingFragment()
                }

                // Выполняем замену фрагмента внутри FrameLayout с id output_fragment
                supportFragmentManager.beginTransaction()
                    .replace(R.id.output_fragment, fragment)
                    .commit()

                // Переключаем значение для следующего запуска
                currentFragment = (currentFragment + 1) % 2

                // Если переключение активировано, снова запланировать запуск через 3 секунды
                if (isSwitching) {
                    handler.postDelayed(this, 3000)
                }
            }
        }
        // Запускаем немедленно
        handler.post(fragmentSwitchRunnable!!)
    }
}
