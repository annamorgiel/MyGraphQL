package com.example.mygraphql.domain

import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import kotlinx.coroutines.test.runTest
import org.junit.Test

internal class GitHubStarredReposUseCaseTest {

    private val repository: GitHubRepository = mock {
        onBlocking { data() } doReturn mock()
    }

    private val useCase: GitHubStarredReposUseCase =
        GitHubStarredReposUseCase(gitHubRepository = repository)

    @Test
    fun `SHOULD return list of items`() = runTest {
        useCase.getStarredRepos()
        verify(repository).data()
    }
}
