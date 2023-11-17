package com.example.equipo8.view

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.example.equipo8.R
import com.example.equipo8.databinding.ActivityMainBinding
import com.example.equipo8.view.fragment.inicio

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val handler = Handler(Looper.getMainLooper())
        handler.postDelayed({
            val fragmentManager = supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            val fragment = inicio()
            fragmentTransaction.add(R.id.fragment_container, fragment)
            fragmentTransaction.commit()
        },5000)
    }
}




