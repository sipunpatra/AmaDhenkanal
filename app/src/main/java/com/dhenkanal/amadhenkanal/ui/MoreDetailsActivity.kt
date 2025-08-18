package com.dhenkanal.amadhenkanal.ui

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dhenkanal.amadhenkanal.MainActivity
import com.dhenkanal.amadhenkanal.R
import com.dhenkanal.amadhenkanal.databinding.ActivityMoreDetailsBinding

class MoreDetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMoreDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMoreDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)


        uiInitialization()


    }

    private fun uiInitialization() {
        binding.bottomNavigation.selectedItemId = R.id.nav_more

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
                R.id.nav_famous -> {
                    startActivity(Intent(this, FamousActivity::class.java).apply {
                        addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
                    })
                    finish()
                    true
                }
                R.id.nav_more -> {
                    true
                }
                else -> false
            }
        }


        binding.llPolice.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL).apply {
                data = Uri.parse("tel:100") // Police emergency number in India
            }
            startActivity(intent)
        }

        binding.llAmbulance.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL).apply {
                data = Uri.parse("tel:108") // Police emergency number in India
            }
            startActivity(intent)
        }

        binding.llFire.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL).apply {
                data = Uri.parse("tel:101") // Police emergency number in India
            }
            startActivity(intent)
        }
        binding.llWomanHelpLine.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL).apply {
                data = Uri.parse("tel:1091") // Police emergency number in India
            }
            startActivity(intent)
        }
    }


}