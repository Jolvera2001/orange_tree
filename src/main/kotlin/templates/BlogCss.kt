package dev.jolvera.templates

import io.ktor.server.application.*
import io.ktor.server.html.respondHtml
import io.ktor.server.routing.get
import io.ktor.server.routing.routing
import kotlinx.css.Align
import kotlinx.css.Display
import kotlinx.css.FlexDirection
import kotlinx.css.Margin
import kotlinx.css.Padding
import kotlinx.css.alignItems
import kotlinx.css.backgroundImage
import kotlinx.css.body
import kotlinx.css.color
import kotlinx.css.display
import kotlinx.css.flexDirection
import kotlinx.css.fontFamily
import kotlinx.css.hsl
import kotlinx.css.margin
import kotlinx.css.minHeight
import kotlinx.css.padding
import kotlinx.css.pct
import kotlinx.css.properties.deg
import kotlinx.css.properties.linearGradient
import kotlinx.css.px
import kotlinx.css.vh

fun Application.configureBlogCss() {
    // dark background
    val backgroundMain = hsl(218, 23, 21)
    // orange
    val backgroundSec = hsl(30, 100, 70)
    val textColor = hsl(182, 82, 93)

    routing {
        get("/blogStyles.css") {
            call.respondCss {
                rule(".body-blogs") {
                    fontFamily = "Nunito, sans-serif"
                    backgroundImage = linearGradient(
                        45.deg
                    ) {
                        colorStop(backgroundMain, 50.pct)
                        colorStop(backgroundSec, 100.pct)
                    }
                    color = textColor
                    margin = Margin(0.px)
                    padding = Padding(0.px)
                    display = Display.flex
                    flexDirection = FlexDirection.column
                    alignItems = Align.center
                    minHeight = 100.vh
                }
            }
        }
    }
}