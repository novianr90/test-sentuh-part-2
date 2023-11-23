package id.novian.test_sentuh_part_2.common

import id.novian.test_sentuh_part_2.domain.Jokes

sealed interface DataState {
    object Loading: DataState
    data class Error(val message: String): DataState
    data class Success(val data: List<Jokes>): DataState

    object Initial: DataState
    object Empty: DataState
}