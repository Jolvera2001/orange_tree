package dev.jolvera.di

import dev.jolvera.services.BlogService
import dev.jolvera.services.GithubClient
import org.koin.dsl.module

val appModule = module {
    single { MongoData() }
    single { GithubClient() }

    factory { BlogService(get()) }
}