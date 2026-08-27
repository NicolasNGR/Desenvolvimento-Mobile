package br.edu.cadastroaluno

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.google.android.material.card.MaterialCardView
import kotlin.random.Random

class MatriculaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_matricula)

        val textNome = findViewById<TextView>(R.id.textNome)
        val textMatricula = findViewById<TextView>(R.id.textMatricula)
        val btnGerarMatricula = findViewById<MaterialButton>(R.id.btnGerarMatricula)
        val cardMatricula = findViewById<MaterialCardView>(R.id.cardMatricula)

        textNome.text = intent.getStringExtra("NOME") ?: ""

        btnGerarMatricula.setOnClickListener {
            val matricula = Random.nextInt(100000, 999999)
            textMatricula.text = "$matricula"
            cardMatricula.visibility = View.VISIBLE
        }
    }
}