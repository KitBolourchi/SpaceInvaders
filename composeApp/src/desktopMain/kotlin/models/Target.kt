package models

import androidx.compose.animation.core.Animatable
import androidx.compose.ui.graphics.Color


interface Target {
    val x: Animatable<Float, *>
    val y: Float
    val radius: Float
    val movementSpeed: Float
    val colour: Color
}

