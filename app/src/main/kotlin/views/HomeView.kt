package dev.jolvera.views

import kotlinx.html.FlowContent
import kotlinx.html.h2

class HomeView() : View() {
    override fun FlowContent.apply() {
        h2 { +"Home View" }
    }
}

