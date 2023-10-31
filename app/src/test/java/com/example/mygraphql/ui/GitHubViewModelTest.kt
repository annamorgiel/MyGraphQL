package com.example.mygraphql.ui

import app.cash.turbine.test
import com.example.mygraphql.domain.GitHubItem
import com.example.mygraphql.domain.GitHubStarredReposUseCase
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
internal class GitHubViewModelTest {
    private val dispatcher = StandardTestDispatcher()

    private val useCase: GitHubStarredReposUseCase = mock {
        onBlocking { getStarredRepos() } doReturn loadedItems
    }

    private lateinit var viewModel: GitHubViewModel

    @Before
    fun setup() {
        Dispatchers.setMain(dispatcher)
        viewModel = GitHubViewModel(useCase = useCase)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `SHOULD have initial state loading`() = runTest {
        viewModel.uiState.test {
            assertEquals(
                UiState(
                    items = emptyList(),
                    loading = true,
                    error = null,
                ),
                awaitItem(),
            )
        }
    }

    @Test
    fun `SHOULD have state loaded ON items loaded`() = runTest {
        viewModel.uiState.test {
            skipItems(1)
            advanceUntilIdle()
            val loadedItem = awaitItem()
            assertEquals(
                UiState(
                    items = loadedItems,
                    loading = false,
                    error = null,
                ),
                loadedItem,
            )
        }
    }

    companion object {
        private val loadedItems: List<GitHubItem> = listOf(
            GitHubItem(
                name = "MaterialDesign3",
                stargazerCount = 333333,
            ),
            GitHubItem(
                name = "Flutter",
                stargazerCount = 222222,
            ),
        )
    }
}
