package com.sultan.pixabay.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sultan.pixabay.databinding.ImageHolderBinding
import com.sultan.pixabay.model.models.ImageResponse


class ImageAdapter : ListAdapter<ImageResponse.Hit, ImageAdapter.ViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder = ViewHolder(ImageHolderBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {
        holder.bind(getItem(position))
    }

    class ViewHolder(private val binding : ImageHolderBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(hit : ImageResponse.Hit) {
            Glide.with(binding.image).load(hit.largeImageURL).into(binding.image)
        }
    }

    class DiffCallback : DiffUtil.ItemCallback<ImageResponse.Hit>() {
        override fun areItemsTheSame(oldItem: ImageResponse.Hit, newItem: ImageResponse.Hit): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: ImageResponse.Hit, newItem: ImageResponse.Hit): Boolean {
            return oldItem == newItem
        }
    }
}