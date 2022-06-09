package com.ebayk.data.model

import Document

data class AdsModel(
    val images: List<String>,
    val basicInfoSection: BasicInfoSection,
    val detailsSection: DetailsSection,
    val featureSection: FeaturesSection,
    val documentSection: DocumentsSection,
    val description: String
)


data class BasicInfoSection(
    val title: String,
    val price: String,
    val address: String,
    val date: String,
    val numberOfSeen: String,
    val id: String
)

data class DetailsSection(val detailsList: List<DetailsItem>)

data class FeaturesSection(val featuresList: List<String>)

data class DocumentsSection(val documentList: List<Document>)

data class DetailsItem(val lable: String, val value: String)
