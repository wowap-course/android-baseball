package com.example.baseball.presentation.game

import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.baseball.R
import com.example.baseball.databinding.ActivityGameBinding

class GameActivity : AppCompatActivity(), GameContract.View {
    private lateinit var binding: ActivityGameBinding
    private lateinit var presenter: GameContract.Presenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        binding = ActivityGameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initPresenter()
        initTitleBar()
        initTextView()
        initButton()
    }

    private fun initPresenter() {
        presenter = GamePresenter(this, intent.getIntExtra("lifeCount", 0))
    }

    private fun initTitleBar() {
        supportActionBar?.title = getString(R.string.app_name)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun initTextView() {
        val lifeCount = intent.getIntExtra("lifeCount", 0)
        showLifeCount(lifeCount)
    }

    private fun initButton() {
        binding.btnTry.setOnClickListener {
            val answer = binding.etReadBaseballNumbers.text.toString()
            presenter.playOneRound(answer)
        }
    }

    override fun showResultOfInning(ball: Int, strike: Int) {
        Log.d("ResultOfInning", "ball : $ball, strike : $strike")
    }

    private fun showDialog() {
        var resultDialog = AlertDialog.Builder(this)
        resultDialog.setTitle(getString(R.string.success))
        resultDialog.setMessage(String.format(getString(R.string.answer), ))

        val listener = DialogInterface.OnClickListener { dialog, which ->
            when(which) {
                DialogInterface.BUTTON_POSITIVE ->
                    Log.d("dialog", "positive")

                DialogInterface.BUTTON_NEGATIVE ->
                    Log.d("dialog", "negative")
            }
        }
        resultDialog.setPositiveButton(getString(R.string.restart), listener)
        resultDialog.setNegativeButton(getString(R.string.exit), listener)
        resultDialog.show()
    }

    override fun showLifeCount(lifeCount: Int) {
        binding.tvRemainingLives.text = String.format(getString(R.string.remaining_life), lifeCount)
    }
}

