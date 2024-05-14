package com.example.baseball.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.baseball.databinding.ActivityMainBinding
import com.example.baseball.domain.model.Life

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var life = Life(1)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initCount()
        initPlusBtn()
        initMinusBtn()
        initResetBtn()
    }

    private fun initCount() {
        binding.tvLife.text = life.value.toString()
    }

    private fun initMinusBtn() {
        binding.btnMinus.setOnClickListener {
            life--
            binding.tvLife.text = life.value.toString()
        }
    }

    private fun initPlusBtn() {
        binding.btnPlus.setOnClickListener {
            life++
            binding.tvLife.text = life.value.toString()
        }
    }

    private fun initResetBtn() {
        binding.btnStartGame.setOnClickListener {
            val intent = Intent(this, GameActivity::class.java)
            intent.putExtra("life", life.value)
            startActivity(intent)
        }
    }
}
