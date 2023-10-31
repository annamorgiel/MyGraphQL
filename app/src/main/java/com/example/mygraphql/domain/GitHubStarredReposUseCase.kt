package com.example.mygraphql.domain

import com.example.mygraphql.GitHubQuery
import javax.inject.Inject

internal class GitHubStarredReposUseCase @Inject constructor(
    private val gitHubRepository: GitHubRepository,
) {
    suspend fun getStarredRepos(): List<GitHubItem>? {
        val response = gitHubRepository.data()
        return when {
            response.errors == null && response.data != null -> {
                val responseData: GitHubQuery.Data = response.data as GitHubQuery.Data
                val nodes: List<GitHubQuery.Node> =
                    responseData.search.nodes?.mapNotNull { it } ?: emptyList()
                val repositories: List<GitHubQuery.OnRepository> =
                    nodes.mapNotNull { it.onRepository }
                repositories.map { repository ->
                    GitHubItem(
                        name = repository.name,
                        stargazerCount = repository.stargazerCount,
                    )
                }
            }

            else -> {
                println("IllegalStateException: ${response.errors}")
                null
            }
        }
    }
}
