import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

import spaceinvaders.composeapp.generated.resources.Res
import spaceinvaders.composeapp.generated.resources.Space_Invaders_Logo
import spaceinvaders.composeapp.generated.resources.compose_multiplatform

@OptIn(ExperimentalResourceApi::class)
@Composable
@Preview
fun App() {
    MaterialTheme {
        Box(Modifier.fillMaxSize().background(Color.Black))
        var showContent by remember { mutableStateOf(false) }
        Column(Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
            Button(onClick = { showContent = !showContent }) {
                Text("PLAY")
            }
            AnimatedVisibility(showContent) {
                val greeting = remember { Greeting().greet() }
                Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(
                        painterResource(Res.drawable.Space_Invaders_Logo),
                        null,
                    )
                    Text(greeting)
                }
            }
        }
    }
}
