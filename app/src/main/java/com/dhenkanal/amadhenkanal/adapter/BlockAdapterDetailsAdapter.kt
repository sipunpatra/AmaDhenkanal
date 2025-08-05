package com.dhenkanal.amadhenkanal.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.dhenkanal.amadhenkanal.R
import com.dhenkanal.amadhenkanal.model.StoryItem
import com.google.android.material.imageview.ShapeableImageView

class BlockAdapterDetailsAdapter(private val list: List<StoryItem>) :
    RecyclerView.Adapter<BlockAdapterDetailsAdapter.StoryViewHolder>() {

    inner class StoryViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image: ShapeableImageView = view.findViewById(R.id.imageStory)
        val title: TextView = view.findViewById(R.id.textTitle)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoryViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_story_circle, parent, false)
        return StoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: StoryViewHolder, position: Int) {
        val item = list[position]

        // Set image
        holder.image.setImageResource(item.imageRes)

        // Safely set tint to background drawable
        val drawable = ContextCompat.getDrawable(holder.itemView.context, R.drawable.story_circle_border)
        drawable?.setTint(item.borderColor)
        holder.image.background = drawable

        // Set title
        holder.title.text = item.title
    }

    override fun getItemCount() = list.size
}
