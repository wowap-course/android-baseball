package com.example.baseball.Game

import android.content.DialogInterface
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.baseball.R
import com.example.baseball.databinding.ActivityGameBinding


class GameActivity : AppCompatActivity(), GameContract.View {
    private var life: Int? = null
    private lateinit var binding: ActivityGameBinding
    private lateinit var presenter: GameContract.Presenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        life = intent.getIntExtra("life", 1)
        setContentView(R.layout.activity_game)
        binding = ActivityGameBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initPresenter()
        val randomNumber = presenter.randomNumberGenerator()
        initCount()
        initBackBtn()
        initBtn(randomNumber)

    }


    private fun initPresenter() {
        presenter = GamePresenter(this)
    }


    private fun initBtn(randomNumber: List<Int>) {
        binding.startGame.setOnClickListener {
            val inputNumber =
                binding.inputBox.text.toString().toList().map { it.toString().toInt() }
            presenter.game(inputNumber, life)
        }
    }


    private fun initBackBtn() {
        binding.toolbarGame.backBtn.setOnClickListener {
            finish()
        }
    }

    private fun initCount() {
        binding.tvLifeTitle.text = getString(R.string.remain_life, life)
    }

    override fun showResult(strikeCount: Int, ballCount: Int, lifeCount: Int) {
        life = lifeCount
        binding.tvLifeTitle.text = getString(R.string.remain_life, life)
        Toast.makeText(
            this@GameActivity,
            getString(R.string.strike, strikeCount, ballCount),
            Toast.LENGTH_SHORT
        ).show()
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

