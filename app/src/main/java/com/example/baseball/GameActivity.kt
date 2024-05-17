package com.example.baseball

import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.baseball.databinding.ActivityGameBinding

class GameActivity : AppCompatActivity() {
    private lateinit var binding : ActivityGameBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        binding = ActivityGameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initTitleBar()
        initTextView()
        initButton()
    }

    private fun initTitleBar(){
        supportActionBar?.title = getString(R.string.app_name)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun initTextView(){
        val lifeCount = intent.getIntExtra("lifeCount", 0)
        binding.tvRemainingLives.text = String.format(getString(R.string.remaining_life), lifeCount)
    }

    private fun initButton() {
        binding.btnTry.setOnClickListener {
            showDialog()
        }
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
}