package com.example.baseball.presentation.main

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.baseball.databinding.ActivityMainBinding
import com.example.baseball.presentation.GameActivity

class MainActivity : AppCompatActivity(), MainContract.View {

    private lateinit var binding: ActivityMainBinding

    private lateinit var presenter: MainContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        presenter = MainPresenter(this)
        initPlusBtn()
        initMinusBtn()
        initGameStartBtn()
    }

    override fun showLife(life: Int) {
        binding.tvLife.text = life.toString()
    }

    private fun initMinusBtn() {
        binding.btnMinus.setOnClickListener {
            presenter.decreaseLife()
        }
    }

    private fun initPlusBtn() {
        binding.btnPlus.setOnClickListener {
            presenter.increaseLife()
        }
    }

    private fun initGameStartBtn() {
        binding.btnStartGame.setOnClickListener {
            presenter.gameStart()
        }
    }

    override fun navigateToGame(life: Int) {
        val intent = Intent(baseContext, GameActivity::class.java)
        intent.putExtra("life", life)
        startActivity(intent)
    }
}
