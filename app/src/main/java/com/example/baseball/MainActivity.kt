package com.example.baseball

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.baseball.databinding.ActivityMainBinding
import com.example.baseball.domain.Life
import com.example.baseball.domain.Life.Companion.MIN_LIFE
import com.example.baseball.presentation.MainContract
import com.example.baseball.presentation.MainPresenter

class MainActivity : AppCompatActivity(), MainContract.View {

    private lateinit var binding: ActivityMainBinding

    private lateinit var presenter: MainContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initPresenter()
        initBtnPlus()
        initBtnMinus()
        initStartButton()
    }

    private fun initPresenter() {
        presenter = MainPresenter(this)
    }

    override fun showLife(life: Int) {
        binding.txCount.text = life.toString()
    }

    private fun initBtnPlus() {
        binding.btnPlus.setOnClickListener { presenter.increaseLife() }
    }

    private fun initBtnMinus() {
        binding.btnMinus.setOnClickListener { presenter.decreaseLife() }
    }

    private fun initStartButton() {
        binding.btnStart.setOnClickListener {
            val txCountValue = binding.txCount.text.toString().toIntOrNull() ?: 0
            val intent = Intent(this, GetCountActivity::class.java)
            intent.putExtra("count", txCountValue)
            startActivity(intent)
        }
    }

}
