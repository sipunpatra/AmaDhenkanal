package com.dhenkanal.amadhenkanal.ui

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.dhenkanal.amadhenkanal.R
import com.dhenkanal.amadhenkanal.databinding.ActivityBlockDetailsBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.math.truncate

class BlockDetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBlockDetailsBinding
    private var isFavorite = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBlockDetailsBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        val title = intent.getStringExtra("title")
        val imageRes = intent.getIntExtra("imageRes", 0)

        binding.tvBlockName.text = title
        binding.headerImage.setImageResource(imageRes)

        binding.btnBack.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        binding.btnFav.setOnClickListener {
            toggleFavorite()

        }

        /*
        this code add update  studio version
        here not use below code because i need full image with systemBars
         */

//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
    }


    private fun toggleFavorite() {
        lifecycleScope.launch {
            if (isFavorite) {
                // Remove from favorites
                withContext(Dispatchers.IO) {
//                    db.favoriteDao().deleteFavorite(FavoriteEntity(title = currentTitle, imageRes = currentImage))
                }
                isFavorite = false
                binding.btnFav.setImageResource(R.drawable.heart)

                Toast.makeText(
                    this@BlockDetailsActivity,
                    "$title removed from Favorites 💔",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                // Add to favorites
                withContext(Dispatchers.IO) {
//                    db.favoriteDao().insertFavorite(FavoriteEntity(title = currentTitle, imageRes = currentImage))
                }
                isFavorite = true
                binding.btnFav.setImageResource(R.drawable.favorite)

                Toast.makeText(
                    this@BlockDetailsActivity,
                    "$title added to Favorites ❤️",
                    Toast.LENGTH_SHORT
                ).show()
            }
//            updateFavoriteIcon()
        }
    }

    private fun updateFavoriteIcon() {
        if (isFavorite) {
            binding.btnFav.setImageResource(R.drawable.heart)
        } else {
            binding.btnFav.setImageResource(R.drawable.favorite)
        }

    }
}