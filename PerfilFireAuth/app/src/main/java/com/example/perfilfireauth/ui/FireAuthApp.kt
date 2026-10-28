package com.example.perfilfireauth.ui

import androidx.compose.runtime.*
import com.example.perfilfireauth.data.AuthRepository
import com.example.perfilfireauth.ui.screens.ForgotPasswordScreen
import com.example.perfilfireauth.ui.screens.LoginScreen
import com.example.perfilfireauth.ui.screens.ProfileScreen
import com.example.perfilfireauth.ui.screens.RegisterScreen
import com.google.firebase.auth.FirebaseAuthRecentLoginRequiredException

private enum class Screen { Login, Register, ForgotPassword, Profile }

@Composable
fun FireAuthApp(repository: AuthRepository = remember { AuthRepository() }) {
    var screen by remember { mutableStateOf(if (repository.currentUser == null) Screen.Login else Screen.Profile) }
    var busy by remember { mutableStateOf(false) }
    var message by remember { mutableStateOf<String?>(null) }
    var isError by remember { mutableStateOf(false) }

    fun showResult(result: Result<*>, successMessage: String, onSuccess: () -> Unit = {}) {
        busy = false
        result.fold(
            onSuccess = { onSuccess(); isError = false; message = successMessage },
            onFailure = { error ->
                isError = true
                message = if (error is FirebaseAuthRecentLoginRequiredException)
                    "Por segurança, entre novamente antes de excluir sua conta."
                else error.localizedMessage ?: "Ocorreu um erro. Tente novamente."
            }
        )
    }

    when (screen) {
        Screen.Login -> LoginScreen(
            busy = busy, message = message, isError = isError,
            onLogin = { email, password ->
                busy = true; message = null
                repository.signIn(email, password) { result ->
                    showResult(result, "Login realizado com sucesso.") { screen = Screen.Profile }
                }
            },
            onCreateAccount = { message = null; screen = Screen.Register },
            onForgotPassword = { message = null; screen = Screen.ForgotPassword }
        )
        Screen.Register -> RegisterScreen(
            busy = busy, message = message, isError = isError,
            onRegister = { email, password ->
                busy = true; message = null
                repository.createAccount(email, password) { result ->
                    showResult(result, "Conta criada com sucesso.") { screen = Screen.Profile }
                }
            },
            onBackToLogin = { message = null; screen = Screen.Login }
        )
        Screen.ForgotPassword -> ForgotPasswordScreen(
            busy = busy, message = message, isError = isError,
            onSend = { email ->
                busy = true; message = null
                repository.sendPasswordReset(email) { result ->
                    showResult(result, "E-mail de redefinição enviado.")
                }
            },
            onBackToLogin = { message = null; screen = Screen.Login }
        )
        Screen.Profile -> ProfileScreen(
            email = repository.currentUser?.email.orEmpty(), busy = busy,
            message = message, isError = isError,
            onSignOut = {
                repository.signOut(); busy = false; message = null; screen = Screen.Login
            },
            onDeleteAccount = {
                busy = true; message = null
                repository.deleteCurrentUser { result ->
                    showResult(result, "Sua conta foi excluída.") {
                        screen = Screen.Login
                    }
                }
            }
        )
    }
}
