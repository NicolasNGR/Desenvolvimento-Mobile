package com.example.perfilfireauth.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ForgotPasswordScreen(
    busy: Boolean, message: String?, isError: Boolean,
    onSend: (String) -> Unit, onBackToLogin: () -> Unit
) {
    var email by remember { mutableStateOf("") }
    var validationMessage by remember { mutableStateOf<String?>(null) }
    Column(Modifier.fillMaxSize().padding(24.dp), verticalArrangement = Arrangement.Center) {
        Text("Redefinir senha", style = MaterialTheme.typography.headlineLarge)
        Spacer(Modifier.height(8.dp)); Text("Enviaremos um link de redefinição para seu e-mail")
        Spacer(Modifier.height(24.dp))
        AuthFields(email, { email = it })
        Spacer(Modifier.height(20.dp))
        Button(onClick = {
            val error = validateEmail(email)
            validationMessage = error
            if (error == null) onSend(email.trim())
        }, enabled = !busy, modifier = Modifier.fillMaxWidth()) {
            Text(if (busy) "Enviando..." else "Enviar link")
        }
        TextButton(onClick = onBackToLogin, enabled = !busy, modifier = Modifier.fillMaxWidth()) { Text("Voltar para login") }
        ScreenMessage(validationMessage ?: message, validationMessage != null || isError)
    }
}
