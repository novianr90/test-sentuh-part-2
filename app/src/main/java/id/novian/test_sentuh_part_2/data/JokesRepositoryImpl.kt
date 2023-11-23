package id.novian.test_sentuh_part_2.data

import android.util.Log
import id.novian.test_sentuh_part_2.common.ErrorState
import id.novian.test_sentuh_part_2.data.mapper.toDomain
import id.novian.test_sentuh_part_2.data.source.ApiService
import id.novian.test_sentuh_part_2.domain.Jokes
import id.novian.test_sentuh_part_2.domain.JokesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException

class JokesRepositoryImpl(
    private val remote: ApiService
): JokesRepository {
    override suspend fun getJokesByQuery(query: String): Pair<ErrorState?, List<Jokes>> {
        try {
            val response = remote.getListOfJokesByQuery(query)
            if (response.isSuccessful) {
                return if (response.body() != null) {
                    val mapResponse = response.body()!!.result
                        .map { it.toDomain() }
                    Pair(null, mapResponse)
                } else {
                    Pair(ErrorState.Empty, emptyList())
                }
            }
        } catch (e: HttpException) {
            return Pair(ErrorState.Exception(e.message), emptyList())
        }
        return Pair(ErrorState.Failed, emptyList())
    }
}