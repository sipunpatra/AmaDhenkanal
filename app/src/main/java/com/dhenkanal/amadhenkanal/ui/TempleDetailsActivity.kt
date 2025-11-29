package com.dhenkanal.amadhenkanal.ui

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.dhenkanal.amadhenkanal.R
import com.dhenkanal.amadhenkanal.databinding.ActivityTempleDetailsBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class TempleDetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTempleDetailsBinding

    private var isFavorite =false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding= ActivityTempleDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }

        ui()
    }

    private fun ui() {
        binding.btnBack.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        binding.btnFav.setOnClickListener {
            toggleFavorite()

        }
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
                    this@TempleDetailsActivity,
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
                    this@TempleDetailsActivity,
                    "$title added to Favorites ❤️",
                    Toast.LENGTH_SHORT
                ).show()
            }
//            updateFavoriteIcon()
        }
    }

}