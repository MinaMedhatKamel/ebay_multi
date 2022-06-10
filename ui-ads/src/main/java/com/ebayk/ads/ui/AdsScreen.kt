package com.ebayk.ads.ui

import Document
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat.startActivity
import androidx.hilt.navigation.compose.hiltViewModel
import com.ebayk.ads.R
import com.ebayk.ads.ui.sections.*
import com.ebayk.data.model.*
import com.ebayk.theme.EbaykCodingChallengeTheme
import com.ebayk.theme.bodyMediumBlack14


@Composable
fun AdsScreen(vm: AdsListViewModel = hiltViewModel()) =
    EbaykCodingChallengeTheme() {
        vm.state.value.let { state ->
            when (state) {
                is Loading -> Loading()
                is AdsListReady -> DetailsScreen(state.ads)
                is Error -> ErrorView(state.string)
            }
        }
    }

@Composable
fun DetailsScreen(ads: AdsModel) {
    val context = LocalContext.current
    EbaykCodingChallengeTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            Column(Modifier.verticalScroll(rememberScrollState())) {
                ImagesSection(ads.images) {
                    val theClickedImg = ads.images[it]
                    val sendIntent = Intent()
                    sendIntent.action = Intent.ACTION_SEND
                    sendIntent.putExtra(
                        Intent.EXTRA_TEXT,
                        "Send a simple text"
                    )
                    sendIntent.type = "text/plain"
                    startActivity(context, sendIntent, null)
                }
                BasicSection(ads.basicInfoSection) {
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(it))
                    context.startActivity(intent)
                }
                SectionSeprator()
                Section(title = R.string.details_title, modifier = Modifier.height(300.dp)) {
                    DetailsListView(ads.detailsSection)
                }
                SectionSeprator()
                Section(title = R.string.furnishing_title, modifier = Modifier.height(200.dp)) {
                    FeaturesListView(ads.featureSection)
                }
                SectionSeprator()
                Section(title = R.string.information_title, modifier = Modifier.height(200.dp)) {
                    DocumentsListView(ads.documentSection) {
                        it.link.let {
                            val i = Intent(Intent.ACTION_VIEW)
                            i.data = Uri.parse(it)
                            startActivity(context, i, null)
                        }
                    }
                }
                SectionSeprator()
                Section(title = R.string.description_title) {
                    Text(
                        text = ads.description,
                        style = bodyMediumBlack14,
                        textAlign = TextAlign.Start,
                        modifier = Modifier
                            .padding(8.dp)
                            .fillMaxWidth()
                    )
                }
            }
        }
    }
}

// this is for test preview with fake data
@Preview(showBackground = true, widthDp = 320)
@Composable
fun DetailsScreenPreview() {
    DetailsScreen(
        AdsModel(
            listOf(
                "https://gateway.ebay-kleinanzeigen.de/coding-challenge/img/9NEAAOSw6xNhSgCC_57.jpeg",
                "https://gateway.ebay-kleinanzeigen.de/coding-challenge/img/21YAAOSwYEFhSgCC_57.jpeg",
                "https://gateway.ebay-kleinanzeigen.de/coding-challenge/img/21YAAOSwYEFhSgCC_40.jpeg",
            ),
            BasicInfoSection("", "", "", "", "", "", "", ""),
            DetailsSection(listOf(DetailsItem("lable", "value"))),
            FeaturesSection(listOf("test1", "test2")),
            DocumentsSection(listOf(Document("", ""))), ""
        )
    )
}