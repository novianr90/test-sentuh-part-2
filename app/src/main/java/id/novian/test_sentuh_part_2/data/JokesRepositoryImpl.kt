package id.novian.test_sentuh_part_2.data

import id.novian.test_sentuh_part_2.data.mapper.toDomain
import id.novian.test_sentuh_part_2.data.source.ApiService
import id.novian.test_sentuh_part_2.domain.Jokes
import id.novian.test_sentuh_part_2.domain.JokesRepository

class JokesRepositoryImpl(
    private val remote: ApiService
): JokesRepository {
    override suspend fun getJokesByQuery(query: String): List<Jokes> {
        return remote.getListOfJokesByQuery(query)
            .map { it.toDomain() }
    }
}