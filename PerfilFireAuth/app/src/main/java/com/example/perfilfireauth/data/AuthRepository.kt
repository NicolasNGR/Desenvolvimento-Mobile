package com.example.perfilfireauth.data

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

/** Centraliza as operações de autenticação solicitadas na tarefa. */
class AuthRepository(private val auth: FirebaseAuth = FirebaseAuth.getInstance()) {
    val currentUser: FirebaseUser? get() = auth.currentUser

    fun signIn(email: String, password: String, onResult: (Result<FirebaseUser>) -> Unit) {
        auth.signInWithEmailAndPassword(email, password).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                val user = task.result?.user
                if (user != null) onResult(Result.success(user))
                else onResult(Result.failure(Exception("O Firebase não retornou o usuário.")))
            } else {
                onResult(Result.failure(task.exception ?: Exception("Não foi possível entrar.")))
            }
        }
    }

    fun createAccount(email: String, password: String, onResult: (Result<FirebaseUser>) -> Unit) {
        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                val user = task.result?.user
                if (user != null) onResult(Result.success(user))
                else onResult(Result.failure(Exception("O Firebase não retornou o usuário.")))
            } else {
                onResult(Result.failure(task.exception ?: Exception("Não foi possível criar a conta.")))
            }
        }
    }

    fun sendPasswordReset(email: String, onResult: (Result<Unit>) -> Unit) {
        auth.sendPasswordResetEmail(email).addOnCompleteListener { task ->
            if (task.isSuccessful) onResult(Result.success(Unit))
            else onResult(Result.failure(task.exception ?: Exception("Não foi possível enviar o e-mail.")))
        }
    }

    fun signOut() = auth.signOut()

    fun deleteCurrentUser(onResult: (Result<Unit>) -> Unit) {
        val user = auth.currentUser
        if (user == null) {
            onResult(Result.failure(Exception("Nenhuma conta está conectada.")))
            return
        }
        user.delete().addOnCompleteListener { task ->
            if (task.isSuccessful) onResult(Result.success(Unit))
            else onResult(Result.failure(task.exception ?: Exception("Não foi possível excluir a conta.")))
        }
    }
}
