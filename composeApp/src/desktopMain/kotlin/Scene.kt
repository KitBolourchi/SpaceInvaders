import androidx.compose.foundation.*
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.input.key.*
import androidx.compose.ui.input.pointer.pointerMoveFilter
import models.SceneEntity
import models.Ship
import models.drawSpaceShip

class Scene {
    private var sceneEntity = mutableStateListOf<SceneEntity>()
    private val spaceShip = Ship()

    fun setupScene() {
        sceneEntity.clear()
        sceneEntity.add(spaceShip)
    }

    fun update() {
        for (entity in sceneEntity) {
            entity.update(this)
        }
    }

    @OptIn(ExperimentalFoundationApi::class)
    @Composable
    fun render(frameState: State<Long>, assets: List<ImageBitmap>) {
        val focusRequester = remember { FocusRequester() }

        Surface(color = Color.White) {
            Canvas(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = Color.Black)
                    .focusRequester(focusRequester).onKeyEvent { event: KeyEvent ->
                        if (event.type == KeyEventType.KeyDown) {
                            when(event.key) {
                                Key.DirectionLeft -> {
                                    println("Left")
                                    spaceShip.x -= 50
                                    true
                                }
                                Key.DirectionRight -> {
                                    println("Right")
                                    spaceShip.x += 50
                                    true
                                }
                                else -> {
                                    true
                                }
                            }
                        } else {
                            true
                        }
                    }.focusable(true)
            ) {
                val stepFrame = frameState.value

                drawSpaceShip(assets[0], spaceShip)
            }
            LaunchedEffect(Unit) {
                focusRequester.requestFocus()
            }
        }
    }
}
