package ru.myitschool.lab22toast

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private val DESTROY_COUNT_KEY = "destroy_count"
    private var destroyCount = 0
    private lateinit var textView : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView = findViewById(R.id.text)
        // Восстановление состояния при повороте экрана
        savedInstanceState?.apply{
            destroyCount = savedInstanceState.getInt(DESTROY_COUNT_KEY, 0)
            textView.text = destroyCount.toString()
        }
        showToast(R.string.ncreate)
    }

    override fun onStart() {
        super.onStart()
        showToast(R.string.nstart)
    }

    override fun onResume() {
        super.onResume()
        showToast(R.string.nresume)
    }

    override fun onDestroy() {
        textView.text = destroyCount.toString()
        if (destroyCount % 2 == 0) {
            showToast(R.string.ndestroy)
        }
        super.onDestroy()
    }

    private fun showToast(resId: Int) {
        Toast.makeText(this, getString(resId), Toast.LENGTH_LONG).show()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        destroyCount++
        super.onSaveInstanceState(outState)
        outState.putInt(DESTROY_COUNT_KEY, destroyCount)
    }

}

