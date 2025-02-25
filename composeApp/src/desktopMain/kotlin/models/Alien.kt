package models

import androidx.compose.animation.core.Animatable
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.drawscope.DrawScope
data class Alien(
    var x: Float,
    var y: Float,
    val radius: Float = 0f,
    val movementSpeed: Float = 0f,
    val colour: Color = Color.White,
    val lives: Int = 1
)



fun DrawScope.drawAliens(alienImage: ImageBitmap, alien: Alien) {
    val canvasWidth = size.width
    val canvasHeight = size.height
    val centerX = canvasWidth / 2
    val centerY = canvasHeight / 2
    alien.y = canvasHeight - 80f

    val bitmapX = alien.x - alienImage.width.toFloat() / 2
    val bitmapY = alien.y - alienImage.height.toFloat() / 2
    drawImage(alienImage, Offset(bitmapX, bitmapY))
}
