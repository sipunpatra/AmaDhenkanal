package com.dhenkanal.amadhenkanal.ui

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dhenkanal.amadhenkanal.MainActivity
import com.dhenkanal.amadhenkanal.R
import com.dhenkanal.amadhenkanal.databinding.ActivityFamousBinding

class FamousActivity : AppCompatActivity() {

    private lateinit var binding :ActivityFamousBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFamousBinding.inflate(layoutInflater)
        setContentView(binding.root)
        uiInitialization()
    }

    private fun uiInitialization() {
        binding.bottomNavigation.selectedItemId = R.id.nav_famous

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
                R.id.nav_famous ->{
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