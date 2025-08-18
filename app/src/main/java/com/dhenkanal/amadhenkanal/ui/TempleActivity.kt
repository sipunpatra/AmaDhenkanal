package com.dhenkanal.amadhenkanal.ui

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.dhenkanal.amadhenkanal.R
import com.dhenkanal.amadhenkanal.adapter.DamAdapter
import com.dhenkanal.amadhenkanal.adapter.TempleAdapter
import com.dhenkanal.amadhenkanal.databinding.ActivityTempleBinding
import com.dhenkanal.amadhenkanal.model.DamModel
import com.dhenkanal.amadhenkanal.model.TempleModel

class TempleActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTempleBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTempleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpRecyclerView()
    }

    private fun setUpRecyclerView() {
        val imageList = listOf(
            TempleModel(R.drawable.sapua,"Kapilash", Color.parseColor("#BBEF84")),
            TempleModel(R.drawable.sapua,"Joranda Gadi",Color.parseColor("#AA5309")),
            TempleModel(R.drawable.sapua,"Saptasajya",Color.parseColor("#007eb3")),
            TempleModel(R.drawable.kualu,"Kualu",Color.parseColor("#CB007D53")),

            )
        binding.templeRecycler.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.templeRecycler.adapter = TempleAdapter(imageList)
    }
}