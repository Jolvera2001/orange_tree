package dev.jolvera

import dev.jolvera.di.configureFrameworks
import dev.jolvera.templates.configureCss
import io.ktor.server.application.*

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

fun Application.module() {
    configureCss()
    configureFrameworks()
    configureRouting()
}
