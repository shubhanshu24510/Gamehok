package com.shubhans.gamehok.presentation.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

object GamehokTheme {

    // linear Gradient
    val primaryGradient = Brush.linearGradient(
        colors = listOf(
            DarkBackground, DarkBackground.copy(alpha = 0.8f), Color(0xFF1A2C1F)
        )
    )
    val tournamentGradient = Brush.linearGradient(
        colors = listOf(
            Color(0xFF56E293), Color(0xFF062E17)
        )
    )
    val premiumGradient = Brush.linearGradient(
        colors = listOf(
            Color(0xFFF0C346), Color(0xFFFFE293)
        )
    )
    val prizeGradient = Brush.linearGradient(
        colors = listOf(
            Color(0xFF2C5842), PrizeGreen
        )
    )
    val navigationGradient = Brush.verticalGradient(
        colors = listOf(
            DarkBackground.copy(alpha = 0.9f), DarkBackground
        )
    )
    val roundAndSeduleGradient = Brush.verticalGradient(
        colors = listOf(
            Color(0xFF311A61), Color(0xFF1C192E)
        )
    )
    val topBarGradient = Brush.verticalGradient(
        colors = listOf(
            DarkBackground, DarkBackground.copy(alpha = 0.9f)
        )
    )
    val bottomBarGradient = Brush.verticalGradient(
        colors = listOf(
            Color(0xFF001208), DarkBackground
        )
    )
    val contactGradient = Brush.linearGradient(
        colors = listOf(
            Color(0xFF182920), Color(0xFF4D5A53)
        )
    )
}

//dynamic Gradient
fun createGradient(
    startColor: Color, endColor: Color, direction: GradientDirection = GradientDirection.Horizontal
): Brush {
    return when (direction) {
        GradientDirection.Horizontal -> Brush.horizontalGradient(
            colors = listOf(startColor, endColor)
        )

        GradientDirection.Vertical -> Brush.verticalGradient(
            colors = listOf(startColor, endColor)
        )

        GradientDirection.Diagonal -> Brush.linearGradient(
            colors = listOf(startColor, endColor),
            start = Offset(0f, 0f),
            end = Offset(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY)
        )
    }
}

enum class GradientDirection {
    Horizontal, Vertical, Diagonal
}

private val DarkColorScheme = darkColorScheme(
    primary = Green,
    secondary = Green,
    tertiary = Green,
    background = DarkBackground,
    surface = DarkBackground,
    onPrimary = TextWhite,
    onSecondary = TextWhite,
    onTertiary = TextWhite,
    onBackground = TextWhite,
    onSurface = TextWhite
)

private val LightColorScheme = darkColorScheme(
    primary = Green,
    secondary = Green,
    tertiary = Green,
    background = DarkBackground,
    surface = DarkBackground,
    onPrimary = TextWhite,
    onSecondary = TextWhite,
    onTertiary = TextWhite,
    onBackground = TextWhite,
    onSurface = TextWhite
)

@Composable
fun GamehokTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true, content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}