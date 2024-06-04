package com.example.baseball.Game

import BaseballAdapter
import Count
import android.content.DialogInterface
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.baseball.R
import com.example.baseball.databinding.ActivityGameBinding


class GameActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGameBinding
    private val viewModel: GameViewModel by viewModels {
        val life = intent.getIntExtra("life", 1)
        GameViewModel.Companion.GameViewModelFactory(life)
    }
    private lateinit var adapter: BaseballAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityGameBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initObserve()
        initBackBtn()
        initBtn()
    }

    private fun initObserve() {
        viewModel.life.observe(this) { life ->
            showLife(life.value)
        }

        viewModel.event.observe(this) { event ->
            when (event) {
                is Event.ShowResultDialog -> showResultDialog(event.message, event.answerNumber)
                is Event.ShowResult -> showResult(event.counts)
            }
        }
    }

    private fun showLife(lifeCount: Int) {
        binding.tvLifeTitle.text = getString(R.string.remain_life, lifeCount)
    }

    private fun initBtn() {
        binding.startGame.setOnClickListener {
            val inputNumber =
                binding.inputBox.text.toString().toList().map { it.toString().toInt() }
            viewModel.game(inputNumber)
        }
    }


    private fun initBackBtn() {
        binding.toolbarGame.backBtn.setOnClickListener {
            finish()
        }
    }


    fun showResult(counts: List<Count>) {
        adapter = BaseballAdapter(counts)
        binding.rvGameResult.adapter = adapter

    }

    fun showResultDialog(message: String, randomNumber: List<Int>) {
        val answer = randomNumber.joinToString("") { it.toString() }.toInt()
        AlertDialog.Builder(this)
            .setTitle(message)
            .setMessage(getString(R.string.answer, answer))
            .setPositiveButton(
                getString(R.string.restart),
                object : DialogInterface.OnClickListener {
                    override fun onClick(dialog: DialogInterface, which: Int) {
                        finish()
                        startActivity(intent)
                    }
                })
            .setNegativeButton(getString(R.string.quit), object : DialogInterface.OnClickListener {
                override fun onClick(dialog: DialogInterface, which: Int) {
                    finish()
                }
            })
            .create()
            .show()
    }
}
