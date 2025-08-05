package com.dhenkanal.amadhenkanal.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.dhenkanal.amadhenkanal.MainActivity
import com.dhenkanal.amadhenkanal.R
import com.dhenkanal.amadhenkanal.utils.Constant
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        initUi()
    }
    fun initUi(){
        lifecycleScope.launch {
            delay(Constant.SPLASH_TIMEOUT)
            startActivity(Intent(this@SplashScreenActivity, MainActivity::class.java))
            finish()
        }
    }
}