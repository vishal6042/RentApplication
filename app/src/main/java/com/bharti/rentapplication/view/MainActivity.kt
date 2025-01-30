package com.bharti.rentapplication.view

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bharti.rentapplication.R
import com.bharti.rentapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val rotatingImage: ImageView = findViewById(R.id.rotatingImage)

        // Rotate the image
        val rotationAnimator = ObjectAnimator.ofFloat(rotatingImage, "rotationY", 0f, 360f)
        rotationAnimator.duration = 2000 // 2 seconds
        rotationAnimator.repeatCount = ValueAnimator.INFINITE
        rotationAnimator.repeatMode = ValueAnimator.REVERSE
        rotationAnimator.start()

        // Move to the next activity after 2 seconds
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, DashboardActivity::class.java)
            startActivity(intent)
            finish()
        }, 2000)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

}