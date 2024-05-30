package com.example.baseball.game

import com.example.baseball.game.baseballcounts.BaseballAdapter
import com.example.baseball.game.baseballcounts.BaseballCountItem
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.baseball.R
import com.example.baseball.databinding.ActivityGameBinding


class GameActivity : AppCompatActivity(), GameContract.View {

    private val binding: ActivityGameBinding by lazy {
        ActivityGameBinding.inflate(layoutInflater)
    }
    private val presenter: GameContract.Presenter by lazy {
        GamePresenter(this, intent.getIntExtra(KEY_LIFE, 1))
    }
    private lateinit var adapter: BaseballAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initView()
    }

    private fun initView() {
        initBackBtn()
        initStartGameBtn()
        initAdapter()
    }

    override fun showLife(lifeCount: Int) {
        binding.tvLifeTitle.text = getString(R.string.remain_life, lifeCount)
    }

    override fun showResult(baseballCountItems: List<BaseballCountItem>) {
        adapter.submitList(baseballCountItems)
    }

    private fun initAdapter() {
        adapter = BaseballAdapter()
        binding.rvGameResult.adapter = adapter
    }

    private fun initStartGameBtn() {
        binding.btnChallenge.setOnClickListener {
            val inputNumber =
                binding.inputBox.text.toString().toList().map { it.toString().toInt() }
            presenter.challenge(inputNumber)
        }
    }

    private fun initBackBtn() {
        binding.toolbarGame.backBtn.setOnClickListener {
            finish()
        }
    }

    override fun showWinDialog(randomNumber: List<Int>) {
        val answer = randomNumber.joinToString("") { it.toString() }.toInt()
        AlertDialog.Builder(this)
            .setTitle(getString(R.string.win))
            .setMessage(getString(R.string.answer, answer))
            .setPositiveButton(getString(R.string.restart)) { dialog, which ->
                finish()
                startActivity(intent)
            }
            .setNegativeButton(getString(R.string.quit)) { dialog, which -> finish() }
            .create()
            .show()
    }

    override fun showLoseDialog(randomNumber: List<Int>) {
        val answer = randomNumber.joinToString("") { it.toString() }.toInt()
        AlertDialog.Builder(this)
            .setTitle(getString(R.string.lose))
            .setMessage(getString(R.string.answer, answer))
            .setPositiveButton(getString(R.string.restart)) { dialog, which ->
                finish()
                startActivity(intent)
            }
            .setNegativeButton(getString(R.string.quit)) { dialog, which -> finish() }
            .create()
            .show()
    }

    companion object {
        const val KEY_LIFE = "life"
    }
}
