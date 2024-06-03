package com.example.baseball.presentation.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.example.baseball.presentation.game.GameActivity
import com.example.baseball.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val viewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initBtn()
        initObserve()
    }

    private fun initBtn() {
        binding.btnPlus.setOnClickListener {
            viewModel.increaseLife()
        }
        binding.btnMinus.setOnClickListener {
            viewModel.decreaseLife()
        }
        binding.btnStart.setOnClickListener {
            viewModel.gameStart()
        }
    }

    private fun initObserve() {
        viewModel.lifeCount.observe(this) { life ->
            showLife(life.count)
        }

        viewModel.event.observe(this) { event ->
            when (event) {
                is Event.NavigateToGame -> navigateToGameActivity(viewModel.lifeCount.value?.count ?: 1)
                is Event.ShowErrorMessage -> Toast.makeText(
                    baseContext,
                    event.message,
                    Toast.LENGTH_SHORT
                ).show()
            }

        }
    }

    private fun showLife(life: Int) {
        binding.tvLifeCount.text = life.toString()
    }

    private fun navigateToGameActivity(life: Int) {
        val intent = Intent(this, GameActivity::class.java)
        intent.putExtra("lifeCount", life)
        startActivity(intent)
    }
}

