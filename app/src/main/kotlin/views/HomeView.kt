package dev.jolvera.views

import dev.jolvera.services.GithubUser
import io.ktor.server.html.*
import kotlinx.html.*

class HomeView() : View() {
    override fun FlowContent.apply() {
        h2 { +"Home View" }
    }
}

