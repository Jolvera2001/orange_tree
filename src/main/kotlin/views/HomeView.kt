package dev.jolvera.views

import dev.jolvera.services.GithubUser
import io.ktor.server.html.*
import kotlinx.html.*

class HomeView(private val profile: GithubUser) : View() {
    override fun FlowContent.apply() {
        h2 { +"Home View" }
        div(classes = "card") {
            div(classes = "card-header") {
                img(src = profile.avatar_url,
                    alt = "Github avatar") {
                    width = "125"
                    height = "125"
                }

                div(classes = "vertical-align") {
                    h3 { +profile.name }
                    p { +"Followers: ${profile.followers}" }
                    p { +"Following: ${profile.following}" }
                }

                p { +profile.bio }
            }
        }
    }
}

