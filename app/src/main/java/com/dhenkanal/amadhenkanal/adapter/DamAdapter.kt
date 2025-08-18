package com.dhenkanal.amadhenkanal.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dhenkanal.amadhenkanal.R
import com.dhenkanal.amadhenkanal.model.DamModel

class DamAdapter(private val imageList: List<DamModel>) : RecyclerView.Adapter<DamAdapter.DamViewHolder>() {
     inner class DamViewHolder(view: View) : RecyclerView.ViewHolder(view){
         val image: ImageView = view.findViewById(R.id.imageViewDam)
         val title: TextView = view.findViewById(R.id.tvTitleDam)
         val subTitle: TextView = view.findViewById(R.id.tvSubtitleDam)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DamAdapter.DamViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.itme_dam, parent, false)
        return DamViewHolder(view)
    }

    override fun onBindViewHolder(holder: DamAdapter.DamViewHolder, position: Int) {

        val item = imageList[position]

        // Set image
        holder.image.setImageResource(item.imageUrl)
        holder.title.text = item.title
        holder.subTitle.text=item.subtitle

    }

    override fun getItemCount()= imageList.size

}