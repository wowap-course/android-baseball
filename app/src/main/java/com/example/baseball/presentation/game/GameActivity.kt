package com.example.baseball.presentation.game

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.baseball.R
import com.example.baseball.databinding.ActivityGameBinding
import com.example.baseball.presentation.game.results.GameResultAdapter
import com.example.baseball.presentation.main.MainActivity

class GameActivity : AppCompatActivity(), GameContract.View {
    private lateinit var binding: ActivityGameBinding
    private lateinit var presenter: GameContract.Presenter
    private var rvAdapter: GameResultAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        binding = ActivityGameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initPresenter()
        initTitleBar()
        initTextView()
        initButton()
        initAdapter()
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
            presenter.onTryBtnClicked(answer)
        }
    }

    private fun initAdapter() {
        rvAdapter = GameResultAdapter()
        binding.recyclerView.adapter = rvAdapter
    }

    override fun showResultOfInning(tryCount : Int, ball: Int, strike: Int, answer: List<Int>) {
        rvAdapter?.addData(tryCount, ball, strike, answer)
    }

    override fun showResultOfGame(resultOfGame: String, correctAnswer: Int) {
        val resultDialog = AlertDialog.Builder(this)
            .setTitle(resultOfGame)
            .setMessage(String.format(getString(R.string.correct_answer), correctAnswer))
            .setPositiveButton(
                getString(R.string.restart),
                DialogInterface.OnClickListener { dialog, which ->
                    presenter.onRestartBtnClicked()
                })
            .setNegativeButton(
                getString(R.string.exit),
                DialogInterface.OnClickListener { dialog, which ->
                    presenter.onExitBtnClicked()
                })
        resultDialog.create()
        resultDialog.show()
    }

    override fun showLifeCount(lifeCount: Int) {
        binding.tvRemainingLives.text = String.format(getString(R.string.remaining_life), lifeCount)
    }

    override fun showRequests(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

    override fun navigateToMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    override fun restartGameActivity(life: Int) {
        val intent = Intent(this, GameActivity::class.java)
        intent.putExtra("lifeCount", life)
        startActivity(intent)
    }
}

