package com.example.mygraphql.domain

import com.apollographql.apollo3.api.ApolloResponse
import com.example.mygraphql.GitHubQuery
import com.example.mygraphql.networking.GitHubApolloClient
import javax.inject.Inject

internal class GitHubRepository @Inject constructor(
    val client: GitHubApolloClient,
) {
    suspend fun data(): ApolloResponse<GitHubQuery.Data> = client.getResponse()
}
