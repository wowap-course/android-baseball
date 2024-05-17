package com.example.baseball

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.baseball.databinding.ActivityGamePlayBinding
import com.example.baseball.domain.contracts.GamePlayContract
import com.example.baseball.presentation.GamePlayPresenter

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
        presenter = GamePlayPresenter(this)
    }

    private fun initGetLifeState() {
        val count = intent.getIntExtra("life", 0)
        binding.txtLifeState.text = count.toString()
    }

    private fun initBtnStart() {
        binding.btnCheck.setOnClickListener {
            val inputText = binding.inputNumber.text.toString()

            // 입력된 문자열을 개별 문자로 분리하고 각 문자를 Int로 변환
            val numberList: List<Int> = inputText.mapNotNull {
                it.toString().toIntOrNull()
            }

            if (numberList.isNotEmpty()) {
                // Controller에게 numberList를 전달하는 함수가 구현 되어야 함
                presenter.playgame(numberList)
            } else {
                // 유효한 숫자가 입력되지 않은 경우 사용자에게 알림을 표시
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
}