package com.example.baseball.Game

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.baseball.R
import com.example.baseball.databinding.ActivityGameBinding

class GameActivity : AppCompatActivity(), GameContract.View {
    private var lifeCount: Int? = null
    private lateinit var binding: ActivityGameBinding
    private lateinit var presenter: GameContract.Presenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        lifeCount = intent.getIntExtra("life", 1)
        setContentView(R.layout.activity_game)
        binding = ActivityGameBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initPresenter()
        initCount()
        initBackBtn()
        initBtn()
    }

    private fun initPresenter() {
        presenter = GamePresenter(this)
    }

    private fun initBtn() {
        binding.startGame.setOnClickListener {
            val inputNumber =
                binding.inputBox.text.toString().toList().map { it.toString().toInt() }
            presenter.game(inputNumber)
        }
    }


    private fun initBackBtn() {
        binding.toolbarGame.backBtn.setOnClickListener {
            finish()
        }
    }

    private fun initCount() {
        binding.tvLifeTitle.text = getString(R.string.remain_life, lifeCount)
    }

    override fun showResult(strikeCount: Int, ballCount: Int) {
        Toast.makeText(
            this@GameActivity,
            "스트라이크 : ${strikeCount}, 볼 : $ballCount",
            Toast.LENGTH_SHORT
        ).show()
    }

}