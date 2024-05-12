package com.example.baseball

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.baseball.databinding.ActivityGameBinding

class GameActivity : AppCompatActivity() {
    private lateinit var binding : ActivityGameBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        binding = ActivityGameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initTitleBar()
        initTextView()
    }

    private fun initTitleBar(){
        supportActionBar?.title = "Baseball"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun initTextView(){
        val lifeCount = intent.getStringExtra("lifeCount")
        binding.tvRemainingLives.text = "남은 목숨 : $lifeCount"
    }
}