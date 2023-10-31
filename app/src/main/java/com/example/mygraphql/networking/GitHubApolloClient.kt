package com.example.mygraphql.networking

import com.apollographql.apollo3.ApolloClient
import com.apollographql.apollo3.api.ApolloResponse
import com.example.mygraphql.GitHubQuery
import javax.inject.Inject

internal class GitHubApolloClient @Inject constructor() {
    private val apolloClient = ApolloClient.Builder()
        .addHttpHeader(
            name = HEADER_AUTHORIZATION,
            value = "$BEARER_TOKEN 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",
        )
        .serverUrl(serverUrl = URL)
        .build()

    suspend fun getResponse(): ApolloResponse<GitHubQuery.Data> =
        apolloClient.query(GitHubQuery()).execute()

    companion object {
        const val HEADER_AUTHORIZATION = "Authorization"
        const val BEARER_TOKEN = "Bearer"
        const val URL = "https://api.github.com/graphql"
    }
}
