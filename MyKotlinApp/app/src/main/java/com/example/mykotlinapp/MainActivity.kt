package com.example.mykotlinapp

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.pow
import kotlin.math.sqrt

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var btnAdd: Button
    lateinit var btnSub: Button
    lateinit var btnMultiply: Button
    lateinit var btnDivision: Button
    lateinit var btnPower: Button
    lateinit var btnSqrt: Button
    lateinit var btnPercent: Button
    lateinit var btnClear: Button
    lateinit var etA: EditText
    lateinit var etB: EditText
    lateinit var resultTv: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnAdd = findViewById(R.id.btn_add)
        btnSub = findViewById(R.id.btn_subtraction)
        btnMultiply = findViewById(R.id.btn_multiplication)
        btnDivision = findViewById(R.id.btn_division)
        btnPower = findViewById(R.id.btn_power)
        btnSqrt = findViewById(R.id.btn_sqrt)
        btnPercent = findViewById(R.id.btn_percent)
        btnClear = findViewById(R.id.btn_clear)

        etA = findViewById(R.id.et_a)
        etB = findViewById(R.id.et_b)
        resultTv = findViewById(R.id.result_tv)

        val buttons = listOf(btnAdd, btnSub, btnMultiply, btnDivision, btnPower, btnSqrt, btnPercent, btnClear)
        buttons.forEach { it.setOnClickListener(this) }
    }

    override fun onClick(v: View?) {
        val a = etA.text.toString().toDoubleOrNull()
        val b = etB.text.toString().toDoubleOrNull()
        var result: Double? = null

        when (v?.id) {
            R.id.btn_add -> if (a != null && b != null) result = a + b
            R.id.btn_subtraction -> if (a != null && b != null) result = a - b
            R.id.btn_multiplication -> if (a != null && b != null) result = a * b
            R.id.btn_division -> if (a != null && b != null && b != 0.0) result = a / b
            R.id.btn_power -> if (a != null && b != null) result = a.pow(b)
            R.id.btn_sqrt -> if (a != null) result = sqrt(a)
            R.id.btn_percent -> if (a != null && b != null) result = (a * b) / 100
            R.id.btn_clear -> {
                etA.text.clear()
                etB.text.clear()
                resultTv.text = "0"
                return
            }
        }

        resultTv.text = result?.toString() ?: "Entrada inválida"
    }
}
