package dev.jolvera.services

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

@Serializable
data class GithubUser(
    val login: String,
    val avatar_url: String,
    val name: String,
    val bio: String,
    val public_repos: Int,
    val followers: Int,
    val following: Int,
)

class GithubClient {
    private val client = HttpClient(CIO) {
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
                isLenient = true
            })
        }
    }

    private val username = "Jolvera2001"

    suspend fun getGithubUser(): GithubUser {
        return client.get("https://api.github.com/users/$username").body()
    }

    fun close() {
        client.close()
    }
}