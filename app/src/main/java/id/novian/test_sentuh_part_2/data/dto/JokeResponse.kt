package id.novian.test_sentuh_part_2.data.dto

import com.google.gson.annotations.SerializedName

data class JokeResponse(
    @SerializedName("result")
    val result: List<Joke>
)
