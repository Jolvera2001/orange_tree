package dev.jolvera.views

import io.ktor.server.html.*
import kotlinx.html.*

class HomeView : View() {
    override fun FlowContent.apply() {
        h2 { +"Home View" }
    }
}

