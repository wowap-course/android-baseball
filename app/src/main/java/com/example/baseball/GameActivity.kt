package com.example.baseball

import android.app.Activity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class GameActivity: Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_main)
        val imageView = findViewById<ImageView>(R.id.backBtn)
        imageView.setOnClickListener {onImageClick()}
    }

    private fun onImageClick() {
        finish()
    }
}