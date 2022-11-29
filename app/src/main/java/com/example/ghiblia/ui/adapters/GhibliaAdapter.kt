package com.example.ghiblia.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.ghiblia.base.BaseDiffutilsCallback
import com.example.ghiblia.databinding.ItemGhibliaBinding
import com.example.ghiblia.models.GhibliaModel

class GhibliaAdapter(
    private val onClick: OnClick
) : ListAdapter<GhibliaModel, GhibliaAdapter.ViewHolder>(BaseDiffutilsCallback()) {

    class ViewHolder(private val binding: ItemGhibliaBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(item: GhibliaModel?, onClick: OnClick) {
            binding.imGhiblia.load(item?.image)
            binding.tvTitle.text = item?.title
            binding.tvDescription.text = item?.description
            binding.tvProducer.text = item?.producer
            itemView.setOnClickListener {
                onClick.listener(item?.id)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemGhibliaBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ), parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(getItem(position), onClick)
    }
}

interface OnClick {
    fun listener(id: String?)
}