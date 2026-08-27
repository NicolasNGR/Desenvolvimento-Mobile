package br.edu.applivro

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editTitulo = findViewById<TextInputEditText>(R.id.editTitulo)
        val editAutor = findViewById<TextInputEditText>(R.id.editAutor)
        val btnCadastrar = findViewById<MaterialButton>(R.id.btnCadastrar)

        btnCadastrar.setOnClickListener {
            val titulo = editTitulo.text.toString().trim()
            val autor = editAutor.text.toString().trim()

            if (titulo.isEmpty() || autor.isEmpty()) {
                Toast.makeText(this, "Preencha título e autor", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val intent = Intent(this, DetalheLivroActivity::class.java)
            intent.putExtra("TITULO", titulo)
            intent.putExtra("AUTOR", autor)
            startActivity(intent)
        }
    }
}