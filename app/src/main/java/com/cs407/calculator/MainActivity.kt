package com.cs407.calculator



import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val firstNumber = findViewById<EditText>(R.id.firstNumber)
        val secondNumber = findViewById<EditText>(R.id.secondNumber)
        val addButton = findViewById<Button>(R.id.addButton)
        val subtractButton = findViewById<Button>(R.id.subtractButton)
        val multiplyButton = findViewById<Button>(R.id.multiplyButton)
        val divideButton = findViewById<Button>(R.id.divideButton)

        // Addition
        addButton.setOnClickListener {
            performOperation(firstNumber, secondNumber, "add")
        }

        // Subtraction
        subtractButton.setOnClickListener {
            performOperation(firstNumber, secondNumber, "subtract")
        }

        // Multiplication
        multiplyButton.setOnClickListener {
            performOperation(firstNumber, secondNumber, "multiply")
        }

        // Division
        divideButton.setOnClickListener {
            performOperation(firstNumber, secondNumber, "divide")
        }
    }

    private fun performOperation(first: EditText, second: EditText, operation: String) {
        if (first.text.isEmpty() || second.text.isEmpty()) {
            Toast.makeText(this, "Please enter both numbers", Toast.LENGTH_SHORT).show()
            return
        }

        val num1 = first.text.toString().toInt()
        val num2 = second.text.toString().toInt()
        val result = when (operation) {
            "add" -> num1 + num2
            "subtract" -> num1 - num2
            "multiply" -> num1 * num2
            "divide" -> {
                if (num2 == 0) {
                    Toast.makeText(this, "Cannot divide by zero", Toast.LENGTH_SHORT).show()
                    return
                }
                num1 / num2
            }
            else -> 0
        }

        // Passing result to new activity
        val intent = Intent(this, ResultActivity::class.java).apply {
            putExtra("RESULT", result)
        }
        startActivity(intent)
    }
}
