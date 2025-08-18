package com.dhenkanal.amadhenkanal.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.dhenkanal.amadhenkanal.R
import com.dhenkanal.amadhenkanal.adapter.BlockAdapterDetailsAdapter
import com.dhenkanal.amadhenkanal.adapter.DamAdapter
import com.dhenkanal.amadhenkanal.databinding.ActivityDamBinding
import com.dhenkanal.amadhenkanal.model.DamModel
import com.dhenkanal.amadhenkanal.model.ImageItem

class DamActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDamBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDamBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        val imageList = listOf(
            DamModel(R.drawable.dand,"Dandadhara Dam","Nestled in the lap of nature, Dandadhar Dam is one of the most enchanting spots in Dhenkanal District,Kankadahada Block, Odisha. Built across the serene Ramial River, the dam is surrounded by rolling hills, lush green forests, and tranquil waters, creating a picture-perfect setting for nature lovers."),
            DamModel(R.drawable.sapua,"Sapua Dam","Sapua Dam is a blend of natural beauty, rural charm, and peaceful surroundings, making it one of the most beautiful offbeat destinations in Dhenkanal."),
            DamModel(R.drawable.dadaradhati,"Dadaraghati Dam","Dadaraghati Dam is not just an irrigation project but a hidden natural paradise of Dhenkanal, perfect for a refreshing trip amidst forests, hills, and water."),

                 )
        binding.DamRecycler.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.DamRecycler.adapter = DamAdapter(imageList)
    }
}