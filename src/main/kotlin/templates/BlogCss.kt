package dev.jolvera.templates

import io.ktor.server.application.*
import io.ktor.server.routing.get
import io.ktor.server.routing.routing
import kotlinx.css.Align
import kotlinx.css.Color
import kotlinx.css.Display
import kotlinx.css.FlexDirection
import kotlinx.css.GridTemplateColumns
import kotlinx.css.JustifyContent
import kotlinx.css.JustifyItems
import kotlinx.css.Margin
import kotlinx.css.Padding
import kotlinx.css.TextAlign
import kotlinx.css.alignContent
import kotlinx.css.alignItems
import kotlinx.css.backgroundColor
import kotlinx.css.backgroundImage
import kotlinx.css.borderRadius
import kotlinx.css.boxShadow
import kotlinx.css.color
import kotlinx.css.display
import kotlinx.css.em
import kotlinx.css.flexDirection
import kotlinx.css.fontFamily
import kotlinx.css.fr
import kotlinx.css.gap
import kotlinx.css.gridTemplateColumns
import kotlinx.css.hsl
import kotlinx.css.justifyContent
import kotlinx.css.justifyItems
import kotlinx.css.margin
import kotlinx.css.maxWidth
import kotlinx.css.minHeight
import kotlinx.css.padding
import kotlinx.css.pct
import kotlinx.css.properties.BoxShadow
import kotlinx.css.properties.BoxShadows
import kotlinx.css.properties.TextDecoration
import kotlinx.css.properties.Timing
import kotlinx.css.properties.Transform
import kotlinx.css.properties.Transforms
import kotlinx.css.properties.Transition
import kotlinx.css.properties.Transitions
import kotlinx.css.properties.deg
import kotlinx.css.properties.linearGradient
import kotlinx.css.properties.s
import kotlinx.css.properties.transform
import kotlinx.css.properties.translateY
import kotlinx.css.px
import kotlinx.css.rem
import kotlinx.css.rgb
import kotlinx.css.textAlign
import kotlinx.css.textDecoration
import kotlinx.css.transform
import kotlinx.css.transition
import kotlinx.css.vh
import kotlinx.css.width
import javax.xml.crypto.dsig.TransformService

fun Application.configureBlogCss() {
    // dark background
    val backgroundMain = hsl(225, 8, 20)
    // orange
//    val backgroundSec = hsl(30, 100, 70)
    val cardBackground = rgb(255, 255, 255, 0.2)
    val cardBackgroundHover = hsl(255, 255, 255, 0.25)
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
                        colorStop(backgroundMain, 100.pct)
                    }
                    color = textColor
                    margin = Margin(0.px)
                    padding = Padding(0.px)
                    display = Display.flex
                    flexDirection = FlexDirection.column
                    alignItems = Align.center
                    minHeight = 100.vh
                }

                rule("li a") {
                    color = Color("#99BBFF")
                }

                rule(".blog-grid") {
                    display = Display.grid
                    justifyContent = JustifyContent.center
                    gridTemplateColumns = GridTemplateColumns(1.fr, 1.fr)
                    gap = 2.rem
                    width = 100.pct
                    maxWidth = 1200.px
                    margin = Margin(0.px)
                }

                rule(".blog-card") {
                    display = Display.flex
                    padding = Padding(1.rem)
                    backgroundColor = cardBackground
                    borderRadius = 8.px
                    flexDirection = FlexDirection.column
                    justifyContent = JustifyContent.left
                    textAlign = TextAlign.left
                    textDecoration = TextDecoration.none
                    color = textColor
                    gap = 1.rem
                    transition = Transitions().apply {
                        this += Transition("transform", 0.3.s, Timing.easeOut)
                        this += Transition("box-shadow", 0.3.s, Timing.ease)
                        this += Transition("background-color", 0.4.s, Timing.ease)
                    }

                    hover {
                        transform {
                            translateY((-5).px)
                        }
                        backgroundColor = cardBackgroundHover
                    }
                }
            }
        }
    }
}