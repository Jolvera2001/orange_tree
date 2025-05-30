package dev.jolvera

import dev.jolvera.models.Blog
import dev.jolvera.templates.BlogsTemplate
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
import kotlinx.datetime.Clock
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

object RouteKoinIntegration : KoinComponent

val Route.di get() = RouteKoinIntegration

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
            val testList = listOf<Blog>(
                Blog(
                    slug = "Test Slug",
                    title = "Test Title",
                    subtitle = "This is a test subtitle",
                    author = "Me",
                    content = "Something",
                    updatedAt = Clock.System.now(),
                    createdAt = Clock.System.now(),
                ),
                Blog(
                    slug = "Test Slug2",
                    title = "Test Title2",
                    subtitle = "This is a test subtitle2",
                    author = "Me2",
                    content = "Something2",
                    updatedAt = Clock.System.now(),
                    createdAt = Clock.System.now(),
                )
            )

            call.respondHtmlTemplate(BlogsTemplate()) {
                BlogView(testList).insertInto(content)
            }
        }

        get("/about") {
            call.respondHtmlTemplate(MainTemplate()) {
                AboutView().insertInto(content)
            }
        }

        get("/blogs/{blog-slug}") {
            val blogSlug = call.parameters["blog-slug"]

            call.respondText { "Blog slug - ${call.parameters["blog-slug"]}" }

//            call.respondHtmlTemplate(ReadTemplate()) {
//                BlogSlugView().insertInto(content)
//            }
        }
    }
}
