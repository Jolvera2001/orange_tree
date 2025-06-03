package dev.jolvera.views

import kotlinx.html.*

class AboutView() : View() {
    override fun FlowContent.apply() {
        h1 { +"About Page" }
    }
}