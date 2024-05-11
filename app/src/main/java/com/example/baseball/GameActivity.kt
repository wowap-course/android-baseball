package com.example.baseball

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.baseball.databinding.ActivityGameBinding

class GameActivity : AppCompatActivity() {
    private var lifeCount: Int? = null
    private lateinit var binding: ActivityGameBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        lifeCount = intent.getIntExtra("life", 1)
        setContentView(R.layout.activity_game)
        binding = ActivityGameBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initCount()
    }

    private fun initCount() {
        binding.tvLifeTitle.text = getString(R.string.remain_life, lifeCount)
    }

    fun onImageClick(view: View) {
        finish()
    }
}