package com.ebayk.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.MaterialTheme.shapes
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color


private val LightColorPalette = lightColors(
    primary = primaryColor,
    secondary = colorPrimaryDark,
    background = white,
    surface = Color.White.copy(alpha = .85f),
    onPrimary = Color.White,
    onSecondary = Color.White,
)

private val DarkColorPalette = darkColors(
    primary = primaryColor,
    secondary = colorPrimaryDark,
    background = white,
    surface = Color.White.copy(alpha = 0.15f),
    onSurface = Color.White.copy(alpha = .8f)
)

@Composable
fun EbaykCodingChallengeTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable() () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = shapes,
        content = content
    )
}