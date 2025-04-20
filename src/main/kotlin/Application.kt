package dev.jolvera

import dev.jolvera.di.configureFrameworks
import io.ktor.server.application.*

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

fun Application.module() {
    configureWebJars()
    configureFrameworks()
    configureRouting()
}
