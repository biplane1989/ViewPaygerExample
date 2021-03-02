package com.example.viewpaygerexample.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.viewpaygerexample.`object`.Apple
import com.example.viewpaygerexample.databinding.ItemBinding

class AppleViewHolder(val binding: ItemBinding) : RecyclerView.ViewHolder(binding.root) {

    fun build(data: Apple, listener: (Apple) -> Unit) {
        binding.title.text = data.title
        Glide.with(itemView.context).load(data.url).into(binding.iv)

        binding.item.setOnLongClickListener {
            listener(data)
            true
        }
    }

    fun updateProgress(title: String) {
        binding.title.text = title
    }

    companion object {
        fun create(parent: ViewGroup): AppleViewHolder {
            return AppleViewHolder(ItemBinding.inflate(parent.getLayoutInflate(), parent, false))
        }
    }

}