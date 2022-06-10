package com.ebayk

import Document
import com.ebayk.data.model.*


class FakeDataProvider {
    companion object {
        fun provideFakeAdsModel(): AdsModel {
            return AdsModel(
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
        }
    }
}