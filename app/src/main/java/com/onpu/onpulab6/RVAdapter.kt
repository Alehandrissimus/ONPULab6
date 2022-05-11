package com.onpu.onpulab6

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.onpu.onpulab6.databinding.ItemBinding

class RVAdapter(private val callback: (ItemModel) -> Unit) :
    ListAdapter<ItemModel, RVViewHolder>(Diffs()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RVViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item, parent, false)

        return RVViewHolder(view, callback)
    }

    override fun onBindViewHolder(holder: RVViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

}

class RVViewHolder(itemview: View, private val callback: (ItemModel) -> Unit) :
    RecyclerView.ViewHolder(itemview) {

    private val binding = ItemBinding.bind(itemView)


    fun bind(itemModel: ItemModel) {
        binding.apply {
            btnItem.text = itemModel.number.toString()
            btnItem.setBackgroundColor(itemModel.color)
            btnItem.setOnClickListener {
                callback(itemModel)
            }
        }
    }
}

class Diffs : DiffUtil.ItemCallback<ItemModel>() {
    override fun areItemsTheSame(oldItem: ItemModel, newItem: ItemModel): Boolean {
        return oldItem.number == newItem.number
    }

    override fun areContentsTheSame(oldItem: ItemModel, newItem: ItemModel): Boolean {
        return oldItem.number == newItem.number
    }

}