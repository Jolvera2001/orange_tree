package dev.jolvera.templates

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.css.*
import kotlinx.css.properties.LinearGradientBuilder
import kotlinx.css.properties.TextDecoration
import kotlinx.css.properties.linearGradient

fun Application.configureCss() {
    val backgroundMain = hsl(30, 100, 70)

    val textColor = hsl(30, 15, 15)

    routing {
        get("/styles.css") {
            call.respondCss {
                body {
                    fontFamily = "Nunito, sans-serif"
                    backgroundImage = linearGradient { backgroundMain }
                    color = textColor
                    margin = Margin(0.px)
                    padding = Padding(0.px)
                    display = Display.flex
                    flexDirection = FlexDirection.column
                    alignItems = Align.center
                    minHeight = 100.vh
                }

                img {
                    borderRadius = 50.pct
                }

                rule("header") {
                    width = 100.pct
                    textAlign = TextAlign.center
                }

                rule("nav") {
                    display = Display.flex
                    justifyContent = JustifyContent.center
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
                        borderRadius = 10.px
                    }
                }

                rule("main") {
                    width = 100.pct
                    maxWidth = 70.pct
                    flex = Flex(1.0, 1.0, 100.pct)
                    display = Display.flex
                    flexDirection = FlexDirection.column
                    alignItems = Align.center
                }


                rule("footer") {
                    width = 100.pct
                    textAlign = TextAlign.center
                    padding = Padding(1.rem)
                    boxSizing = BoxSizing.borderBox
                }

                rule(".container") {
                    width = 100.pct
                    padding = Padding(.75.rem)
                    boxSizing = BoxSizing.borderBox
                    textAlign = TextAlign.center
                }

                rule(".container p") {
                    textAlign = TextAlign.left
                    maxWidth = 700.px
                    margin = Margin(0.px, LinearDimension.auto)
                }

                rule(".vertical-align") {
                    display = Display.flex
                    flexDirection = FlexDirection.column
                    justifyContent = JustifyContent.center
                    gap = 4.px
                }

                rule(".headline") {
                    fontSize = 1.5.rem
                    margin = Margin(horizontal = 2.0.rem)
                }

                rule(".topbar") {
                    display = Display.flex
                    flexDirection = FlexDirection.row
                    justifyContent = JustifyContent.spaceEvenly
                    alignItems = Align.center
                    padding = Padding(1.rem)
                }

                rule(".headline .right") {
                    flexGrow = 1
                }

                rule(".navbar") {
                    display = Display.flex
                    justifyContent = JustifyContent.center
                    alignItems = Align.center
                    marginRight = LinearDimension.auto
                }
            }
        }
    }
}

suspend inline fun ApplicationCall.respondCss(builder: CssBuilder.() -> Unit) {
    this.respondText(CssBuilder().apply(builder).toString(), ContentType.Text.CSS)
}
