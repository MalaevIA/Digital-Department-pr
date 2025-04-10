package ru.myitschool.work

import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.myitschool.work.databinding.ItemBookBinding

class BookAdapter(private val bookList: List<Book>) : RecyclerView.Adapter<BookAdapter.BookViewHolder>() {

    class BookViewHolder(val binding: ItemBookBinding) : RecyclerView.ViewHolder(binding.root) {//аналог item view из лекции описыввет экземпляр каждого элемента на я подключил viewbinding
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val binding = ItemBookBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return BookViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        if (position % 2 == 0){
            holder.binding.bookTitle.text = bookList[position].title
            holder.binding.bookAuthor.text = bookList[position].author
        }
        else{
            holder.binding.infoContainer.gravity = Gravity.END
            holder.binding.bookTitle.text = bookList[position].title
            holder.binding.bookAuthor.text = bookList[position].author
        }
    }

    override fun getItemCount() = bookList.size
}
