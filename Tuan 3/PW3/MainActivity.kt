package com.example.superheroes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.superheroes.data.Datasource
import com.example.superheroes.ui.theme.SuperheroesTheme
import com.example.superheroes.ui.theme.Typography

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SuperheroesTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SuperHeroesApp()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SuperHeroesApp() {
    val superHeroData = Datasource().loadSuperheroes();

    Scaffold(topBar = { SuperHeroesTopAppBar() }) { it ->
        LazyColumn(
            contentPadding = it,
            verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small)),
            modifier = Modifier.padding(
                start = dimensionResource(R.dimen.padding_medium),
                end = dimensionResource(R.dimen.padding_medium)
            )
        ) {
            items(superHeroData) {
                SuperheroItem(
                    superhero = it
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SuperHeroesTopAppBar(modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(title = {
        Text(
            text = stringResource(id = R.string.app_name), style = Typography.displayLarge
        )
    }, modifier = modifier)
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SuperheroesTheme {
        SuperHeroesApp()
    }
}