package com.example.calcimc

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.Locale

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val textImcValor: TextView = findViewById(R.id.textImcValor)
        val textClassificacao: TextView = findViewById(R.id.textClassificacao)
        val btnVoltar: Button = findViewById(R.id.btnVoltar)

        val imc = intent.getDoubleExtra("IMC", 0.0)

        textImcValor.text = String.format(Locale.getDefault(), "Seu IMC: %.2f", imc)
        textClassificacao.text = classificarImc(imc)

        btnVoltar.setOnClickListener {
            finish() // volta para a tela anterior
        }
    }

    private fun classificarImc(imc: Double): String {
        return when {
            imc < 18.5 -> "Abaixo do peso"
            imc < 25.0 -> "Peso ideal"
            imc < 30.0 -> "Sobrepeso"
            else -> "Obesidade"
        }
    }
}