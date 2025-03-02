package dev.jolvera

import dev.jolvera.templates.MainTemplate
import dev.jolvera.views.AboutView
import dev.jolvera.views.BlogView
import dev.jolvera.views.HomeView
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.html.*
import io.ktor.server.plugins.statuspages.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    install(StatusPages) {
        exception<Throwable> { call, cause ->
            call.respondText(text = "500: $cause", status = HttpStatusCode.InternalServerError)
        }
    }
    routing {
        get("/") {
            call.respondHtmlTemplate(MainTemplate()) {
                HomeView().insertInto(content)
            }
        }

        get("/blogs") {
            call.respondHtmlTemplate(MainTemplate()) {
                BlogView().insertInto(content)
            }
        }

        get("/about") {
            call.respondHtmlTemplate(MainTemplate()) {
                AboutView().insertInto(content)
            }
        }
    }
}
