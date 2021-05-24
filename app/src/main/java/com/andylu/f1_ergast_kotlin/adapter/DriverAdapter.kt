package com.andylu.f1_ergast_kotlin.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.andylu.f1_ergast_kotlin.databinding.ItemDriverBinding
import com.andylu.f1_ergast_kotlin.model.Driver

class DriverAdapter:ListAdapter<Driver, DriverAdapter.DriverViewHolder> (Companion){
    class DriverViewHolder(val binding: ItemDriverBinding) : RecyclerView.ViewHolder(binding.root)

    companion object: DiffUtil.ItemCallback<Driver>() {
        override fun areItemsTheSame(oldItem: Driver, newItem: Driver): Boolean = oldItem === newItem
        override fun areContentsTheSame(oldItem: Driver, newItem: Driver): Boolean = oldItem.url == newItem.url
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DriverViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemDriverBinding.inflate(layoutInflater)

        return DriverViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DriverViewHolder, position: Int) {
        val currentDriver = getItem(position)
        holder.binding.driver = currentDriver
        holder.binding.executePendingBindings()
    }
}