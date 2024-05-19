package com.example.practice

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
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.practice.ui.theme.PracticeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PracticeTheme {
                CardText(
                    name = stringResource(id = R.string.full_name),
                    title = stringResource(id = R.string.title),
                    phone_number = stringResource(id = R.string.phone_number),
                    email = stringResource(id = R.string.email),
                    Modifier
                        .fillMaxSize()
                )
            }
        }
    }
}

@Composable
fun CardText(name: String, title: String, phone_number: String, email: String, modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier.fillMaxSize()
    ){
       Row(
           verticalAlignment = Alignment.CenterVertically,
           horizontalArrangement = Arrangement.Center,
           modifier = Modifier.fillMaxWidth()
       ){
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(vertical = 300.dp)
            ){
                Image(
                    painter = painterResource(id = R.drawable.grogoroth),
                    contentDescription = "God of destruction"
                )
                Text(
                    text = name,
                    fontSize = 30.sp
                )
                Text(
                    text = title,
                    fontSize = 20.sp
                )
            }
       }
        Column (
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
        ){
            Row {
                Icon(
                    Icons.Rounded.Email,
                    contentDescription = "Email"
                )
                Spacer(Modifier.width(10.dp))
                Text(text = email)
            }
            Row {
                Icon(
                    Icons.Rounded.Phone,
                    contentDescription = "Phone"
                )
                Spacer(Modifier.width(10.dp))
                Text(text = phone_number)
            }
        }
    }
}
