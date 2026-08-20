package com.example.calculadora

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var editNum1: EditText
    private lateinit var editNum2: EditText
    private lateinit var textResultado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editNum1 = findViewById(R.id.editNum1)
        editNum2 = findViewById(R.id.editNum2)
        textResultado = findViewById(R.id.textResultado)

        val btnSomar: Button = findViewById(R.id.btnSomar)
        val btnSubtrair: Button = findViewById(R.id.btnSubtrair)
        val btnMultiplicar: Button = findViewById(R.id.btnMultiplicar)
        val btnDividir: Button = findViewById(R.id.btnDividir)

        btnSomar.setOnClickListener { calcular('+') }
        btnSubtrair.setOnClickListener { calcular('-') }
        btnMultiplicar.setOnClickListener { calcular('*') }
        btnDividir.setOnClickListener { calcular('/') }
    }

    private fun calcular(operacao: Char) {
        val txt1 = editNum1.text.toString()
        val txt2 = editNum2.text.toString()

        if (txt1.isEmpty() || txt2.isEmpty()) {
            Toast.makeText(this, "Preencha os dois campos", Toast.LENGTH_SHORT).show()
            return
        }

        val n1 = txt1.toDouble()
        val n2 = txt2.toDouble()
        var resultado = 0.0

        when (operacao) {
            '+' -> resultado = n1 + n2
            '-' -> resultado = n1 - n2
            '*' -> resultado = n1 * n2
            '/' -> {
                if (n2 == 0.0) {
                    Toast.makeText(this, "Não é possível dividir por zero", Toast.LENGTH_SHORT).show()
                    return
                }
                resultado = n1 / n2
            }
        }

        textResultado.text = "Resultado: $resultado"
    }
}