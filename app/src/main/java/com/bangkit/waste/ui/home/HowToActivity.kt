package com.bangkit.waste.ui.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bangkit.waste.databinding.ActivityHowToBinding

class HowToActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        val binding = ActivityHowToBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}