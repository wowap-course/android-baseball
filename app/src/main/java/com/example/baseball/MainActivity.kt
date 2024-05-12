package com.example.baseball

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.baseball.databinding.ActivityMainBinding
import com.example.baseball.domain.Life

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var life = Life(1)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initCount()
        initBtn()
    }

    private fun initCount() {
        binding.tvLife.text = getString(R.string.life_count, life.life)
        }


    private fun initBtn() {
        binding.btnPlus.setOnClickListener {
            binding.tvLife.text = getString(R.string.life_count, life.increase())
        }
        binding.btnMinus.setOnClickListener {
            binding.tvLife.text = getString(R.string.life_count, life.decrease())
        }
    }

    fun onClick(view: View) {
        val intent = Intent(this, GameActivity::class.java)
        intent.putExtra("life", life.life)
        startActivity(intent)
    }


}