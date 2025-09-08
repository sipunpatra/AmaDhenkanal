package com.dhenkanal.amadhenkanal.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dhenkanal.amadhenkanal.MainActivity
import com.dhenkanal.amadhenkanal.R
import com.dhenkanal.amadhenkanal.adapter.ReelsAdapter
import com.dhenkanal.amadhenkanal.databinding.ActivityReelsBinding
import com.dhenkanal.amadhenkanal.model.ReelVideo

class ReelsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityReelsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityReelsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val videoList = listOf(
            ReelVideo("https://www.instagram.com/reel/DNe6EnDTmil/?utm_source=ig_web_copy_link", "Jagannath Temple", "Puri, Odisha"),
            ReelVideo("https://www.instagram.com/reel/DNe6EnDTmil/?utm_source=ig_web_copy_link", "Lingaraj Temple", "Bhubaneswar, Odisha"),
            ReelVideo("https://www.instagram.com/reel/DNe6EnDTmil/?utm_source=ig_web_copy_link", "Sapua Dam", "Dhenkanal, Odisha")
        )

        val adapter = ReelsAdapter(videoList)
        binding.recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        binding.recyclerView.adapter = adapter
        uiInitialization()

    }

    private fun uiInitialization() {
        binding.bottomNavigation.selectedItemId = R.id.nav_reels

        binding.bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_explore -> {
                    startActivity(Intent(this, MainActivity::class.java).apply {
                        addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
                    })
                    finish() // close current activity
                    true
                }
                R.id.nav_map -> {
                    startActivity(Intent(this, MapActivity::class.java).apply {
                        addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
                    })
                    finish()
                    true
                }
                R.id.nav_reels ->{
                    true
                }
                R.id.nav_famous ->{
                    startActivity(Intent(this,FamousActivity::class.java).apply {
                        addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
                    })
                    finish()
                    true
                }
                R.id.nav_more -> {
                    startActivity(Intent(this,MoreDetailsActivity::class.java).apply {
                        addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
                    })
                    finish()
                    true
                }
                else -> false
            }
        }
    }

}