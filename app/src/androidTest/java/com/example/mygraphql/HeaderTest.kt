package com.example.mygraphql

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import com.example.mygraphql.ui.composable.Header
import com.example.mygraphql.ui.theme.MyGraphQLTheme
import org.junit.Rule
import org.junit.Test

class HeaderTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun shouldDisplayHeader() {
        composeTestRule.setContent {
            MyGraphQLTheme {
                Header(numberOfRepositories = 50)
            }
        }

        composeTestRule.onNodeWithText("GitHub Repositories for query topic:android")
            .assertIsDisplayed()
    }

    @Test
    fun shouldDisplayGitHubRowStars() {
        composeTestRule.setContent {
            MyGraphQLTheme {
                Header(numberOfRepositories = 50)
            }
        }

        composeTestRule.onNodeWithText("# of Repositories: 50").assertIsDisplayed()
    }
}
