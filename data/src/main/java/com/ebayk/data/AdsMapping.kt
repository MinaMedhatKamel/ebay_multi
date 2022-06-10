import com.ebayk.data.model.*


fun EbayResponse.toAdsModel(): AdsModel {
    return AdsModel(
        images = this.pictures.map {
            it.replace("{imageId}", "57")
        },
        basicInfoSection = BasicInfoSection(
            this.title,
            this.price.run {
                this.amount.toString() + " " + this.currency
            },
            this.address.toFormattedAddress(),
            this.address.longitude,
            this.address.latitude,
            this.postedDateTime,
            this.visits.toString(),
            this.id
        ),
        detailsSection = DetailsSection(this.attributes.map {
            it.toDetailsItem()
        }),
        featureSection = FeaturesSection(this.features),
        documentSection = DocumentsSection(this.documents), description = this.description
    )
}

fun Address.toFormattedAddress(): String {
    return this.street + ", " + this.zipCode + " " + this.city
}

fun Attribute.toDetailsItem(): DetailsItem =
    DetailsItem(
        this.label,
        this.value + if (this.unit == null) "" else unit
    )


