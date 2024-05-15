package com.example.baseball

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.baseball.databinding.ActivityGamePlayBinding

class GamePlayActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGamePlayBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityGamePlayBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val count = intent.getIntExtra("count", 0)
        binding.txtGetCount.text = count.toString()
    }
}