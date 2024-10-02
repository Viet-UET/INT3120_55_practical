package com.example.createa30daysapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

import com.example.createa30daysapp.data.tips
import com.example.createa30daysapp.model.Tip
import com.example.createa30daysapp.ui.theme.CreateA30DaysAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CreateA30DaysAppTheme {
                Scaffold(
                    topBar = {
                        CreateA30DaysAppTopAppBar()
                    },
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    Tips(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateA30DaysAppTopAppBar(modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(title = {
        Text(text = stringResource(id = R.string.app_name))
    }
    )
}

@Composable
fun Tips(modifier: Modifier = Modifier) {
    LazyColumn (modifier){
       itemsIndexed(tips) {
           index, tip -> Tip(index + 1, tip, Modifier.padding(1.dp))

       }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Tips()
}