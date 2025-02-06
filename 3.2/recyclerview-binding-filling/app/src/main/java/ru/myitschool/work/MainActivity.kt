package ru.myitschool.work

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ru.myitschool.work.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var listBooks: List<Book>
    private lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        recyclerView = binding.recyclerView
        listBooks = listOf(Book("Война и мир","Лев Толстой"),
            Book("Преступление и наказание","Фёдор Достоевский"),
            Book("Мастер и Маргарита","Михаил Булгаков"),
            Book("Анна Каренина","Лев Толстой"),
            Book("Евгений Онегин","Александр Пушкин"),)
        recyclerView.adapter = BookAdapter(listBooks)
        recyclerView.layoutManager = LinearLayoutManager(this)
    }
}