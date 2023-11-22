package id.novian.test_sentuh_part_2.data.dto


import com.google.gson.annotations.SerializedName

data class Joke(
    @SerializedName("icon_url")
    val iconUrl: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("url")
    val url: String,
    @SerializedName("value")
    val value: String
)