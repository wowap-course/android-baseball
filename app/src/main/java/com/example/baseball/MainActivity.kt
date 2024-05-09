package com.example.baseball

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.baseball.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var life = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initCount()
        initBtn()
    }

    private fun initCount() {
        binding.tvLife!!.text = life.toString()
        }


    private fun initBtn() {
        binding.btnPlus!!.setOnClickListener {
            if(life == 10) return@setOnClickListener
            life++
            binding.tvLife!!.text = life.toString()
        }
        binding.btnMinus!!.setOnClickListener {
            if(life == 1) return@setOnClickListener
            life--
            binding.tvLife!!.text = life.toString()
        }
    }


}