package com.example.mytv_demo.presentation.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mytv_demo.databinding.ItemChannelBinding
import com.example.mytv_demo.domain.models.channels.Channel

class ChannelAdapter : ListAdapter<Channel, ChannelAdapter.ChannelViewHolder>(object: DiffUtil.ItemCallback<Channel>(){
    override fun areContentsTheSame(oldItem: Channel, newItem: Channel): Boolean {
        return oldItem == newItem
    }

    override fun areItemsTheSame(oldItem: Channel, newItem: Channel): Boolean {
        return oldItem == newItem
    }
}) {

    inner class ChannelViewHolder(binding: ItemChannelBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChannelViewHolder {
        val binding = ItemChannelBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ChannelViewHolder(
            binding
        )
    }

    override fun onBindViewHolder(holder: ChannelViewHolder, position: Int) {
        val channel = getItem(position)
        val binding = ItemChannelBinding.bind(holder.itemView)
        holder.itemView.apply {
            Glide.with(this)
                .load(channel.imageUrl)
                .into(binding.ivChannel)
        }
    }

}