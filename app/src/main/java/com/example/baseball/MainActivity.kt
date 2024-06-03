package com.example.baseball

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.baseball.databinding.ActivityMainBinding
import com.example.baseball.presentation.MainViewModel

class MainActivity : AppCompatActivity(){

    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initObserve()
        initBtnPlus()
        initBtnMinus()
        initStartButton()
    }

    private fun initObserve() {
        viewModel.life.observe(this) {
            life -> showLife(life.count)
        }
    }

    private fun showLife(life: Int) {
        binding.txLife.text = life.toString()
    }

    private fun initBtnPlus() {
        binding.btnPlus.setOnClickListener { viewModel.increaseLife() }
    }

    private fun initBtnMinus() {
        binding.btnMinus.setOnClickListener { viewModel.decreaseLife() }
    }

    private fun initStartButton() {
        binding.btnStart.setOnClickListener {
            val txCountValue = binding.txLife.text.toString().toIntOrNull() ?: 0
            val intent = Intent(this, GamePlayActivity::class.java)
            intent.putExtra("life", txCountValue)
            startActivity(intent)
        }
    }

}
