package dev.jolvera.templates

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.css.*
import kotlinx.css.properties.BoxShadows
import kotlinx.css.properties.TextDecoration

fun Application.configureCss() {
    val background = hsl(30, 100, 70)
    val cardBackground = hsl(30, 30, 95)

    val textColor = hsl(30, 15, 15)

    routing {
        get("/styles.css") {
            call.respondCss {
                body {
                    fontFamily = "Nunito, sans-serif"
                    backgroundColor = background
                    color = textColor
                    margin = Margin(0.px)
                    padding = Padding(0.px)
                    display = Display.flex
                    flexDirection = FlexDirection.column
                    alignItems = Align.center
                    minHeight = 100.vh
                }

                rule("header") {
                    width = 100.pct
                    textAlign = TextAlign.center
                    padding = Padding(1.rem)
                }

                rule(".headline") {
                    margin = Margin(0.px, 0.px, 1.rem)
                    fontSize = 3.0.em
                }

                rule("nav") {
                    width = 100.pct
                    display = Display.flex
                    justifyContent = JustifyContent.center
                    paddingBottom = 1.rem
                }

                rule("ul") {
                    listStyleType = ListStyleType.none
                    margin = Margin(0.px)
                    padding = Padding(0.px)
                    display = Display.flex
                    justifyContent = JustifyContent.center
                }

                rule("li") {
                    margin = Margin(0.px, 0.5.rem)
                }

                rule("li a") {
                    display = Display.block
                    textAlign = TextAlign.center
                    padding = Padding(14.px, 16.px)
                    textDecoration = TextDecoration.none
                    color = textColor

                    hover {
                        backgroundColor = rgb(255, 255, 255, 0.3)
                        color = Color.darkBlue
                        borderRadius = 4.px
                    }
                }

                rule("main") {
                    width = 100.pct
                    maxWidth = 800.px
                    flex = Flex(1.0, 1.0, 100.pct)
                    display = Display.flex
                    flexDirection = FlexDirection.column
                    alignItems = Align.center
                }

                rule(".container") {
                    width = 100.pct
                    padding = Padding(1.rem)
                    boxSizing = BoxSizing.borderBox
                    textAlign = TextAlign.center
                }

                rule(".container p") {
                    textAlign = TextAlign.left
                    maxWidth = 700.px
                    margin = Margin(0.px, LinearDimension.auto)
                }

                rule(".card") {
                    backgroundColor = cardBackground
                    padding = Padding(1.rem)
                    borderRadius = 4.px
                    boxShadow = BoxShadows()
                    marginBottom = 1.rem
                }

                rule("footer") {
                    width = 100.pct
                    textAlign = TextAlign.center
                    padding = Padding(1.rem)
                    marginTop = 2.rem
                }
            }
        }
    }
}

suspend inline fun ApplicationCall.respondCss(builder: CssBuilder.() -> Unit) {
    this.respondText(CssBuilder().apply(builder).toString(), ContentType.Text.CSS)
}
