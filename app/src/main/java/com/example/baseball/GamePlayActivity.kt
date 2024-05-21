package com.example.baseball

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.baseball.databinding.ActivityGamePlayBinding
import com.example.baseball.domain.contracts.GamePlayContract
import com.example.baseball.presentation.GamePlayPresenter
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class GamePlayActivity : AppCompatActivity(), GamePlayContract.View {

    private lateinit var binding: ActivityGamePlayBinding
    private lateinit var presenter: GamePlayContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGamePlayBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initPresenter()
        initGetLifeState()
        initBtnStart()
    }

    private fun initPresenter() {
        val count = intent.getIntExtra("life", 0)
        presenter = GamePlayPresenter(this, count)
    }

    private fun initGetLifeState() {
        val count = intent.getIntExtra("life", 0)
        binding.txtLifeState.text = count.toString()
    }

    private fun initBtnStart() {
        binding.btnCheck.setOnClickListener {
            val inputText = binding.inputNumber.text.toString()
            val numberList: List<Int> = inputText.mapNotNull {
                it.toString().toIntOrNull()
            }

            if (numberList.isNotEmpty()) {
                presenter.playgame(numberList)
            } else {
                Toast.makeText(this, "유효한 숫자를 입력해주세요", Toast.LENGTH_SHORT).show()
            }
            binding.inputNumber.text.clear()
        }
    }

    override fun showLife(life: Int) {
        binding.txtLifeState.text = life.toString()
    }

    override fun showGameStatus(strike: Int, ball: Int) {
        Toast.makeText(this, "strike: $strike, ball: $ball", Toast.LENGTH_SHORT).show()
    }

    override fun showGameResult(gameResults: String, answer: List<Int>) {
        val finalAnswer = answer.toString()

        val dialogView = layoutInflater.inflate(R.layout.game_result_layout, null)

        val gameResultTextView: TextView = dialogView.findViewById(R.id.game_result)
        val answerTextView: TextView = dialogView.findViewById(R.id.answer)

        gameResultTextView.text = gameResults
        answerTextView.text = finalAnswer

        MaterialAlertDialogBuilder(this)
            .setView(dialogView)
            .setNegativeButton("나가기") { dialog, which ->
                finishAffinity()
            }
            .setPositiveButton("재시작") { dialog, which ->
                val intent = Intent(this, MainActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(intent)
                finish()
            }
            .show()
    }

}
