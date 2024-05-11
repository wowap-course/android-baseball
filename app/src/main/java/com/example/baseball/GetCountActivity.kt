package com.example.baseball

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.baseball.databinding.ActivityGetCountBinding

class GetCountActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGetCountBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGetCountBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val count = intent.getIntExtra("count", 0)
        binding.txtGetCount.text = count.toString()
    }
}