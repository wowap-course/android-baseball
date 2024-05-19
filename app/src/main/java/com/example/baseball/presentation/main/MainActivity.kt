package com.example.baseball.presentation.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.baseball.GameActivity
import com.example.baseball.R
import com.example.baseball.databinding.ActivityMainBinding
import com.example.baseball.domain.LifeCount

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private var toast : Toast? = null
    private val lifeCount = LifeCount()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initLifeCount()
        initBtn()
    }

    private fun initLifeCount() {
        binding.tvLifeCount.text = lifeCount.count.toString()
    }

    private fun initBtn() {
        binding.btnPlus.setOnClickListener {
            if(!lifeCount.increase()) showToast(getString(R.string.max_life_count_description))
            else binding.tvLifeCount.text = lifeCount.count.toString()
        }
        binding.btnMinus.setOnClickListener {
            if(!lifeCount.decrease()) showToast(getString(R.string.min_life_count_description))
            else binding.tvLifeCount.text = lifeCount.count.toString()
        }

        binding.btnStart.setOnClickListener {
            val intent = Intent(this, GameActivity::class.java)
            intent.putExtra("lifeCount", lifeCount.count)
            startActivity(intent)
        }
    }
    private fun showToast(msg : String){
        toast?.cancel()
        toast = Toast.makeText(this, msg, Toast.LENGTH_SHORT)
        toast?.show()
    }
}