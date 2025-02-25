package models

import Scene
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.drawscope.DrawScope

data class Ship (
    var x: Float = 0f,
    var y: Float = 0f
) : SceneEntity() {
    override fun update(scene: Scene) {

    }
}

fun DrawScope.drawSpaceShip(spaceShip: ImageBitmap, ship: Ship) {
    val canvasWidth = size.width
    val canvasHeight = size.height
    val centerX = canvasWidth / 2
    val centerY = canvasHeight / 2
    ship.y = canvasHeight - 80f

    val bitmapX = ship.x - spaceShip.width.toFloat() / 2
    val bitmapY = ship.y - spaceShip.height.toFloat() / 2

    if (ship.x < canvasWidth - 50 && ship.x > canvasWidth - canvasWidth + 50 ) {
        drawImage(spaceShip, Offset(bitmapX, bitmapY))
    } else if (ship.x >= canvasWidth - 50) {
        ship.x -= 50
        drawImage(spaceShip, Offset(bitmapX - 50, bitmapY))
    } else if (ship.x <= canvasWidth - canvasWidth + 50) {
        ship.x += 50
        drawImage(spaceShip, Offset(bitmapX + 50, bitmapY))
    }
}
