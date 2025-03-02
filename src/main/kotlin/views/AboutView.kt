package dev.jolvera.views

import kotlinx.html.FlowContent
import kotlinx.html.h2

class AboutView : View() {
    override fun FlowContent.apply() {
        h2 { +"About View" }
    }
}