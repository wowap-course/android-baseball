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

        initGetLifeState()
    }

    private fun initGetLifeState() {
        val count = intent.getIntExtra("life", 0)
        binding.txtLifeState.text = count.toString()
    }
}