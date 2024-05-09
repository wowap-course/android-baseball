package com.example.baseball

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.baseball.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var count = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initCount()
        initBtn()
    }

    private fun initCount() {
        binding.tvCount!!.text = count.toString()
        }


    private fun initBtn() {
        binding.btnPlus!!.setOnClickListener {
            if(count == 10) return@setOnClickListener
            count++
            binding.tvCount!!.text = count.toString()
        }
        binding.btnMinus!!.setOnClickListener {
            if(count == 0) return@setOnClickListener
            count--
            binding.tvCount!!.text = count.toString()
        }
    }


}