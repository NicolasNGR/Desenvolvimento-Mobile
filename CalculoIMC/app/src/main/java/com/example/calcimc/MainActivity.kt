package com.example.calcimc

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var editPeso: EditText
    private lateinit var editAltura: EditText
    private lateinit var btnCalcular: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editPeso = findViewById(R.id.editPeso)
        editAltura = findViewById(R.id.editAltura)
        btnCalcular = findViewById(R.id.btnCalcular)

        btnCalcular.setOnClickListener {
            val pesoTexto = editPeso.text.toString().trim()
            val alturaTexto = editAltura.text.toString().trim()

            if (pesoTexto.isEmpty() || alturaTexto.isEmpty()) {
                Toast.makeText(this, "Preencha peso e altura", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val peso = parseNumero(pesoTexto)
            val altura = parseNumero(alturaTexto)

            if (peso == null || altura == null) {
                Toast.makeText(this, "Digite números válidos", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (altura <= 0 || peso <= 0) {
                Toast.makeText(this, "Valores inválidos", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val imc = peso / (altura * altura)

            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("IMC", imc)
            startActivity(intent)
        }
    }

    private fun parseNumero(texto: String): Double? {
        val textoNormalizado = texto.replace(",", ".")
        return textoNormalizado.toDoubleOrNull()
    }
}