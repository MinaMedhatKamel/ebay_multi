package com.ebayk.ads.ui.sections

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.ebayk.ads.R
import com.ebayk.data.model.FeaturesSection
import com.ebayk.theme.bodyMediumBlack14

@Composable
fun FeatureRow(text: String, modifier: Modifier = Modifier.padding(8.dp)) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        Image(
            painter = painterResource(R.drawable.ic_check),
            contentDescription = null
        )
        Text(
            text = text,
            style = bodyMediumBlack14,
            textAlign = TextAlign.Start,
            modifier = Modifier.padding(start = 4.dp)
        )
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun FeaturesListView(features: FeaturesSection) {
    LazyVerticalGrid(
        cells = GridCells.Fixed(2)
    ) {
        items(features.featuresList) { it ->
            FeatureRow(text = it)
        }
    }
}