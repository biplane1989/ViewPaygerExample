package com.example.viewpaygerexample.adapter

import android.annotation.SuppressLint
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.viewpaygerexample.`object`.Apple


const val UPDATE_PROGRESS = 2

class AppleAdapter(val listener: (Apple) -> Unit) : ListAdapter<Apple, AppleViewHolder>(DiffProgressUnit()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AppleViewHolder {
        return AppleViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: AppleViewHolder, position: Int) {
        holder.build(getItem(position), listener)
    }

    override fun onBindViewHolder(holder: AppleViewHolder, position: Int, payloads: MutableList<Any>) {

        val status = payloads.firstOrNull()
        if (status == UPDATE_PROGRESS) {
            // update 1 phan
            holder.updateProgress(getItem(position).title)
        } else {
            // update full
            onBindViewHolder(holder, position)
        }
        super.onBindViewHolder(holder, position, payloads)
    }
}

class DiffProgressUnit : DiffUtil.ItemCallback<Apple>() {
    override fun areItemsTheSame(oldItem: Apple, newItem: Apple): Boolean {   // so sanh 2 object
        return oldItem.title == newItem.title       // check theo ID
    }

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: Apple, newItem: Apple): Boolean {    // muon dung payload thi ham nay luon tra false
//        if (oldItem.progress != newItem.progress) return false
//        else return oldItem == newItem

        return false
    }

    override fun getChangePayload(oldItem: Apple, newItem: Apple): Any? {

        if (oldItem.title == oldItem.title && oldItem.url != newItem.url) return UPDATE_PROGRESS        // muon update cai nao thi check cai do khac, con lai bang nhau
        return null
    }

}