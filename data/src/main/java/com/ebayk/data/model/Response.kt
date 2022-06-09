import com.google.gson.annotations.SerializedName

data class EbayResponse(
    val address: Address,
    val attributes: List<Attribute>,
    val description: String,
    val documents: List<Document>,
    val features: List<String>,
    val id: String,
    val pictures: List<String>,
    @SerializedName("posted-date-time")
    val postedDateTime: String,
    val price: Price,
    val title: String,
    val visits: Int
)

data class Address(
    val city: String,
    val latitude: String,
    val longitude: String,
    val street: String,
    @SerializedName("zip-code")
    val zipCode: String
)

data class Attribute(
    val label: String,
    val unit: String? = null,
    val value: String
)

data class Document(
    val link: String,
    val title: String
)

data class Price(
    val amount: Int,
    val currency: String
)