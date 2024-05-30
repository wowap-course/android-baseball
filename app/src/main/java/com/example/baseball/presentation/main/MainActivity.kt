package com.example.baseball.presentation.main

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.baseball.databinding.ActivityMainBinding
import com.example.baseball.presentation.GameActivity

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initPlusBtn()
        initMinusBtn()
        initGameStartBtn()
        initObserve()
    }

    private fun initObserve() {
        viewModel.life.observe(this) { life ->
            showLife(life.value)
        }
        viewModel.event.observe(this) { event ->
            when (event) {
                is Event.NavigateToGame -> navigateToGame(viewModel.life.value?.value ?: 1)
                is Event.ShowErrorMessage -> Toast.makeText(
                    baseContext,
                    event.message,
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    private fun initMinusBtn() {
        binding.btnMinus.setOnClickListener {
            viewModel.decreaseLife()
        }
    }

    private fun initPlusBtn() {
        binding.btnPlus.setOnClickListener {
            viewModel.increaseLife()
        }
    }

    private fun initGameStartBtn() {
        binding.btnStartGame.setOnClickListener {
            viewModel.gameStart()
        }
    }

    private fun showLife(life: Int) {
        binding.tvLife.text = life.toString()
    }

    private fun navigateToGame(life: Int) {
        val intent = Intent(baseContext, GameActivity::class.java)
        intent.putExtra("life", life)
        startActivity(intent)
    }
}
