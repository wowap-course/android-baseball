package com.example.baseball

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
        materialNegativePositiveDialog("성공", 123)
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
        }
    }

    override fun showLife(life: Int) {
        binding.txtLifeState.text = life.toString()
    }

    override fun showGameStatus(strike: Int, ball: Int) {
        Toast.makeText(this, "strike: $strike, ball: $ball", Toast.LENGTH_SHORT).show()
    }

    override fun showThreeStrike() {
        Toast.makeText(this, "성공", Toast.LENGTH_SHORT).show()
    }

    private fun materialNegativePositiveDialog(gameResult: String, answer: Int) {
        val finalAnswer = answer.toString()

        // 커스텀 뷰를 인플레이트합니다.
        val dialogView = layoutInflater.inflate(R.layout.game_result_layout, null)

        // 커스텀 뷰 내의 텍스트뷰를 초기화합니다.
        val gameResultTextView: TextView = dialogView.findViewById(R.id.game_result)
        val answerTextView: TextView = dialogView.findViewById(R.id.answer)

        // 텍스트뷰에 텍스트를 설정합니다.
        gameResultTextView.text = gameResult
        answerTextView.text = finalAnswer

        // 다이얼로그 빌더에 커스텀 뷰를 설정합니다.
        MaterialAlertDialogBuilder(this)
            .setView(dialogView)
            .setNegativeButton("나가기") { dialog, which ->
                // Respond to negative button press
            }
            .setPositiveButton("재시작") { dialog, which ->
                // Respond to positive button press
            }
            .show()
    }

}
