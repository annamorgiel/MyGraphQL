package com.example.mygraphql.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mygraphql.domain.GitHubItem
import com.example.mygraphql.domain.GitHubStarredReposUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class GitHubViewModel @Inject constructor(
    useCase: GitHubStarredReposUseCase,
) : ViewModel() {

    private val _uiState =
        MutableStateFlow(UiState(items = emptyList(), loading = true, error = null))
    val uiState: StateFlow<UiState> = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            delay(2)
            val items: List<GitHubItem>? = useCase.getStarredRepos()
            _uiState.value = if (items == null) {
                uiState.value.copy(loading = false, error = "Error")
            } else {
                uiState.value.copy(items = items, loading = false, error = null)
            }
        }
    }
}
