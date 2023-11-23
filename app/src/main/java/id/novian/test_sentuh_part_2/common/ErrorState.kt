package id.novian.test_sentuh_part_2.common

import java.lang.Error

sealed interface ErrorState {
    object Empty: ErrorState

    data class Exception(val message: String?): ErrorState

    object Failed: ErrorState
}