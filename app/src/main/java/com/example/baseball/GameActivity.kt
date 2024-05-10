package com.example.baseball

import android.app.Activity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class GameActivity: Activity() {
    private var lifeCount: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifeCount = intent.getIntExtra("life",1)
        setContentView(R.layout.activity_game_main)
        val imageView = findViewById<ImageView>(R.id.backBtn)
        imageView.setOnClickListener {onImageClick()}
        initCount()
    }

    private fun onImageClick() {
        finish()
    }

    private fun initCount() {
        val textView = findViewById<TextView>(R.id.tvLifeCount)
        textView.text = lifeCount.toString()
    }
}