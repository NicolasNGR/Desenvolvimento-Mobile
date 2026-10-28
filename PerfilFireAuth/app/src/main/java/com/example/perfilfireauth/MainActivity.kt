package com.example.perfilfireauth

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.perfilfireauth.ui.FireAuthApp
import com.example.perfilfireauth.ui.theme.PerfilFireAuthTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { PerfilFireAuthTheme { FireAuthApp() } }
    }
}
