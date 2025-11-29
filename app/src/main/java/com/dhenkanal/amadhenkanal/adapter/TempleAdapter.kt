package com.dhenkanal.amadhenkanal.adapter

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.view.GestureDetector
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dhenkanal.amadhenkanal.R
import com.dhenkanal.amadhenkanal.model.TempleModel
import com.google.android.material.card.MaterialCardView

class TempleAdapter(
    private val imageList: List<TempleModel>,
    private val onItemClick: (TempleModel) -> Unit

) :RecyclerView.Adapter<TempleAdapter.TempleViewHolder>(){

    private var expandedPosition = RecyclerView.NO_POSITION

    inner class TempleViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val image: ImageView = view.findViewById(R.id.templeImage)
        val title: TextView = view.findViewById(R.id.templeName)
        val location: TextView = view.findViewById(R.id.templeLocation)
        val near :TextView =view.findViewById(R.id.nearest)
        val cardView: MaterialCardView = view.findViewById(R.id.cardView)
        val locationIcon: ImageView = itemView.findViewById(R.id.locationIcon)
        val expandableLayout: LinearLayout = itemView.findViewById(R.id.expandableLayout)
    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TempleAdapter.TempleViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.itme_temple, parent, false)
        return TempleViewHolder(view)
    }


    @SuppressLint("ClickableViewAccessibility")
    override fun onBindViewHolder(holder: TempleAdapter.TempleViewHolder,@SuppressLint("RecyclerView") position: Int) {
        val item = imageList[position]
        holder.image.setImageResource(item.imageRes)
        holder.title.text = item.title
        holder.location.text = item.location
        holder.cardView.strokeColor = item.borderColor
        holder.near.text=item.details

        val isExpanded = position == expandedPosition
        holder.expandableLayout.visibility = if (isExpanded) View.VISIBLE else View.GONE

        // GestureDetector for single tap & double tap
        val gestureDetector = GestureDetector(holder.itemView.context,
            object : GestureDetector.SimpleOnGestureListener() {
                override fun onSingleTapConfirmed(e: MotionEvent): Boolean {
                    // Expand/Collapse logic
                    val prevExpanded = expandedPosition
                    if (isExpanded) {
                        expandedPosition = RecyclerView.NO_POSITION
                        notifyItemChanged(position)
                    } else {
                        expandedPosition = position
                        notifyItemChanged(prevExpanded)
                        notifyItemChanged(position)
                    }
                    return true
                }

                override fun onDoubleTap(e: MotionEvent): Boolean {
                    // Open details page
                    onItemClick(item)
                    return true
                }
            })

        // Attach gesture detector to cardView
        holder.cardView.setOnTouchListener { _, event ->
            gestureDetector.onTouchEvent(event)
            true
        }

        // Location icon click → Google Maps
        holder.locationIcon.setOnClickListener {
            val gmmIntentUri = Uri.parse("google.navigation:q=${item.latitude},${item.longitude}")
            val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
            mapIntent.setPackage("com.google.android.apps.maps")
            it.context.startActivity(mapIntent)
        }
    }


//    override fun onBindViewHolder(holder: TempleAdapter.TempleViewHolder, @SuppressLint("RecyclerView") position: Int) {
//        val item = imageList[position]
//        holder.image.setImageResource(item.imageRes)
//        holder.title.text = item.title
//        holder.location.text=item.location
//        holder.cardView.strokeColor = item.borderColor
//
//        val isExpanded = position == expandedPosition
//        holder.expandableLayout.visibility = if (isExpanded) View.VISIBLE else View.GONE
//
//        //  Expand/collapse when clicking card
//        holder.cardView.setOnClickListener {
//            val prevExpanded = expandedPosition
//            if (isExpanded) {
//                // collapse current
//                expandedPosition = RecyclerView.NO_POSITION
//                notifyItemChanged(position)
//            } else {
//                // collapse previous
//                expandedPosition = position
//                notifyItemChanged(prevExpanded)
//                notifyItemChanged(position)
//            }
//        }
//
//        holder.cardView.setOnClickListener {
//            onItemClick(item)
//        }
//
//
//        holder.locationIcon.setOnClickListener {
//            val gmmIntentUri = Uri.parse("google.navigation:q=${item.latitude},${item.longitude}")
//            val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
//            mapIntent.setPackage("com.google.android.apps.maps")
//            it.context.startActivity(mapIntent)
//        }
//    }

    override fun getItemCount()= imageList.size
}