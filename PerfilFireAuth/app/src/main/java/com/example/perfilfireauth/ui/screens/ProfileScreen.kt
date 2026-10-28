package com.example.perfilfireauth.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ProfileScreen(
    email: String, busy: Boolean, message: String?, isError: Boolean,
    onSignOut: () -> Unit, onDeleteAccount: () -> Unit
) {
    var showDeleteDialog by remember { mutableStateOf(false) }
    Column(Modifier.fillMaxSize().padding(24.dp), verticalArrangement = Arrangement.Center) {
        Text("Meu perfil", style = MaterialTheme.typography.headlineLarge)
        Spacer(Modifier.height(16.dp))
        Text("Você está conectado como:")
        Text(email, style = MaterialTheme.typography.titleMedium)
        Spacer(Modifier.height(24.dp))
        Button(onClick = onSignOut, enabled = !busy, modifier = Modifier.fillMaxWidth()) { Text("Sair") }
        Spacer(Modifier.height(8.dp))
        OutlinedButton(onClick = { showDeleteDialog = true }, enabled = !busy, modifier = Modifier.fillMaxWidth()) {
            Text("Excluir minha conta")
        }
        ScreenMessage(message, isError)
    }
    if (showDeleteDialog) {
        AlertDialog(
            onDismissRequest = { showDeleteDialog = false },
            title = { Text("Excluir conta?") },
            text = { Text("Esta ação é permanente e removerá sua conta do Firebase Authentication.") },
            confirmButton = {
                TextButton(onClick = { showDeleteDialog = false; onDeleteAccount() }) { Text("Excluir") }
            },
            dismissButton = { TextButton(onClick = { showDeleteDialog = false }) { Text("Cancelar") } }
        )
    }
}
