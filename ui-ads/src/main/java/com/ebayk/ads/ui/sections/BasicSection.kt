package com.ebayk.ads.ui.sections

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ebayk.ads.R
import com.ebayk.data.model.BasicInfoSection
import com.ebayk.theme.bodyMediumGray14
import com.ebayk.theme.bodyMediumGreen20
import com.ebayk.theme.titleLarge

@Composable
fun BasicSection(basicInfo: BasicInfoSection, onAddressClick: (geoUrl: String) -> Unit) {
    Card(elevation = 1.dp, backgroundColor = Color.White) {}
    Column(Modifier.padding(8.dp)) {
        //title
        Text(
            text = basicInfo.title,
            style = titleLarge
        )
        //price
        Text(
            text = basicInfo.price,
            style = bodyMediumGreen20, modifier = Modifier.padding(bottom = 8.dp)
        )
        //description
        Text(
            text = basicInfo.address,
            style = bodyMediumGray14,
            modifier = Modifier
                .padding(bottom = 16.dp, top = 8.dp)
                .clickable {
                    val geoUri: String =
                        "http://maps.google.com/maps?q=loc:" + basicInfo.lat.toString() + "," + basicInfo.long.toString() + " (" + basicInfo.title.toString() + ")"
                    onAddressClick(geoUri)
                }
        )
        //footer
        Row(horizontalArrangement = Arrangement.End, modifier = Modifier.fillMaxWidth()) {
            SimpleRow(R.drawable.ic_calendar, basicInfo.date.take(10))
            SimpleRow(
                R.drawable.ic_visits,
                basicInfo.numberOfSeen,
                Modifier
                    .weight(1f)
                    .align(Alignment.CenterVertically)
            )

            Text(
                text = "id:" + basicInfo.id,
                style = bodyMediumGray14, modifier = Modifier.align(Alignment.CenterVertically)
            )
        }

    }
}

@Preview(showBackground = true, widthDp = 320)
@Composable
fun BasicInfoPreview() {
    BasicSection(
        BasicInfoSection(
            "test",
            "sadasd",
            "asdasd",
            "12323213",
            "10",
            "12314213213",
            "",
            ""
        )
    ) {}
}

