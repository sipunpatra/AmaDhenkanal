package com.dhenkanal.amadhenkanal.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dhenkanal.amadhenkanal.R
import com.dhenkanal.amadhenkanal.databinding.ItemReelBinding
import com.dhenkanal.amadhenkanal.model.ReelVideo
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem

//class ReelsAdapter(private val videoList: List<ReelVideo>) :
//    RecyclerView.Adapter<ReelsAdapter.ReelViewHolder>() {
//
//    inner class ReelViewHolder(val binding: ItemReelBinding) :
//        RecyclerView.ViewHolder(binding.root) {
//        val playerView = binding.playerView
//        var player: ExoPlayer? = null
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReelViewHolder {
//        val binding = ItemReelBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//        return ReelViewHolder(binding)
//    }
//
//    override fun onBindViewHolder(holder: ReelViewHolder, position: Int) {
//        val video = videoList[position]
//
//        holder.binding.tvTempleName.text = video.templeName
//        holder.binding.tvTempleLocation.text = video.templeLocation
//
//        // ExoPlayer Setup
//        holder.player = ExoPlayer.Builder(holder.itemView.context).build()
//        holder.playerView.player = holder.player
//        val mediaItem = MediaItem.fromUri(video.videoUrl)
//        holder.player?.setMediaItem(mediaItem)
//        holder.player?.prepare()
//        holder.player?.playWhenReady = true
//    }
//
//    override fun getItemCount() = videoList.size
//
//    override fun onViewDetachedFromWindow(holder: ReelViewHolder) {
//        super.onViewDetachedFromWindow(holder)
//        holder.player?.release()
//    }
//}

class ReelsAdapter(private val videoList: List<ReelVideo>) :
    RecyclerView.Adapter<ReelsAdapter.ReelViewHolder>() {

    inner class ReelViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val webView: WebView = itemView.findViewById(R.id.webView)
        val titleTextView: TextView = itemView.findViewById(R.id.tvTempleName)
        val locationTextView: TextView = itemView.findViewById(R.id.tvTempleLocation)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReelViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_reel, parent, false)
        return ReelViewHolder(view)
    }

    @SuppressLint("SetJavaScriptEnabled")
    override fun onBindViewHolder(holder: ReelViewHolder, position: Int) {
        val reel = videoList[position]

        holder.titleTextView.text = reel.title
        holder.locationTextView.text = reel.location

        // WebView settings
        holder.webView.settings.javaScriptEnabled = true
        holder.webView.settings.domStorageEnabled = true
        holder.webView.webViewClient = WebViewClient()
        holder.webView.loadUrl(reel.url)
    }

    override fun getItemCount(): Int = videoList.size
}

