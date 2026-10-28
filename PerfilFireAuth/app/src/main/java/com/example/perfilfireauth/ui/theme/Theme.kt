package com.example.perfilfireauth.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val FireAuthColors = lightColorScheme(
    primary = Color(0xFFB3261E),
    onPrimary = Color.White,
    secondary = Color(0xFF6750A4),
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE)
)

@Composable
fun PerfilFireAuthTheme(content: @Composable () -> Unit) {
    MaterialTheme(colorScheme = FireAuthColors, content = content)
}
