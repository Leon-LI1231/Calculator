package com.cs407.calculator


import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_acitivity)

        val resultText = findViewById<TextView>(R.id.resultText)
        val result = intent.getIntExtra("RESULT", 0)

        resultText.text = "Result: $result"
    }
}

