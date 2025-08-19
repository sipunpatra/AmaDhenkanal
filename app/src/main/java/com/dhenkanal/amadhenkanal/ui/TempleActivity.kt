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
            TempleModel(R.drawable.chandrasekhera,"Baba Chandrashekhar Temple ","Kapilash Rd, Bidharpur,Dhenkanal,Odisha 759016", Color.parseColor("#BBEF84")),
            TempleModel(R.drawable.joranda,"Joranda Gadi","",Color.parseColor("#AA5309")),
            TempleModel(R.drawable.saptasajya,"Raghunath temple ","",Color.parseColor("#007eb3")),
            TempleModel(R.drawable.kualu,"Astasambu temple","",Color.parseColor("#CB007D53")),
            TempleModel(R.drawable.maabileisunisaktipitha,"Maa Bileisuni","",Color.parseColor("#52959c")),
            TempleModel(R.drawable.budheswar,"Budheswar Temple","",Color.parseColor("#b18dba")),
            TempleModel(R.drawable.kapileswar,"Sri Kapileswar Temple","",Color.parseColor("#b18dba")),
            TempleModel(R.drawable.pathargadasiba,"Pathar Gada Shiba Temple","",Color.parseColor("#96aed6")),
            TempleModel(R.drawable.daudeswar,"Daodeswar Shiba Temple","",Color.parseColor("#96aed6")),

            )
        binding.templeRecycler.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.templeRecycler.adapter = TempleAdapter(imageList)
    }
}