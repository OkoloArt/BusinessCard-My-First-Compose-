package com.example.greetingcard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.greetingcard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize() ,
                        color = MaterialTheme.colors.background) {
                }
            }
        }
    }
}

@Composable
fun IntroSection() {
    val image = painterResource(id = R.drawable.android_logo)
    Column(
    horizontalAlignment = Alignment.CenterHorizontally) {
        Image(painter = image , contentDescription = "Android Logo" ,
              Modifier
                  .width(120.dp)
                  .height(120.dp))
        Text(text = stringResource(R.string.name) ,
             fontWeight = FontWeight.Bold,
             textAlign = TextAlign.Center,
             fontSize = 50.sp,
             fontFamily = FontFamily.Cursive,
             modifier = Modifier.padding(bottom = 15.dp, top = 10.dp)
        )
        Text(text = stringResource(R.string.tech_title) , fontWeight = FontWeight.Bold,
        color = Color.Green)
    }
}

@Composable
fun ContactSection(imageResource: Int , contact: String){
    val image= painterResource(id = imageResource)
    Row() {
        Icon(painter = image , contentDescription = null,
              Modifier
                  .padding(end = 20.dp, bottom = 20.dp),
             colorResource(id = R.color.green)
        )
        Text(text = contact)
    }
}

@Composable
fun BusinessCard() {
    Box(Modifier.fillMaxSize()
                .padding(10.dp)) {
        Column(Modifier.align(Alignment.Center)
                    .padding(16.dp)) {
            IntroSection()
        }
        Column(Modifier.align(Alignment.BottomCenter)
                    .padding(bottom = 16.dp)) {
            ContactSection(R.drawable.ic_baseline_call , "+234814464*****")
            ContactSection(R.drawable.ic_baseline_share , "@AndroidDev")
            ContactSection(R.drawable.ic_baseline_mail , "okoloarthur4@gmail.com")
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BusinessCardTheme {
        BusinessCard()
    }
}