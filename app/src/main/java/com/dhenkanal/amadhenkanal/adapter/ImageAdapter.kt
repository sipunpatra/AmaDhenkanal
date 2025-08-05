package com.dhenkanal.amadhenkanal.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dhenkanal.amadhenkanal.R
import com.dhenkanal.amadhenkanal.databinding.ItemSliderImageBinding
import com.dhenkanal.amadhenkanal.model.ImageItem

class ImageAdapter(private val imageList: List<ImageItem>) : RecyclerView.Adapter<ImageAdapter.ImageViewHolder>() {

    inner class ImageViewHolder(val binding: ItemSliderImageBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val binding = ItemSliderImageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ImageViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        val item = imageList[position]
        with(holder.binding) {
            tvTitle.text = item.title
            tvSubtitle.text = item.subtitle

            Glide.with(imageView.context)
                .load(item.imageUrl)
                .placeholder(R.drawable.no_image) // optional placeholder
                .error(R.drawable.ic_launcher_background) // optional error fallback
                .into(imageView)
        }
    }

    override fun getItemCount(): Int = imageList.size
}

