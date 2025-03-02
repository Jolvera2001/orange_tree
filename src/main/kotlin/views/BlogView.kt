package dev.jolvera.views

import kotlinx.html.FlowContent
import kotlinx.html.h2

class BlogView : View() {
    override fun FlowContent.apply() {
        h2 { +"Blog View" }
    }
}