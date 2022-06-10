package com.ebayk.ads.ui.sections

import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ebayk.ads.R
import com.ebayk.theme.*


@Composable
fun SimpleRow(imagId: Int, text: String, modifier: Modifier = Modifier.padding(8.dp)) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        Image(
            painter = painterResource(imagId),
            contentDescription = null

        )
        Text(
            text = text,
            style = bodyMediumGray14,
            textAlign = TextAlign.Start,
            modifier = Modifier.padding(start = 4.dp)
        )
    }
}

@Composable
fun SimpleDetailsRow(lable: String, value: String, modifier: Modifier = Modifier.padding(8.dp)) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.End
    ) {
        Text(
            text = lable,
            style = bodyMediumBlack14,
            textAlign = TextAlign.Start,
            modifier = Modifier
                .padding(start = 4.dp)
                .weight(1f)
        )
        Text(
            text = value,
            style = bodyMediumGray14,
            textAlign = TextAlign.Start,
            modifier = Modifier.padding(start = 4.dp)
        )
    }
}

@Composable
fun SectionSeprator() {
    Divider(color = gray_light, thickness = 4.dp)
}

@Composable
fun Section(
    @StringRes title: Int,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Card(elevation = 1.dp, backgroundColor = Color.White) {
        Column(modifier) {
            Text(
                text = stringResource(title),
                style = titleLarge,
                modifier = Modifier
                    .paddingFromBaseline(top = 32.dp, bottom = 8.dp)
                    .padding(horizontal = 8.dp, vertical = 16.dp)
            )
            Divider(
                color = gray_600,
                thickness = 1.dp,
                modifier = Modifier.padding(horizontal = 8.dp)
            )
            content()
        }
    }

}

@Composable
fun Loading() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        CircularProgressIndicator()
    }
}

@Composable
fun ErrorView(error: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        Text(
            text = error,
            style = titleLargeError
        )
    }
}

@Preview()
@Composable
fun SectionPreview() {
    Section(title = R.string.furnishing_title) {
        SimpleDetailsRow("test lable", "15 m2")
        SectionSeprator()
        SimpleRow(imagId = R.drawable.ic_calendar, text = "test")
    }
}

