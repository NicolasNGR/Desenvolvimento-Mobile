package br.edu.applivro

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetalheLivroActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhe_livro)

        val textTitulo = findViewById<TextView>(R.id.textTitulo)
        val textAutor = findViewById<TextView>(R.id.textAutor)

        textTitulo.text = intent.getStringExtra("TITULO") ?: ""
        textAutor.text = intent.getStringExtra("AUTOR") ?: ""
    }
}