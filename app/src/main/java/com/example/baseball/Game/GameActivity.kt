package com.example.baseball.Game

import BaseballAdapter
import Count
import android.content.DialogInterface
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.baseball.R
import com.example.baseball.databinding.ActivityGameBinding


class GameActivity : AppCompatActivity(), GameContract.View {

    private lateinit var binding: ActivityGameBinding
    private lateinit var presenter: GameContract.Presenter
    private lateinit var adapter: BaseballAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_game)
        binding = ActivityGameBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initPresenter()
        val randomNumber = presenter.randomNumberGenerator()
        initBackBtn()
        initBtn(randomNumber)

    }

    private fun initPresenter() {
        presenter = GamePresenter(this, intent.getIntExtra("life", 1))
    }

    private fun initBtn(randomNumber: List<Int>) {
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

    override fun showLife(lifeCount: Int) {
        binding.tvLifeTitle.text = getString(R.string.remain_life, lifeCount)
    }


    override fun showResult(counts: List<Count>) {
        adapter = BaseballAdapter(counts)
        binding.rvGameResult.adapter = adapter

    }

    override fun showWinDialog(randomNumber: List<Int>) {
        val answer = randomNumber.joinToString("") { it.toString() }.toInt()
        AlertDialog.Builder(this)
            .setTitle(getString(R.string.win))
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

    override fun showLoseDialog(randomNumber: List<Int>) {
        val answer = randomNumber.joinToString("") { it.toString() }.toInt()
        AlertDialog.Builder(this)
            .setTitle(getString(R.string.lose))
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
