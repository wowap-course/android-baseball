package com.example.baseball

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.baseball.databinding.ActivityMainBinding
import com.example.baseball.domain.LifeCount

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var lives = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initLives()
        initBtn()
    }

    private fun initLives() {
        binding.tvLives.text = lives.toString()
    }

    private fun initBtn() {
        binding.btnPlus.setOnClickListener {
            lives++
            binding.tvLives.text = lives.toString()
        }
        binding.btnMinus.setOnClickListener {
            lives--
            binding.tvLives.text = lives.toString()
        }

        binding.btnStart.setOnClickListener {
            val intent = Intent(this, GameActivity::class.java)
            startActivity(intent)
        }
    }
}