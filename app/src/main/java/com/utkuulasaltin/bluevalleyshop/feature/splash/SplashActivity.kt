package com.utkuulasaltin.bluevalleyshop.feature.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.utkuulasaltin.bluevalleyshop.MainActivity
import com.utkuulasaltin.bluevalleyshop.R
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        navigateToMainActivity()
    }

    private fun navigateToMainActivity() {

        lifecycleScope.launch {
            delay(3500)

            val intent = Intent(this@SplashActivity, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

    }
}