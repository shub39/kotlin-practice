package com.example.coins30

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.coins30.ui.theme.Coins30Theme
import com.example.coins30.ui.theme.Shapes

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Coins30Theme {
                DataSource.initialize(this)
                Coins30App(DataSource.coins)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Coins30App(
    coins: List<Coin>
) {
    Scaffold(
        topBar = {
            TopAppBar(title = {
                Text(
                    text = stringResource(id = R.string.app_name),
                    style = MaterialTheme.typography.displayLarge
                )
            })
        }
    ) { it ->
        12.dp
        LazyColumn(
            Modifier.padding(it),
            contentPadding = PaddingValues(16.dp)
        ) {
            items(coins) {
                CoinCard(
                    imageRes = it.imageRes,
                    nameRes = it.nameRes,
                    price = it.price
                )
            }
        }
    }
}

@Composable
fun CoinCard(
    imageRes: Int,
    nameRes: Int,
    price: String
) {
    Card(
        Modifier
            .padding(top = 16.dp)
            .fillMaxWidth()
            .clip(Shapes.large)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(all = 32.dp)
                .fillMaxWidth()
        ) {
            Box {
                Image(
                    painter = painterResource(id = imageRes),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .height(350.dp)
                        .width(350.dp)
                        .clip(Shapes.large)
                )
                Button(
                    shape = Shapes.large,
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .padding(16.dp)
                ) {
                   Text(text = "$price Rupees")
                }
            }
            Spacer(modifier = Modifier.padding(16.dp))
            Text(
                text = stringResource(id = nameRes),
                style = MaterialTheme.typography.displayMedium,
                textAlign = TextAlign.Center
            )
        }
    }
}