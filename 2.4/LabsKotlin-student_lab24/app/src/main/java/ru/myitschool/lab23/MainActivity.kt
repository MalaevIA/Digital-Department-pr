package ru.myitschool.lab23

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import ru.myitschool.lab23.R.color.white
import ru.myitschool.lab23.databinding.ActivityMainBinding
import ru.myitschool.lab24.MetricsData


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var metricsData: MetricsData
    private val editTextList = mutableListOf<EditText>()
    private val textViewList = mutableListOf<TextView>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val lower = intent.extras?.getInt("lower", 0) ?: 0
        val upper = intent.extras?.getInt("upper", 6) ?: 24

        metricsData = MetricsData(this, lower, upper)

        setupUI()
    }

    private fun setupUI() {
        val container = binding.container.outerLayout
        val units = metricsData.getFilteredUnits()

        for (unit in units) {
            // Создаём горизонтальный контейнер для TextView и EditText
            val rowLayout = LinearLayout(this).apply {
                orientation = LinearLayout.HORIZONTAL
                layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
            }

            val textView = TextView(this).apply {
                text = unit
                textSize = 9f
                setPadding(16, 0, 16, 0)
            }

            val editText = EditText(this).apply {
                hint = "Enter value"
                textSize = 9f
                layoutParams = LinearLayout.LayoutParams(
                    0, 
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    1f
                )
                setBackgroundColor(resources.getColor(white))
                addTextChangedListener(object : TextWatcher {
                    override fun afterTextChanged(s: Editable?) {
                        if (this@apply.isFocused) {
                            updateValues(s.toString())
                        }
                    }
                    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
                    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
                })
            }
            textView.setOnClickListener {
                copyToClipboard(editText.text.toString())
            }

            textViewList.add(textView)
            editTextList.add(editText)
            rowLayout.addView(textView)
            rowLayout.addView(editText)
            container.addView(rowLayout)
        }
    }

    private fun updateValues(input: String) {
        if (input.isEmpty()) return

        val value = input.toDoubleOrNull() ?: return
        val convertedValues = metricsData.convertFromMetres(value)

        editTextList.forEachIndexed { index, editText ->
            if (!editText.isFocused) {
                editText.setText(convertedValues[index].toString())
            }
        }
    }

    private fun copyToClipboard(text: String) {
        val clipboard = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        val clip = ClipData.newPlainText("Converted Value", text)
        clipboard.setPrimaryClip(clip)
    }
}

