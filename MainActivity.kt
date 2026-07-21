package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    lateinit var num1: EditText
    lateinit var num2: EditText
    lateinit var result: TextView

    lateinit var btnAdd: Button
    lateinit var btnSub: Button
    lateinit var btnMul: Button
    lateinit var btnDiv: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        num1 = findViewById(R.id.num1)
        num2 = findViewById(R.id.num2)
        result = findViewById(R.id.result)

        btnAdd = findViewById(R.id.btnAdd)
        btnSub = findViewById(R.id.btnSub)
        btnMul = findViewById(R.id.btnMul)
        btnDiv = findViewById(R.id.btnDiv)

        btnAdd.setOnClickListener {
            calculate('+')
        }

        btnSub.setOnClickListener {
            calculate('-')
        }

        btnMul.setOnClickListener {
            calculate('*')
        }

        btnDiv.setOnClickListener {
            calculate('/')
        }
    }

    private fun calculate(operator: Char) {

        val first = num1.text.toString()
        val second = num2.text.toString()

        if (first.isEmpty() || second.isEmpty()) {
            Toast.makeText(this, "Please enter both numbers", Toast.LENGTH_SHORT).show()
            return
        }

        val a = first.toDouble()
        val b = second.toDouble()

        val ans = when (operator) {
            '+' -> a + b
            '-' -> a - b
            '*' -> a * b
            '/' -> {
                if (b == 0.0) {
                    Toast.makeText(this, "Cannot divide by zero", Toast.LENGTH_SHORT).show()
                    return
                }
                a / b
            }
            else -> 0.0
        }

        result.text = ans.toString()
    }
}