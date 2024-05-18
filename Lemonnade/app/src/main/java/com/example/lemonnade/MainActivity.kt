package com.example.lemonnade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonnade.ui.theme.LemonnadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LemonnadeTheme {
                LemonApp()
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LemonApp(modifier: Modifier = Modifier) {

    var state by remember {
        mutableStateOf("tree")
    }

    val stringResource = when(state) {
        "tree" -> R.string.tree
        "lemon" -> R.string.squeeze
        "lemonade" -> R.string.lemonade
        else -> R.string.start_again
    }

    val imageResource = when(state) {
        "tree" -> R.drawable.lemon_tree
        "lemon" -> R.drawable.lemon_squeeze
        "lemonade" -> R.drawable.lemon_drink
        else -> R.drawable.lemon_restart
    }

    val contentDescriptorResorce = when(state) {
        "tree" -> R.string.lemon_tree
        "lemon" -> R.string.lemon
        "lemonade" -> R.string.glass_lemonade
        else -> R.string.glass_empty
    }

    var squeezes = 0

    CenterAlignedTopAppBar(
        title = {
            Text(text = "Lemonade")
        }
    )
    
    Column (
        Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(
            onClick = {
                      if (state == "tree") {
                          state = "lemon"
                      } else if (state == "lemon") {
                          if (squeezes == 0) {
                              squeezes = (1..5).random()
                          } else if (squeezes > 1) {
                              squeezes--
                          } else {
                              state = "lemonade"
                              squeezes = 0
                          }
                      } else if (state == "lemonade") {
                          state = "empty"
                      } else {
                          state = "tree"
                      }
            },
            shape = RoundedCornerShape(dimensionResource(androidx.core.R.dimen.notification_action_text_size)),
        ) {
            Image(
                painter = painterResource(imageResource),
                contentDescription = stringResource(contentDescriptorResorce)
            )
        }
        Text(
            text = stringResource(stringResource),
            fontSize = 18.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(all = 16.dp)
        )
    }
}