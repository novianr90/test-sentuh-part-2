package id.novian.test_sentuh_part_2.data.mapper

import id.novian.test_sentuh_part_2.data.dto.Joke
import id.novian.test_sentuh_part_2.domain.Jokes

fun Joke.toDomain(): Jokes {
    return Jokes(
        url = this.url,
        value = this.value
    )
}