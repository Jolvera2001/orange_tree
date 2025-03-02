package dev.jolvera.templates

import io.ktor.server.html.*
import kotlinx.html.*

class MainTemplate : Template<HTML> {
    val header = Placeholder<FlowContent>()
    val content = Placeholder<FlowContent>()

    override fun HTML.apply() {
        head {
            title { +"My Blog" }
            link(rel = "stylesheet", href = "/styles.css")
        }
        body {
            header {
                h1 { +"My Blog" }
                nav {
                    ul {
                        li { a(href = "/") { +"Home" } }
                        li { a(href = "/about") { +"About" } }
                        li { a(href = "/blogs") { +"Blogs" } }
                    }
                }
            }
            main {
                insert(content)
            }
            footer {
                p { +"© 2025 My Blog" }
                nav {
                    a(href = "https://github.com/yourusername") { +"GitHub" }
                    +" | "
                    a(href = "/rss") { +"RSS" }
                }
            }
        }
    }
}

