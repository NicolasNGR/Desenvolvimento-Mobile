package br.edu.cadastroaluno

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

        val editNome = findViewById<TextInputEditText>(R.id.editNome)
        val btnAvancar = findViewById<MaterialButton>(R.id.btnAvancar)

        btnAvancar.setOnClickListener {
            val nome = editNome.text.toString().trim()

            if (nome.isEmpty()) {
                Toast.makeText(this, "Digite o nome do aluno", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val intent = Intent(this, MatriculaActivity::class.java)
            intent.putExtra("NOME", nome)
            startActivity(intent)
        }
    }
}