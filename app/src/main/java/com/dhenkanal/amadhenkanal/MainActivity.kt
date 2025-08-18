package com.dhenkanal.amadhenkanal

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.dhenkanal.amadhenkanal.adapter.BlockAdapterDetailsAdapter
import com.dhenkanal.amadhenkanal.adapter.ImageAdapter
import com.dhenkanal.amadhenkanal.databinding.ActivityMainBinding
import com.dhenkanal.amadhenkanal.model.ImageItem
import com.dhenkanal.amadhenkanal.model.StoryItem
import com.dhenkanal.amadhenkanal.ui.DamActivity
import com.dhenkanal.amadhenkanal.ui.FamousActivity
import com.dhenkanal.amadhenkanal.ui.MapActivity
import com.dhenkanal.amadhenkanal.ui.MoreDetailsActivity
import com.dhenkanal.amadhenkanal.ui.TempleActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private lateinit var viewPager: ViewPager2
    private lateinit var adapter: ImageAdapter
    private val handler = Handler(Looper.getMainLooper())
    private var currentPage = 0
    private val runnable = object : Runnable {
        override fun run() {
            if (adapter.itemCount == 0) return
            currentPage = (currentPage + 1) % adapter.itemCount
            viewPager.setCurrentItem(currentPage, true)
            handler.postDelayed(this, 3000)
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        uiInitialization()
    }

    private fun uiInitialization() {

        binding.bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_explore -> { /* Your code */ true }
                R.id.nav_map -> {
                    startActivity(Intent(this, MapActivity::class.java).apply {
                        addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
                    })
                    finish()
                    true }
//                R.id.nav_what_to_do -> { /* Your code */ true }
//                R.id.nav_event -> { /* Your code */ true }
                R.id.nav_famous -> {
                    startActivity(Intent(this, FamousActivity::class.java).apply {
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
                    true }
                else -> false
            }
        }

        binding.llDam.setOnClickListener {
           val intent =Intent(applicationContext,DamActivity::class.java)
            startActivity(intent)
        }
        binding.llTemple.setOnClickListener {
            val intent =Intent(applicationContext,TempleActivity::class.java)
            startActivity(intent)
        }


        val storyRecycler = findViewById<RecyclerView>(R.id.storyRecycler)

        val stories = listOf(
            StoryItem(R.drawable.rajbatika, "Dhenkanal Sadar (Dhenkanal Block)", Color.parseColor("#FF9800")),
            StoryItem(R.drawable.budheswar, "Bhuban", Color.parseColor("#673AB7")),
            StoryItem(R.drawable.joranda, "Gondia", Color.parseColor("#03A9F4")),
            StoryItem(R.drawable.denkanal, "Hindol", Color.parseColor("#F44336")),
            StoryItem(R.drawable.denkanal, "Kamakhyanagar", Color.parseColor("#FF9800")),
            StoryItem(R.drawable.dand, "Kankadahad", Color.parseColor("#673AB7")),
            StoryItem(R.drawable.denkanal, "Odapada", Color.parseColor("#03A9F4")),
            StoryItem(R.drawable.kualu, "Parjang", Color.parseColor("#F44336"))
        )
        storyRecycler.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        storyRecycler.adapter = BlockAdapterDetailsAdapter(stories)


         val imageList = listOf(
            ImageItem("https://instagram.fbbi5-1.fna.fbcdn.net/v/t51.29350-15/405769861_805931104636014_6136490927569236925_n.webp?stp=dst-jpg_e35_tt6&efg=eyJ2ZW5jb2RlX3RhZyI6IkNBUk9VU0VMX0lURU0uaW1hZ2VfdXJsZ2VuLjE0NDB4MTgwMC5zZHIuZjI5MzUwLmRlZmF1bHRfaW1hZ2UuYzIifQ&_nc_ht=instagram.fbbi5-1.fna.fbcdn.net&_nc_cat=106&_nc_oc=Q6cZ2QG3aWosl3NrYW8B8bdtN_o6AR5MtOTqY7uw2xqO_5pcI5ir6pikn81qkf9nOJN7oHNH8lkymN-2Oec7rRr8TJBl&_nc_ohc=GqP0veiyT2wQ7kNvwHar0_N&_nc_gid=lMuRX83YseJmGzHKZZpSCA&edm=APoiHPcBAAAA&ccb=7-5&ig_cache_key=MzI0ODkzOTQxODM1NDM5MzQ0NA%3D%3D.3-ccb7-5&oh=00_AfSAPxoEEjktJeGC0ZrlLG-MFW2GXr9LDGieCInQmVqlVA&oe=68943ABA&_nc_sid=22de04", " Dhenkanal Palace ", "Legacy of craftsmanship and kings."),
            ImageItem("https://instagram.fbbi5-1.fna.fbcdn.net/v/t51.2885-15/526586969_17920721862128188_4396329421525405857_n.webp?stp=dst-webp_p640x640_sh0.08&efg=eyJ2ZW5jb2RlX3RhZyI6IkNBUk9VU0VMX0lURU0uaW1hZ2VfdXJsZ2VuLjE0NDB4MTkyMC5zZHIuZjgyNzg3LmRlZmF1bHRfaW1hZ2UuZXhwZXJpbWVudGFsIn0&_nc_ht=instagram.fbbi5-1.fna.fbcdn.net&_nc_cat=104&_nc_oc=Q6cZ2QHqfU-8QCw3LXsFiGheqfAZMKMqCiqA25jWpCJv2_e1HqS67SEmnLHdd0WxUZC40vzLP1ow713pbRGIgeugTyjO&_nc_ohc=AAdBfcjiEYsQ7kNvwHC91vR&_nc_gid=6XTwIZHtYLMRZu4U0kLgdA&edm=AP4sbd4BAAAA&ccb=7-5&ig_cache_key=MzY4OTU2ODc2MzM0OTI2NDQyOQ%3D%3D.3-ccb7-5&oh=00_AfRMBxJljUSAE0LMw_u_vjgJLCs3Z7UBEMhQKz7d_t8H-A&oe=68943AF6&_nc_sid=7a9f4b", "Sapua Dam", "The Sapua Dam is built on the Sapua, a small Indian river which is a tributary of the Mahanadi River. It is located near Rasol in the Hindol block of Odisha’s Dhenkanal district"),
            ImageItem("https://instagram.fbbi5-1.fna.fbcdn.net/v/t51.2885-15/525439000_17920377480128188_4518334874636628256_n.webp?efg=eyJ2ZW5jb2RlX3RhZyI6IkNBUk9VU0VMX0lURU0uaW1hZ2VfdXJsZ2VuLjE0NDB4MTkyMC5zZHIuZjgyNzg3LmRlZmF1bHRfaW1hZ2UuYzIifQ&_nc_ht=instagram.fbbi5-1.fna.fbcdn.net&_nc_cat=104&_nc_oc=Q6cZ2QG2US3qPXFeP6nicfKUL5XFxw202bQ-u_XK8DgcqFgeDBPLr-iPXeum19o-Ac82rhR6bhMCGOXss7XuELiJSCm9&_nc_ohc=Py6d9y-i5J0Q7kNvwE2tQyp&_nc_gid=csPLrNsyA4pEntcsck6Iog&edm=APoiHPcBAAAA&ccb=7-5&ig_cache_key=MzY4NzI5NzQ2NjU4MTg5NDg3Nw%3D%3D.3-ccb7-5&oh=00_AfRE76xIbxavJgJgRZUEPlFBOHCfSXLC4ZX2tqLaTxxqpQ&oe=689465F3&_nc_sid=22de04", "Temple", "Kapilash Temple, also known as Mahadev Chandrashekhar Temple"),
            ImageItem("https://instagram.fbbi5-2.fna.fbcdn.net/v/t51.29350-15/464758399_917232473204665_6959069328357842384_n.webp?stp=dst-jpg_e35_tt6&efg=eyJ2ZW5jb2RlX3RhZyI6IkNBUk9VU0VMX0lURU0uaW1hZ2VfdXJsZ2VuLjE0NDB4MTgwMC5zZHIuZjI5MzUwLmRlZmF1bHRfaW1hZ2UuYzIifQ&_nc_ht=instagram.fbbi5-2.fna.fbcdn.net&_nc_cat=101&_nc_oc=Q6cZ2QEcd-54TWr7TXYhT8x2RdOXdrn78V7jAVTEbKLzdl20jmXr9GPbloeEa5Q6vFvxylNCmkZ9GDVKJA-ZcgwIqtmF&_nc_ohc=m-NofE39b8UQ7kNvwGG4EwD&_nc_gid=x9xkx-vmFG6HuIHjightFw&edm=APs17CUBAAAA&ccb=7-5&ig_cache_key=MzQ5MDEwMzY4Mjc5NDg0NjE3Mw%3D%3D.3-ccb7-5&oh=00_AfQaNdQPf_NnLwMNX3jIyTRfpHbFZnUgIjy3G8IJkaYXfQ&oe=6894411F&_nc_sid=10d13b", "Joranda Matha", "Kapilash Temple, also known as Mahadev Chandrashekhar Temple"),
            ImageItem("https://instagram.fbbi5-2.fna.fbcdn.net/v/t51.29350-15/472461478_1253027385956289_1456973068926202391_n.webp?stp=dst-jpg_e35_s1080x1080_tt6&efg=eyJ2ZW5jb2RlX3RhZyI6IkNBUk9VU0VMX0lURU0uaW1hZ2VfdXJsZ2VuLjE0NDB4MTQ0MC5zZHIuZjI5MzUwLmRlZmF1bHRfaW1hZ2UuYzIifQ&_nc_ht=instagram.fbbi5-2.fna.fbcdn.net&_nc_cat=109&_nc_oc=Q6cZ2QF2OaWGazidLWzXTNA82A4Sbgpzx5NU93jwzYwh5pwg-gtvqG2IQ8Jb6WPNFuofN1USN4uPE_euteWCdd509LO6&_nc_ohc=UAV4PjyJKP8Q7kNvwFr1QCv&_nc_gid=hjcovaj7-Z8yJ4pSNfv5bA&edm=APs17CUBAAAA&ccb=7-5&ig_cache_key=MzUzODIxNzI0ODM3ODk5MzU4Ng%3D%3D.3-ccb7-5&oh=00_AfTD5ut7h5aVvla1K_PbG23CI-ft7A-jySjHZGEI_gtgBQ&oe=68945DB8&_nc_sid=10d13b", "Saptyasajya", "Kapilash Temple, also known as Mahadev Chandrashekhar Temple"),
            ImageItem("https://instagram.fbbi5-1.fna.fbcdn.net/v/t51.29350-15/451938854_503232065471284_671606673948406281_n.webp?stp=dst-jpg_e35_tt6&efg=eyJ2ZW5jb2RlX3RhZyI6IkZFRUQuaW1hZ2VfdXJsZ2VuLjEwODB4MTM1MC5zZHIuZjI5MzUwLmRlZmF1bHRfaW1hZ2UuYzIifQ&_nc_ht=instagram.fbbi5-1.fna.fbcdn.net&_nc_cat=104&_nc_oc=Q6cZ2QHIc3BverC1fiX1fiRc2V_ibS8qxTmB4OfTXWCdmR3Nb4NEsRKxIRpA6zAxfimSNt0QVXwMrUbuLYJMSkPwG7X5&_nc_ohc=4p6ORXXkbykQ7kNvwEzh0dT&_nc_gid=jR2qvXDGhZVcAuG0sUabSg&edm=AFlAz-oBAAAA&ccb=7-5&ig_cache_key=MzQxNTcxMjIyNDkwMjcyMjMyMg%3D%3D.3-ccb7-5&oh=00_AfXxjpt1vhbUBY74E9GVV7ghEUY52DFGH_s3NioBMZ6Fcg&oe=68A14A90&_nc_sid=76c0fc", "Budheswar Temple", ""),
            ImageItem("https://instagram.fbbi5-1.fna.fbcdn.net/v/t51.2885-15/503476744_17915685465128188_1630186252220610632_n.webp?stp=dst-webp_p640x640_sh0.08&efg=eyJ2ZW5jb2RlX3RhZyI6IkNBUk9VU0VMX0lURU0uaW1hZ2VfdXJsZ2VuLjE0NDB4MTgwMC5zZHIuZjc1NzYxLmRlZmF1bHRfaW1hZ2UuYzIifQ&_nc_ht=instagram.fbbi5-1.fna.fbcdn.net&_nc_cat=104&_nc_oc=Q6cZ2QEUEUhmMQfiV0ymrwPm55A3LnQL35zPjk2ugmcyEyW8JmtQw2jJBv3Kjv6uwaF0k3H6JEQA6FeJBrnNNefkgGa1&_nc_ohc=OtDyBGQ0888Q7kNvwGdKZew&_nc_gid=dZ6rzyvN_3aTE7A6e1KUeA&edm=AFlAz-oBAAAA&ccb=7-5&ig_cache_key=MzY1ODQ3MDQ1NjE3MDYzMzEwMQ%3D%3D.3-ccb7-5&oh=00_AfV_7zYobuq_c7TuqfqogwpMFf5BgadchiEjv5VLGtfdiw&oe=68A17CEA&_nc_sid=76c0fc", "Anantasayan", "Anantashayi Vishnu, also known as Anantashayana Vishnu (both literally \"sleeping on the serpent Ananta\"), is a large open air horizontal rock relief of the Hindu god Vishnu, carved during the early 9th century in Saranga village"),
        )

        viewPager = findViewById(R.id.viewpager)
        adapter = ImageAdapter(imageList)
        viewPager.adapter = adapter

        // Auto-scroll start
        handler.postDelayed(runnable, 5000)
    }

    override fun onPause() {
        super.onPause()
        handler.removeCallbacks(runnable)
    }

    override fun onResume() {
        super.onResume()
        handler.postDelayed(runnable, 3000)
    }
}

