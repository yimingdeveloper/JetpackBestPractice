package com.example.jetpackbestpractice

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.jetpackbestpractice.databinding.QuestionnaireItemLayoutBinding

class ShowCaseAdapter(private val list: MutableList<Question>?, private val listener: ItemClickListener): RecyclerView.Adapter<ShowCaseAdapter.ShowCaseViewHolder>() {

    inner class ShowCaseViewHolder(val binding: QuestionnaireItemLayoutBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Question) {
            binding.viewModel = item
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShowCaseViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = QuestionnaireItemLayoutBinding.inflate(inflater, parent, false)
        return ShowCaseViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ShowCaseViewHolder, position: Int) {
        list?.get(position)?.let { holder.bind(it) }
        holder.binding.img.setOnClickListener {
            list?.get(position)?.let { it1 -> listener.onItemClick(holder.binding.img, it1, position) }
        }
    }

    override fun getItemCount(): Int {
        return list?.size ?: 0
    }
}