package ru.myitschool.lab23

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.myitschool.lab23.databinding.ItemNumBinding

class NumberAdapter(private val numberList: List<Double>) : RecyclerView.Adapter<NumberAdapter.NumberViewHolder>() {
    class NumberViewHolder(val binding: ItemNumBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NumberViewHolder {
        val binding = ItemNumBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return NumberViewHolder(binding)
    }

    override fun getItemCount() = numberList.size
    override fun onBindViewHolder(holder: NumberViewHolder, position: Int) {
        holder.binding.randomNumberResult.text = numberList[position].toString()
    }
}