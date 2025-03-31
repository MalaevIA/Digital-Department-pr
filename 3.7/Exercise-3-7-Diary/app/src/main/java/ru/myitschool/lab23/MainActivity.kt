package ru.myitschool.lab23

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.CalendarView
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import com.google.android.material.snackbar.Snackbar
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var titleInput: EditText
    private lateinit var timeInput: EditText
    private lateinit var notesInput: EditText
    private lateinit var calendarView: CalendarView
    private lateinit var saveButton: Button

    // Храним выбранную дату в миллисекундах
    private var selectedDateMillis: Long = 0L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Привязка разметки activity_main.xml
        setContentView(R.layout.activity_main)

        // Инициализация элементов интерфейса
        titleInput = findViewById(R.id.event_title_user_input)
        timeInput = findViewById(R.id.event_time_user_input)
        notesInput = findViewById(R.id.event_notes_user_input)
        calendarView = findViewById(R.id.calendar_view)
        saveButton = findViewById(R.id.save)

        // Устанавливаем начальное значение выбранной даты – текущая дата календаря
        selectedDateMillis = calendarView.date

        // Обработка выбора даты в календаре
        calendarView.setOnDateChangeListener { _, year, month, dayOfMonth ->
            // Обратите внимание, что month возвращается в диапазоне 0-11
            val calendar = Calendar.getInstance().apply {
                set(year, month, dayOfMonth)
            }
            selectedDateMillis = calendar.timeInMillis
        }

        // Обработка нажатия на кнопку "Сохранить"
        saveButton.setOnClickListener { view ->
            val title = titleInput.text.toString().trim()
            val time = timeInput.text.toString().trim()
            val notes = notesInput.text.toString().trim()

            if (title.isEmpty()) {
                // Если название события не указано, показываем Snackbar
                Snackbar.make(view, "Введите название события!", Snackbar.LENGTH_LONG).show()
                return@setOnClickListener
            }

            // Форматирование выбранной даты в формате дд.мм.гггг
            val formattedDate = SimpleDateFormat("dd.MM.yyyy", Locale.getDefault())
                .format(Date(selectedDateMillis))

            // Формирование сообщения для AlertDialog
            val message = """
                Записано!
                Событие: $title
                Дата: $formattedDate
                Время: $time
                Заметки: $notes
            """.trimIndent()

            // Создаем и показываем AlertDialog
            AlertDialog.Builder(this)
                .setMessage(message)
                .setPositiveButton("OK") { dialog, _ ->
                    dialog.dismiss()
                }
                .create()
                .show()

            // Очистка всех полей ввода после сохранения
            titleInput.text.clear()
            timeInput.text.clear()
            notesInput.text.clear()
        }
    }
}
