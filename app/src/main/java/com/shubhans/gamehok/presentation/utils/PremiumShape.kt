package com.shubhans.gamehok.presentation.utils

import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection

class TrapezoidShape : Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        val path = Path().apply {
            moveTo(0f, size.height)
            lineTo(size.width - size.height / 2, size.height)
            lineTo(size.width, 0f)
            lineTo(size.height / 2, 0f)
            close()
        }
        return Outline.Generic(path)
    }
}

