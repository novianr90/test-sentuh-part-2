package id.novian.test_sentuh_part_2.data.source

import id.novian.test_sentuh_part_2.common.Constants
import id.novian.test_sentuh_part_2.data.dto.Joke
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET(Constants.SEARCH)
    suspend fun getListOfJokesByQuery(
        @Query("query") query: String
    ): Response<List<Joke>>
}