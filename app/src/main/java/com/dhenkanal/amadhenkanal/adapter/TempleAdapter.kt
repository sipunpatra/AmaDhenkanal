package com.dhenkanal.amadhenkanal.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.dhenkanal.amadhenkanal.R
import com.dhenkanal.amadhenkanal.model.TempleModel
import com.google.android.material.card.MaterialCardView

class TempleAdapter(private val imageList: List<TempleModel>) :RecyclerView.Adapter<TempleAdapter.TempleViewHolder>(){
    inner class TempleViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val image: ImageView = view.findViewById(R.id.templeImage)
        val title: TextView = view.findViewById(R.id.templeName)
        val location: TextView = view.findViewById(R.id.templeLocation)
        val cardView: MaterialCardView = view.findViewById(R.id.cardView)
    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TempleAdapter.TempleViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.itme_temple, parent, false)
        return TempleViewHolder(view)
    }

    override fun onBindViewHolder(holder: TempleAdapter.TempleViewHolder, position: Int) {
        val item = imageList[position]
        holder.image.setImageResource(item.imageRes)
        holder.title.text = item.title
        holder.location.text=item.location
        holder.cardView.strokeColor = item.borderColor
    }

    override fun getItemCount()= imageList.size
}