package com.example.superheroes

import android.graphics.fonts.FontStyle
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.superheroes.model.Hero
import com.example.superheroes.model.HeroesRepository
import com.example.superheroes.ui.theme.Cabin
import com.example.superheroes.ui.theme.Shapes
import com.example.superheroes.ui.theme.SuperheroesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SuperheroesTheme {
                SuperHeroesApp()
            }
        }
    }
}

@Composable
fun SuperHeroesApp() {
    Column(
        Modifier
            .fillMaxSize()
            .padding(top = 31.dp)
            .background(color = colorScheme.background)
    ) {
        Text(
            text = stringResource(id = R.string.app_name),
            color = colorScheme.primary,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.displayLarge,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        )
        LazyColumn(
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
        ) {
            items(HeroesRepository.heroes) {
                SuperHeroCard(
                    title = it.nameRes,
                    description = it.descriptionRes,
                    image = it.imageRes
                )
            }
        }
    }
}

@Composable
fun SuperHeroCard(
    title: Int,
    description: Int,
    image: Int
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp),
        shape = Shapes.medium
    ) {
        Row(
            Modifier
                .padding(all = 16.dp)
        ) {
            Column(
                Modifier
                    .width(300.dp)
                    .padding(end = 16.dp)
            ) {
                Text(
                    text = stringResource(id = title),
                    style = MaterialTheme.typography.displaySmall
                )
                Text(
                    text = stringResource(id = description),
                    style = MaterialTheme.typography.bodyMedium
                )
            }
            Column(
                Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.End
            ) {
                Image(
                    painter = painterResource(id = image),
                    contentDescription = stringResource(id = description),
                    modifier = Modifier
                        .clip(Shapes.small)
                        .width(72.dp)
                        .height(72.dp)
                )
            }
        }
    }
}