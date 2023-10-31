package com.example.mygraphql.ui.composable

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.example.mygraphql.domain.GitHubItem

internal class ItemProvider : PreviewParameterProvider<GitHubItem> {
    override val values: Sequence<GitHubItem> = sequenceOf(
        GitHubItem(name = "Flutter", stargazerCount = 10000),
        GitHubItem(name = "Material3", stargazerCount = 20000),
        GitHubItem(name = "Hilt", stargazerCount = 400000),
    )
}
