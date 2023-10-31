package com.example.mygraphql.ui.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import com.example.mygraphql.R
import com.example.mygraphql.domain.GitHubItem
import com.example.mygraphql.ui.theme.MyGraphQLTheme

@Composable
internal fun DetailsRow(item: GitHubItem) {
    Column {
        Text(
            text = "Repo: ${item.name}",
            modifier = Modifier.fillMaxWidth(),
        )
        Row(modifier = Modifier.fillMaxWidth()) {
            Icon(
                painter = painterResource(id = R.drawable.baseline_star_rate_24),
                contentDescription = null,
            )
            Text(
                text = "Starred by: ${item.stargazerCount} developers",
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
internal fun DetailsRowPreview(
    @PreviewParameter(ItemProvider::class) item: GitHubItem,
) {
    MyGraphQLTheme {
        DetailsRow(
            item = item,
        )
    }
}
