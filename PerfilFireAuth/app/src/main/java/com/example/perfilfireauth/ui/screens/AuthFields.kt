package com.example.perfilfireauth.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.ui.unit.dp

@Composable
internal fun AuthFields(
    email: String,
    onEmailChange: (String) -> Unit,
    password: String? = null,
    onPasswordChange: ((String) -> Unit)? = null,
) {
    Column {
        OutlinedTextField(
            value = email, onValueChange = onEmailChange,
            label = { Text("E-mail") }, singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            modifier = Modifier.fillMaxWidth()
        )
        if (password != null && onPasswordChange != null) {
            Spacer(Modifier.height(12.dp))
            OutlinedTextField(
                value = password, onValueChange = onPasswordChange,
                label = { Text("Senha (mínimo 6 caracteres)") }, singleLine = true,
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Composable
internal fun ScreenMessage(message: String?, isError: Boolean) {
    if (message != null) {
        Spacer(Modifier.height(12.dp))
        Text(message, color = if (isError) MaterialTheme.colorScheme.error else MaterialTheme.colorScheme.primary)
    }
}

internal fun validateEmailAndPassword(email: String, password: String): String? = when {
    email.isBlank() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches() -> "Digite um e-mail válido."
    password.length < 6 -> "A senha precisa ter pelo menos 6 caracteres."
    else -> null
}

internal fun validateEmail(email: String): String? =
    if (email.isBlank() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) "Digite um e-mail válido." else null
