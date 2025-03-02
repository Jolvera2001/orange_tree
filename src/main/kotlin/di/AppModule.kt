package dev.jolvera.di

import dev.jolvera.services.GithubClient
import org.koin.dsl.module

val appModule = module {
    single {
        DatabaseManager(
            jdbcUrl = System.getenv("JDBC_DATABASE_URL"),
            driver = "org.postgresql.Driver",
            user = "postgres",
            password = "postgres"
        ).connect()
    }
    single { GithubClient() }
}