package dev.jolvera.templates

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.css.*

fun Application.module() {
    val background = hsl(30, 100, 70)
    val cardBackground = hsl(30, 30, 95)

    val textColor = hsl(30, 15, 15)

    routing {
        get("/styles.css") {
            call.respondCss {
                body {
                    backgroundColor = background
                    color = textColor
                }

                rule("nav") {
                    padding = Padding(1.rem)
                    display = Display.flex
                    alignItems = Align.center
                    gap = 1.rem
                }

                rule(".container") {

                }

                rule(".card") {
                    backgroundColor = cardBackground
                    padding = Padding(1.rem)
                }
            }
        }
    }
}

suspend inline fun ApplicationCall.respondCss(builder: CssBuilder.() -> Unit) {
    this.respondText(CssBuilder().apply(builder).toString(), ContentType.Text.CSS)
}
