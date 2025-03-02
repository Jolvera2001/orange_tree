package dev.jolvera.di

import dev.jolvera.services.GithubClient
import dev.jolvera.services.GithubUser
import org.koin.dsl.module

val appModule = module {
    single { GithubClient() }
}