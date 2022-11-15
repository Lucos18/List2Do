package com.example.list2do.ui.labelsfragments

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.list2do.database.todo.Label
import com.example.list2do.databinding.LabelListItemBinding

class LabelListAdapter(private val onLabelClick: (Label) -> Unit) :
    ListAdapter<Label, LabelListAdapter.ItemViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            LabelListItemBinding.inflate(
                LayoutInflater.from(
                    parent.context
                )
            )
        )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val current = getItem(position)
        holder.itemView.setOnClickListener {
            onLabelClick(current)
        }
        holder.bind(current)
    }

    class ItemViewHolder(private var binding: LabelListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(label: Label) {
            binding.name.text = label.name
            binding.color.text = label.color.toString()
            binding.shape.text = label.shape.toString()
        }
    }

    companion object {
        private val DiffCallback = object : DiffUtil.ItemCallback<Label>() {
            override fun areItemsTheSame(oldItem: Label, newItem: Label): Boolean {
                return oldItem === newItem
            }

            override fun areContentsTheSame(oldItem: Label, newItem: Label): Boolean {
                return oldItem.name == newItem.name
            }
        }
    }
}
