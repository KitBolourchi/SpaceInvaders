import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.*
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

import spaceinvaders.composeapp.generated.resources.Res
import spaceinvaders.composeapp.generated.resources.Space_Invaders_Logo
import spaceinvaders.composeapp.generated.resources.Spaceship

@OptIn(ExperimentalResourceApi::class)
@Composable
@Preview
fun App() {
    MaterialTheme {
        Box(Modifier.fillMaxSize().background(Color.Black))
        var showContent by remember { mutableStateOf(true) }
        if (showContent) {
            AnimatedVisibility(showContent) {
                Column(Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(
                        painterResource(Res.drawable.Space_Invaders_Logo),
                        null,
                    )

                    Column(Modifier.fillMaxWidth(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
                        Button(onClick = { showContent = !showContent }) {
                            Text("PLAY")
                        }
                    }
                }
            }
        } else {
            val focusRequester = remember { FocusRequester() }

            Row(Modifier.fillMaxSize(), horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.Bottom) {
                Image(
                    painterResource(Res.drawable.Spaceship),
                    null,
                    modifier = Modifier.focusRequester(focusRequester).onKeyEvent {
                        if(
                            it.type == KeyEventType.KeyUp &&
                            it.key == Key.DirectionLeft
                        ) {
                            doSomethingLeft()
                            true
                        } else {
                            false
                        }
                    }.focusable(true)
                )
            }
            LaunchedEffect(Unit) {
                focusRequester.requestFocus()
            }
        }
    }
}

fun doSomethingLeft() {
    println("left key pressed")
}

fun doSomethingRight() {
    println("right key pressed")
}
