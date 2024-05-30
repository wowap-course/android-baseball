package com.example.baseball.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.baseball.game.GameActivity
import com.example.baseball.R
import com.example.baseball.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), MainContract.View {

    private lateinit var binding: ActivityMainBinding
    private lateinit var presenter: MainContract.Presenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initPresenter()
        initPlusBtn()
        initMinusBtn()
        initStartBtn()
    }

    private fun initPresenter() {
        presenter = MainPresenter(this)
    }

    override fun showLife(life: Int) {
        binding.tvLife.text = life.toString()
    }

    override fun startGamePage(life: Int) {
        val intent = Intent(this, GameActivity::class.java)
        intent.putExtra("life", life)
        startActivity(intent)
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

    private fun initStartBtn() {
        binding.btnStart.setOnClickListener {
            presenter.startGame()
        }
    }
}
