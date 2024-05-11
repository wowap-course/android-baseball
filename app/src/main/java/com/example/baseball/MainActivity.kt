package com.example.baseball

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.baseball.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var count = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initCount()
        initBtn()
        initStartButton()
    }

    private fun initCount() {
        binding.txCount.text = count.toString()
    }

    private fun initBtn() {
        binding.btnPlus.setOnClickListener {
            if (count < 10) {
                count++
                binding.txCount.text = count.toString()
            }
        }
        binding.btnMinus.setOnClickListener {
            if (count > 1) {
                count--
                binding.txCount.text = count.toString()
            }
        }
    }

    private fun initStartButton() {
        binding.btnStart.setOnClickListener {
            val intent = Intent(this, GetCount::class.java)
            intent.putExtra("count", count)
            startActivity(intent)
        }
    }
}
