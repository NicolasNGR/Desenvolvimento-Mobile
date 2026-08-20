package com.example.conversortemperatura

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editCelsius: EditText = findViewById(R.id.editCelsius)
        val textResultado: TextView = findViewById(R.id.textResultado)
        val btnConverter: Button = findViewById(R.id.btnConverter)

        btnConverter.setOnClickListener {
            val txt = editCelsius.text.toString()

            if (txt.isEmpty()) {
                Toast.makeText(this, "Digite uma temperatura", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val celsius = txt.toDouble()
            val fahrenheit = (celsius * 9 / 5) + 32

            textResultado.text = "Resultado: $fahrenheit °F"
        }
    }
}