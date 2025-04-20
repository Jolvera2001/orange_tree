package dev.jolvera.views

import dev.jolvera.services.BlogService
import kotlinx.html.*

class AboutView() : View() {
    override fun FlowContent.apply() {
        h1 { +"About Page" }
    }
}