package dev.jolvera.views

import io.ktor.server.html.*
import kotlinx.html.FlowContent

abstract class View : Template<FlowContent> {
    fun insertInto(placeholder: Placeholder<FlowContent>) {
        placeholder {
            apply()
        }
    }
}