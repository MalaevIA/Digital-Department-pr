package ru.myitschool.work

import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.myitschool.work.databinding.ItemBookBinding

class BookAdapter(private val bookList: List<Book>) : RecyclerView.Adapter<BookAdapter.BookViewHolder>() {

    //TODO: Реализовать класс BookViewHolder, используя binding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemBookBinding.inflate(inflater, parent, false)
        return BookViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        //TODO: Заполнить элемент списка данными дата класса. Нечетные блоки информации должны быть прижаты вправо
    }

    override fun getItemCount() = bookList.size
}
