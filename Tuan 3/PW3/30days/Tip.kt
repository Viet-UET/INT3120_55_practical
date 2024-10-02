package com.example.createa30daysapp.model

import android.hardware.DataSpace
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.createa30daysapp.data.Tip
import com.example.createa30daysapp.data.tips

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Tip(dayIndex: Int, tip: Tip, modifier: Modifier = Modifier) {
    var expanded by remember {
        mutableStateOf(false)
    }
    Card(
        modifier = modifier
            .fillMaxWidth()
            .animateContentSize(

                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioHighBouncy,
                    stiffness = Spring.StiffnessLow
                )

            ),
        onClick = { expanded = !expanded }) {
        Column(modifier = Modifier.padding(8.dp)) {

            Text(text = "Day $dayIndex")
            Text(text = stringResource(id = tip.name))
            Image(modifier = Modifier.fillMaxWidth(),
                painter = painterResource(id = tip.image),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
            if (expanded)
                Text(text = stringResource(id = tip.description))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TipPreview() {
    Tip(1, tips[0])
}