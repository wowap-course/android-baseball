package com.example.baseball.presentation.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.baseball.GameActivity
import com.example.baseball.R
import com.example.baseball.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), MainContract.View {
    private lateinit var binding : ActivityMainBinding
    private lateinit var presenter: MainContract.Presenter
    private var toast : Toast? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initPresenter()
        initBtn()
    }

    private fun initPresenter() {
        presenter = MainPresenter(this)
    }

    private fun initBtn() {
        binding.btnPlus.setOnClickListener {
            presenter.increaseLife()
        }
        binding.btnMinus.setOnClickListener {
            presenter.decreaseLife()
        }

        binding.btnStart.setOnClickListener {
            presenter.onGameStartBtnClicked()
        }
    }

    override fun showLife(life: Int) {
        binding.tvLifeCount.text = life.toString()
    }

    override fun showMaxLife() {
        toast?.cancel()
        toast = Toast.makeText(this, getString(R.string.max_life_count_description), Toast.LENGTH_SHORT)
        toast?.show()
    }

    override fun showMinLife() {
        toast?.cancel()
        toast = Toast.makeText(this, getString(R.string.min_life_count_description), Toast.LENGTH_SHORT)
        toast?.show()
    }

    override fun navigateToGameActivity(life : Int) {
        val intent = Intent(this, GameActivity::class.java)
        intent.putExtra("lifeCount", life)
        startActivity(intent)
    }
}