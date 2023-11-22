package id.novian.test_sentuh_part_2.domain

interface JokesRepository {
    suspend fun getJokesByQuery(query: String): List<Jokes>
}