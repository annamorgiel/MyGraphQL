package com.example.mygraphql.ui

import com.example.mygraphql.domain.GitHubItem

internal data class UiState(
    val items: List<GitHubItem>,
    val loading: Boolean,
    val error: String?,
)
