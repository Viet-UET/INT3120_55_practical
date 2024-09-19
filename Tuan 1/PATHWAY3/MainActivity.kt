package com.example.card

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.card.ui.theme.CardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CardTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    BusinessCard()
                }
            }
        }
    }
}

@Composable
fun BusinessCard() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFFFFF))
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.align(Alignment.Center)
        ) {
            Image(
                painter = painterResource(id = R.drawable.avatar),
                contentDescription = "Avatar",
                modifier = Modifier
                    .size(100.dp)
                    .background(Color.Gray, shape = CircleShape),
                contentScale = ContentScale.Crop
            )

            Text(
                text = "Full name",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 16.dp)
            )

            Text(
                text = "Title",
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.padding(top = 8.dp)
            )
        }

        Column(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 32.dp )
        ) {
            ContactInfoWithIcon("+00 (00) 000000")
            ContactInfoWithIcon("@socialmediahanle")
            ContactInfoWithIcon("email@domain.com")
        }
    }
}

@Composable
fun ContactInfoWithIcon(info: String) {
    Row(
        modifier = Modifier.padding(4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.avatar),
            contentDescription = "Avatar Icon",
            modifier = Modifier
                .size(24.dp)
                .background(Color.Gray, shape = CircleShape),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.width(8.dp))

        Text(
            text = info,
            fontSize = 16.sp,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    CardTheme {
        BusinessCard()
    }
}
