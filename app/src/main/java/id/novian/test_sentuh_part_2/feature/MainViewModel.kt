package id.novian.test_sentuh_part_2.feature

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import id.novian.test_sentuh_part_2.common.DataState
import id.novian.test_sentuh_part_2.common.ErrorState
import id.novian.test_sentuh_part_2.domain.JokesRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repo: JokesRepository
): ViewModel() {

    private val _data: MutableStateFlow<DataState> = MutableStateFlow(DataState.Initial)
    val data = _data.asStateFlow()

    fun fetchData(query: String) {
        viewModelScope.launch {
            _data.value = DataState.Loading
            val result = repo.getJokesByQuery(query)
            if (result.first != null) {
                when(result.first) {
                    is ErrorState.Empty -> {
                        _data.value = DataState.Empty
                    }
                    is ErrorState.Exception -> {
                        _data.value = DataState.Error(message = (result.first as ErrorState.Exception).message!!)
                    }
                    is ErrorState.Failed -> {
                        _data.value = DataState.Error(message = "Failed to request!")
                    }
                    else -> {}
                }
            } else {
                _data.value = DataState.Success(result.second)
            }
        }
    }

}