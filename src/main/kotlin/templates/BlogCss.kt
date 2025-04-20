package dev.jolvera.templates

import io.ktor.server.application.*
import io.ktor.server.html.respondHtml
import io.ktor.server.routing.get
import io.ktor.server.routing.routing

fun Application.configureBlogCss() {
    val backgroundMain = null
    val textColor = null

    routing {
        get("/blogStyles.css") {
            call.respondCss {
                TODO()
            }
        }
    }
}