package com.example.superheroes

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.superheroes.model.Superhero
import com.example.superheroes.ui.theme.Shapes
import com.example.superheroes.ui.theme.Typography

@Composable
fun SuperheroItem(
    superhero: Superhero, modifier: Modifier = Modifier
) {
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
    ) {
        Row(

            modifier = modifier
                .fillMaxWidth()
                .padding(dimensionResource(R.dimen.padding_medium)),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = stringResource(superhero.name),
                    style = Typography.displaySmall,
                )
                Text(
                    text = stringResource(superhero.description),
                    style = Typography.bodyLarge,
                )
            }
            Spacer(modifier = Modifier.width(dimensionResource(R.dimen.padding_medium)))
            Image(
                modifier = modifier
                    .clip(Shapes.small)
                    .size(dimensionResource(R.dimen.padding_X_large72))
                    .padding(
                        start = dimensionResource(R.dimen.padding_medium)
                    ),
                painter = painterResource(id = superhero.imageResourceId),
                contentDescription = null,
                contentScale = ContentScale.FillWidth
            )
        }
    }
}