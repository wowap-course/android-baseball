package com.example.baseball.presentation.game

import android.content.DialogInterface
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.baseball.R
import com.example.baseball.databinding.ActivityGameBinding
import com.example.baseball.presentation.game.results.GameResultAdapter

class GameActivity : AppCompatActivity() {
    private val binding: ActivityGameBinding by lazy { ActivityGameBinding.inflate(layoutInflater) }
    private val viewModel: GameViewModel by viewModels {GameViewModelFactory(intent.getIntExtra("lifeCount", 0))}
    private val rvAdapter: GameResultAdapter by lazy { GameResultAdapter() }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initTitleBar()
        initTextView()
        initButton()
        initAdapter()
        initObserver()
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
            viewModel.onTryBtnClicked(answer)
        }
    }

    private fun initAdapter() {
        binding.recyclerView.adapter = rvAdapter
    }

    private fun initObserver() {
        viewModel.remainingLife.observe(this) { life ->
            showLifeCount(life.count)
        }

        viewModel.score.observe(this) { score ->
            showResultOfInning(
                score.tryCount,
                score.ball,
                score.strike,
                score.answerOfInning.map { it.toInt() })
        }

        viewModel.event.observe(this) { event ->
            when (event) {
                is Event.ShowRequests -> showRequests(event.message)
                is Event.ShowResult -> showResultOfGame(event.result, event.correctAnswer)
                is Event.RestartGameActivity -> {
                    finish()
                    startActivity(intent)
                }
                is Event.NavigateToMainActivity -> finish()
            }
        }
    }

    private fun showResultOfInning(tryCount: Int, ball: Int, strike: Int, answer: List<Int>) {
        rvAdapter.addData(tryCount, ball, strike, answer)
    }

    private fun showResultOfGame(resultOfGame: String, correctAnswer: Int) {
        val resultDialog = AlertDialog.Builder(this)
            .setTitle(resultOfGame)
            .setMessage(String.format(getString(R.string.correct_answer), correctAnswer))
            .setPositiveButton(
                getString(R.string.restart),
                DialogInterface.OnClickListener { dialog, which ->
                    finish()
                    startActivity(intent)
                })
            .setNegativeButton(
                getString(R.string.exit),
                DialogInterface.OnClickListener { dialog, which ->
                    finish()
                })
        resultDialog.create()
        resultDialog.show()
    }

    private fun showLifeCount(lifeCount: Int) {
        binding.tvRemainingLives.text = String.format(getString(R.string.remaining_life), lifeCount)
    }

    private fun showRequests(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }
}