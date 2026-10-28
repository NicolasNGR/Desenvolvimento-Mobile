package com.example.perfilfireauth.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun RegisterScreen(
    busy: Boolean, message: String?, isError: Boolean,
    onRegister: (String, String) -> Unit, onBackToLogin: () -> Unit
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var validationMessage by remember { mutableStateOf<String?>(null) }
    Column(Modifier.fillMaxSize().padding(24.dp), verticalArrangement = Arrangement.Center) {
        Text("Criar conta", style = MaterialTheme.typography.headlineLarge)
        Spacer(Modifier.height(8.dp)); Text("Use seu e-mail e escolha uma senha")
        Spacer(Modifier.height(24.dp))
        AuthFields(email, { email = it }, password, { password = it })
        Spacer(Modifier.height(20.dp))
        Button(onClick = {
            val error = validateEmailAndPassword(email, password)
            validationMessage = error
            if (error == null) onRegister(email.trim(), password)
        }, enabled = !busy, modifier = Modifier.fillMaxWidth()) { Text(if (busy) "Aguarde..." else "Cadastrar") }
        TextButton(onClick = onBackToLogin, enabled = !busy, modifier = Modifier.fillMaxWidth()) { Text("Voltar para login") }
        ScreenMessage(validationMessage ?: message, validationMessage != null || isError)
    }
}
