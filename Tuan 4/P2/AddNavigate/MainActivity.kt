
package com.example.lunchtray

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.lunchtray.ui.theme.LunchTrayTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LunchTrayTheme {
                LunchTrayApp()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LunchTrayPreview() {
    LunchTrayTheme {
        LunchTrayApp()
    }
}
