package dev.jolvera

import dev.jolvera.services.GithubClient
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
import org.koin.java.KoinJavaComponent.inject

fun Application.configureRouting() {
    install(StatusPages) {
        exception<Throwable> { call, cause ->
            call.respondText(text = "500: $cause", status = HttpStatusCode.InternalServerError)
        }
    }
    routing {
        get("/") {
            val githubService: GithubClient by inject(GithubClient::class.java) // DO THIS, NOT "by inject()"

            try {
                val githubProfile = githubService.getGithubUser()

                call.respondHtmlTemplate(MainTemplate()) {
                    HomeView(githubProfile).insertInto(content)
                }
            } catch (e: Exception) {
                log.error(e.message, e)
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
