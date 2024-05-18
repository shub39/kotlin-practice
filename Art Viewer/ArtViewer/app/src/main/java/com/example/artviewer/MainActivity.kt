package com.example.artviewer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artviewer.ui.theme.ArtViewerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArtViewerTheme {
                ArtViewer()
            }
        }
    }
}

@Composable
fun ArtViewer() {

    var image by remember {
        mutableStateOf(1)
    }

    val imageResource = when (image) {
        1 -> painterResource(id = R.drawable.monalisa_1503_)
        2 -> painterResource(id = R.drawable.madame_x_1884_)
        3 -> painterResource(id = R.drawable.the_blue_boy_1770_)
        4 -> painterResource(id = R.drawable.american_gothic_1930_)
        5 -> painterResource(id = R.drawable.adele_bloch_bauer_i_1907_)
        else -> painterResource(id = R.drawable.the_arnolfini_portrait_1434_)
    }

    val imageDescription = when (image) {
        1 -> stringResource(id = R.string.name_1)
        2 -> stringResource(id = R.string.name_2)
        3 -> stringResource(id = R.string.name_3)
        4 -> stringResource(id = R.string.name_4)
        5 -> stringResource(id = R.string.name_5)
        else -> stringResource(id = R.string.name_6)
    }

    val imageArtist = when (image) {
        1 -> stringResource(id = R.string.artist_1)
        2 -> stringResource(id = R.string.artist_2)
        3 -> stringResource(id = R.string.artist_3)
        4 -> stringResource(id = R.string.artist_4)
        5 -> stringResource(id = R.string.artist_5)
        else -> stringResource(id = R.string.artist_6)
    }

    val imageYear = when (image) {
        1 -> stringResource(id = R.string.year_1)
        2 -> stringResource(id = R.string.year_2)
        3 -> stringResource(id = R.string.year_3)
        4 -> stringResource(id = R.string.year_4)
        5 -> stringResource(id = R.string.year_5)
        else -> stringResource(id = R.string.year_6)
    }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Image(painter = imageResource, contentDescription = imageDescription)
        }
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 12.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(text = imageDescription, fontSize = 30.sp)
                Text(text = "$imageArtist ($imageYear)")
            }
        }
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 12.dp)
        ) {
            Column {
                Button(onClick = {
                    if (image > 1) {
                        image--
                    } else {
                        image = 6
                    }
                }) {
                    Text(text = "Previous")
                }
            }
            Spacer(modifier = Modifier.padding(12.dp))
            Column {
                Button(onClick = {
                    if (image < 6) {
                        image++
                    } else {
                        image = 1
                    }
                }) {
                    Text(text = "Next")
                }
            }
        }
    }
}

