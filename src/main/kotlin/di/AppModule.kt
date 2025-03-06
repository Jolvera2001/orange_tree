package dev.jolvera.di

import dev.jolvera.services.BlogService
import dev.jolvera.services.GithubClient
import org.koin.dsl.module

val appModule = module {
    single {
        DatabaseManager(
            jdbcUrl = System.getenv("jdbc:mariadb://localhost:3306/test"),
            driver = "org.mariadb.jdbc.Driver",
            user = "root",
            password = "pwd"
        ).connect()
    }
    single { GithubClient() }
    factory { BlogService(get()) }
}