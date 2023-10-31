package com.example.mygraphql

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import com.example.mygraphql.domain.GitHubItem
import com.example.mygraphql.ui.composable.DetailsRow
import com.example.mygraphql.ui.theme.MyGraphQLTheme
import org.junit.Rule
import org.junit.Test

class DetailsRowTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun shouldDisplayGitHubRowTitle() {
        composeTestRule.setContent {
            MyGraphQLTheme {
                DetailsRow(
                    item = GitHubItem(
                        name = "Android repository",
                        stargazerCount = 50000,
                    ),
                )
            }
        }

        composeTestRule.onNodeWithText("Repo: Android repository").assertIsDisplayed()
    }

    @Test
    fun shouldDisplayGitHubRowStars() {
        composeTestRule.setContent {
            MyGraphQLTheme {
                DetailsRow(
                    item = GitHubItem(
                        name = "Android repository",
                        stargazerCount = 50000,
                    ),
                )
            }
        }

        composeTestRule.onNodeWithText("Starred by: 50000 developers").assertIsDisplayed()
    }
}
