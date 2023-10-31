package com.example.mygraphql.ui.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import com.example.mygraphql.ui.theme.MyGraphQLTheme

@Composable
internal fun Header(numberOfRepositories: Int) {
    Surface {
        Column(
            modifier = Modifier
                .fillMaxWidth(),
        ) {
            Text(
                text = "GitHub Repositories for query topic:android",
                modifier = Modifier.fillMaxWidth(),
            )

            Text(
                text = "# of Repositories: $numberOfRepositories",
                modifier = Modifier.fillMaxWidth(),
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
internal fun HeaderPreview(
    numberOfRepositories: Int = 45,
) {
    MyGraphQLTheme {
        Header(
            numberOfRepositories = numberOfRepositories,
        )
    }
}
