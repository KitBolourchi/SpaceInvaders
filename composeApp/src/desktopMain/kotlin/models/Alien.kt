package models

import androidx.compose.animation.core.Animatable
import androidx.compose.ui.graphics.Color

data class Alien(
    override val x: Animatable<Float, *> = Animatable(0f),
    override val y: Float = 0f,
    override val radius: Float = 0f,
    override val movementSpeed: Float = 0f,
    override val colour: Color = Color.White,
    val lives: Int = 1
): Target

