package com.example.calculoleiohm

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

        val editTensao: EditText = findViewById(R.id.editTensao)
        val editResistencia: EditText = findViewById(R.id.editResistencia)
        val editCorrente: EditText = findViewById(R.id.editCorrente)
        val textResultado: TextView = findViewById(R.id.textResultado)
        val btnCalcular: Button = findViewById(R.id.btnCalcular)

        btnCalcular.setOnClickListener {
            val txtV = editTensao.text.toString()
            val txtR = editResistencia.text.toString()
            val txtI = editCorrente.text.toString()

            val temV = txtV.isNotEmpty()
            val temR = txtR.isNotEmpty()
            val temI = txtI.isNotEmpty()

            val preenchidos = listOf(temV, temR, temI).count { it }

            if (preenchidos != 2) {
                Toast.makeText(this, "Preencha exatamente 2 campos", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            when {
                temV && temR -> {
                    val v = txtV.toDouble()
                    val r = txtR.toDouble()
                    if (r == 0.0) {
                        Toast.makeText(this, "Resistência não pode ser zero", Toast.LENGTH_SHORT).show()
                        return@setOnClickListener
                    }
                    val i = v / r
                    textResultado.text = "Corrente (I) = $i A"
                }
                temV && temI -> {
                    val v = txtV.toDouble()
                    val i = txtI.toDouble()
                    if (i == 0.0) {
                        Toast.makeText(this, "Corrente não pode ser zero", Toast.LENGTH_SHORT).show()
                        return@setOnClickListener
                    }
                    val r = v / i
                    textResultado.text = "Resistência (R) = $r Ω"
                }
                temR && temI -> {
                    val r = txtR.toDouble()
                    val i = txtI.toDouble()
                    val v = r * i
                    textResultado.text = "Tensão (V) = $v V"
                }
            }
        }
    }
}