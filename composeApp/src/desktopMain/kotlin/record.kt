//import androidx.compose.animation.AnimatedVisibility
//import androidx.compose.foundation.*
//import androidx.compose.foundation.layout.*
//import androidx.compose.material.Button
//import androidx.compose.material.MaterialTheme
//import androidx.compose.material.Text
//import androidx.compose.runtime.*
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.focus.FocusRequester
//import androidx.compose.ui.focus.focusRequester
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.input.key.*
//import androidx.compose.ui.unit.dp
//import models.ShipMovement
//import org.jetbrains.compose.resources.ExperimentalResourceApi
//import org.jetbrains.compose.resources.painterResource
//import org.jetbrains.compose.ui.tooling.preview.Preview
//
//import spaceinvaders.composeapp.generated.resources.Res
//import spaceinvaders.composeapp.generated.resources.Space_Invaders_Logo
//import spaceinvaders.composeapp.generated.resources.playership
//
//@OptIn(ExperimentalResourceApi::class)
//@Composable
//@Preview
//fun App() {
//    var shipMovement by remember { mutableStateOf(ShipMovement.None) }
//
//    val assets = listOf(
//        painterResource(Res.drawable.playership)
//    )
//
//    MaterialTheme {
//        Box(Modifier.fillMaxSize().background(Color.Black))
//        var mainMenuPage by remember { mutableStateOf(true) }
//        if (mainMenuPage) {
//            AnimatedVisibility(mainMenuPage) {
//                Column(Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
//                    Image(
//                        painterResource(Res.drawable.Space_Invaders_Logo),
//                        null,
//                    )
//
//                    Column(Modifier.fillMaxWidth(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
//                        Button(onClick = { mainMenuPage = false }) {
//                            Text("PLAY")
//                        }
//                    }
//                }
//            }
//        } else {
//            val focusRequester = remember { FocusRequester() }
//
//            Row(Modifier.fillMaxSize(), horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.Bottom) {
//                Image(
//                    painterResource(Res.drawable.playership),
//                    null,
//                    Modifier.focusRequester(focusRequester).onKeyEvent { event: KeyEvent ->
//                        if (event.type == KeyEventType.KeyDown) {
//                            when(event.key) {
//                                Key.DirectionLeft -> {
//                                    shipMovement = ShipMovement.Left
//                                    doSomethingLeft()
//                                    true
//                                }
//                                Key.DirectionRight -> {
//                                    shipMovement = ShipMovement.Right
//                                    doSomethingRight()
//                                    true
//                                }
//                                else -> {
//                                    true
//                                }
//                            }
//                        } else {
//                            shipMovement = ShipMovement.None
//                            println("None")
//                            true
//                        }
//                    }.focusable(true)
//                )
//            }
//            LaunchedEffect(Unit) {
//                focusRequester.requestFocus()
//            }
//        }
//    }
//}
//
//fun doSomethingLeft() {
//    println("left key pressed")
//}
//
//fun doSomethingRight() {
//    println("right key pressed")
//}
