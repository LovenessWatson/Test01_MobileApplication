package com.example.assignment_question02

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    private lateinit var firstNumberEditText: EditText
    private lateinit var secondNumberEditText: EditText
    private lateinit var addButton: Button
    private lateinit var subtractButton: Button
    private lateinit var multiplyButton: Button
    private lateinit var divideButton: Button
    private lateinit var resultTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        firstNumberEditText = findViewById(R.id.firstNumber)
        secondNumberEditText = findViewById(R.id.secondNumber)
        addButton = findViewById(R.id.addButton)
        subtractButton = findViewById(R.id.subtractButton)
        multiplyButton = findViewById(R.id.multiplyButton)
        divideButton = findViewById(R.id.divideButton)
        resultTextView = findViewById(R.id.resultTextView)


        addButton.setOnClickListener {
            performOperation('+')
        }

        subtractButton.setOnClickListener {
            performOperation('-')
        }

        multiplyButton.setOnClickListener {
            performOperation('*')
        }

        divideButton.setOnClickListener {
            performOperation('/')
        }
    }

    private fun performOperation(operator: Char) {
        val num1 = firstNumberEditText.text.toString().toDoubleOrNull()
        val num2 = secondNumberEditText.text.toString().toDoubleOrNull()

        if (num1 == null || num2 == null) {
            resultTextView.text = "Enter valid numbers"
            return
        }

        val result = when (operator) {
            '+' -> num1 + num2
            '-' -> num1 - num2
            '*' -> num1 * num2
            '/' -> {
                if (num2 == 0.0) {
                    resultTextView.text = "Cannot divide by zero"
                    return
                } else {
                    num1 / num2
                }
            }
            else -> 0.0
        }

        resultTextView.text = "Result: $result"
    }
}
