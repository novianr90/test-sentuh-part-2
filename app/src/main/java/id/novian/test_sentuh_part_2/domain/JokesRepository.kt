package id.novian.test_sentuh_part_2.domain

import id.novian.test_sentuh_part_2.common.ErrorState
import kotlinx.coroutines.flow.Flow

interface JokesRepository {
    suspend fun getJokesByQuery(query: String): Pair<ErrorState?, List<Jokes>>
}