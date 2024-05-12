package com.example.baseball

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.baseball.databinding.ActivityMainBinding
import com.example.baseball.domain.LifeCount

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val lifeCount = LifeCount()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initLives()
        initBtn()
    }

    private fun initLives() {
        binding.tvLives.text = lifeCount.lifeCount
    }

    private fun initBtn() {
        binding.btnPlus.setOnClickListener {
            lifeCount.increase()
            binding.tvLives.text = lifeCount.lifeCount
        }
        binding.btnMinus.setOnClickListener {
            lifeCount.decrease()
            binding.tvLives.text = lifeCount.lifeCount
        }

        binding.btnStart.setOnClickListener {
            val intent = Intent(this, GameActivity::class.java)
            intent.putExtra("lifeCount", lifeCount.lifeCount)
            startActivity(intent)
        }
    }
}