package com.example.mygraphql.ui.composable

import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import com.example.mygraphql.ui.GitHubViewModel

@Composable
internal fun GitHubScreen(viewModel: GitHubViewModel) {
    val state = viewModel.uiState.collectAsState().value
    when {
        state.loading -> {
            Loading()
        }

        state.error != null -> {
            Empty(errorMessage = state.error)
        }

        state.items.isEmpty() -> {
            Empty()
        }

        else -> {
            GitHubDetailsList(items = state.items)
        }
    }
}
