package com.example.appcompose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import java.util.Locale

@Composable
fun CalculadoraDescontoScreen() {
    var precoTexto by remember { mutableStateOf("") }
    var percentualTexto by remember { mutableStateOf("") }
    var resultado by remember {
        mutableStateOf(
            "Informe o preço e o percentual, depois toque em calcular."
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        Text(
            text = "Calculadora de Desconto",
            style = MaterialTheme.typography.headlineSmall
        )

        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = precoTexto,
            onValueChange = { precoTexto = it },
            label = { Text("Preço do produto") },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Decimal
            ),
            singleLine = true
        )

        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = percentualTexto,
            onValueChange = { percentualTexto = it },
            label = { Text("Percentual de desconto") },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Decimal
            ),
            singleLine = true
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                val preco = precoTexto
                    .trim()
                    .replace(',', '.')
                    .toDoubleOrNull()

                val percentual = percentualTexto
                    .trim()
                    .replace(',', '.')
                    .toDoubleOrNull()

                if (preco == null || !preco.isFinite() || preco < 0.0) {
                    resultado = "Digite um preço válido, igual ou maior que zero."
                } else if (
                    percentual == null ||
                    !percentual.isFinite() ||
                    percentual !in 0.0..100.0
                ) {
                    resultado = "Digite um desconto entre 0% e 100%."
                } else {
                    val precoFinal = calcularPrecoComDesconto(
                        preco = preco,
                        percentual = percentual
                    )

                    resultado = String.format(
                        Locale("pt", "BR"),
                        "Preço final: R$ %.2f",
                        precoFinal
                    )
                }
            }
        ) {
            Text("CALCULAR")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = resultado,
            style = MaterialTheme.typography.bodyLarge
        )
    }
}