package com.example.mygraphql.domain

import com.apollographql.apollo3.api.ApolloResponse
import com.example.mygraphql.GitHubQuery
import com.example.mygraphql.networking.GitHubApolloClient
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test

internal class GitHubRepositoryTest {

    private val response: ApolloResponse<GitHubQuery.Data> = mock()

    private val client: GitHubApolloClient = mock {
        onBlocking { getResponse() } doReturn response
    }

    private val repository: GitHubRepository = GitHubRepository(client = client)

    @Test
    fun `SHOULD return response`() = runTest {
        assertEquals(
            response,
            repository.data(),
        )
    }
}
