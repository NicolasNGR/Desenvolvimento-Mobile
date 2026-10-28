package com.example.perfilfireauth.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun LoginScreen(
    busy: Boolean, message: String?, isError: Boolean,
    onLogin: (String, String) -> Unit,
    onCreateAccount: () -> Unit,
    onForgotPassword: () -> Unit
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var validationMessage by remember { mutableStateOf<String?>(null) }
    Column(Modifier.fillMaxSize().padding(24.dp), verticalArrangement = Arrangement.Center) {
        Text("Bem-vindo", style = MaterialTheme.typography.headlineLarge)
        Spacer(Modifier.height(8.dp)); Text("Entre na sua conta")
        Spacer(Modifier.height(24.dp))
        AuthFields(email, { email = it }, password, { password = it })
        Spacer(Modifier.height(20.dp))
        Button(onClick = {
            val error = validateEmailAndPassword(email, password)
            validationMessage = error
            if (error == null) onLogin(email.trim(), password)
        }, enabled = !busy, modifier = Modifier.fillMaxWidth()) { Text(if (busy) "Aguarde..." else "Entrar") }
        TextButton(onClick = onForgotPassword, enabled = !busy, modifier = Modifier.align(Alignment.CenterHorizontally)) {
            Text("Esqueci minha senha")
        }
        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()) {
            Text("Não tem conta?")
            TextButton(onClick = onCreateAccount, enabled = !busy) { Text("Criar conta") }
        }
        ScreenMessage(validationMessage ?: message, validationMessage != null || isError)
    }
}
