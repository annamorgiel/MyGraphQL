package com.example.mygraphql.ui.composable

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import com.example.mygraphql.domain.GitHubItem

@OptIn(ExperimentalFoundationApi::class)
@Composable
internal fun GitHubDetailsList(items: List<GitHubItem>) {
    Surface(
        modifier = Modifier
            .padding(Dp(8.0f))
            .fillMaxSize(),
        color = MaterialTheme.colorScheme.background,
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(Dp(8.0f)),
        ) {
            stickyHeader("header") {
                Header(
                    numberOfRepositories = items.size,
                )
            }
            items(
                items = items,
                key = { item -> item.name },
            ) { item ->
                DetailsRow(
                    item = item,
                )
            }
        }
    }
}
