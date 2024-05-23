package com.example.baseball.Main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.baseball.Game.GameActivity
import com.example.baseball.R
import com.example.baseball.databinding.ActivityMainBinding
import com.example.baseball.domain.Life
import com.example.baseball.presentation.main.MainPresenter

class MainActivity : AppCompatActivity(), MainContract.View {

    private lateinit var binding: ActivityMainBinding
    private lateinit var presenter: MainContract.Presenter
    private var life = Life(1)
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