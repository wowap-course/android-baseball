package com.example.baseball.Main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.example.baseball.Game.GameActivity
import com.example.baseball.R
import com.example.baseball.databinding.ActivityMainBinding
import com.example.baseball.presentation.main.Event
import com.example.baseball.presentation.main.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initObserve()
        initPlusBtn()
        initMinusBtn()
        initStartBtn()
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

    private fun showLife(life: Int) {
        binding.tvLife.text = life.toString()
    }

    private fun navigateToGame(life: Int) {
        val intent = Intent(baseContext, GameActivity::class.java)
        intent.putExtra("life", life)
        startActivity(intent)
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

    private fun initStartBtn() {
        binding.btnStart.setOnClickListener {
            viewModel.startGame()
        }
    }
}