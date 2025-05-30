package dev.jolvera.templates

import io.ktor.server.html.*
import kotlinx.html.*

class BlogsTemplate : Template<HTML> {
    var content = Placeholder<FlowContent>()

    override fun HTML.apply() {
        head {
            title { +"Orange_Tree" }
            link(rel = "preconnect", href = "https://fonts.googleapis.com")
            link(rel = "preconnect", href = "https://fonts.gstatic.com") {
                attributes["crossorigin"] = "anonymous"
            }
            link(
                rel = "stylesheet",
                href = "https://fonts.googleapis.com/css2?family=Inter:ital,opsz,wght@0,14..32,100..900;1,14..32,100..900&family=Nunito:ital,wght@0,200..1000;1,200..1000&display=swap"
            )

            // personal styling
            link(rel = "stylesheet", href = "/styles.css")
            link(rel = "stylesheet", href = "/blogStyles.css")
        }
        body("body-blogs") {
            header {
                div(classes = "topbar") {
                    h1(classes = "headline") { +"Orange_Tree" }
                    nav(classes = "navbar") {
                        ul {
                            li { a(href = "/") { +"Home" } }
                            li { a(href = "/blogs") { +"Blogs" } }
                            li { a(href = "/about") { +"About" } }
                        }
                    }
                    p(classes = "right") {}
                }
            }
            main {
                div("container") {
                    insert(content)
                }
            }
            footer {
                p { +"© 2025 My Blog" }
                nav {
                    a(href = "https://github.com/jolvera2001") { +"GitHub" }
                    +"  |  "
                    a(href = "/rss") { +"RSS" }
                }
            }
        }
    }
}