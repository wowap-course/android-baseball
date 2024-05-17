package com.example.baseball.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.baseball.databinding.ActivityGameBinding

class GameActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGameBinding
    private var life: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGameBinding.inflate(layoutInflater)

        life = intent.getIntExtra("life", 1)
        binding.tvLife.text = life.toString()
        setContentView(binding.root)
    }
}
