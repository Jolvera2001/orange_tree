package dev.jolvera.views

import io.ktor.server.html.*
import kotlinx.html.FlowContent
import kotlinx.html.h1

class BlogView : View() {
    override fun FlowContent.apply() {
        h1 { +"Blog View" }
    }
}