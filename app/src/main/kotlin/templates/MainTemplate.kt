package dev.jolvera.templates

import io.ktor.server.html.*
import kotlinx.html.*

class MainTemplate : Template<HTML> {
    val content = Placeholder<FlowContent>()

    override fun HTML.apply() {
        head {
            title { +"Orange_Tree" }
            meta(name = "viewport", content = "width=device-width, initial-scale=1.0")
            link(rel = "preconnect", href = "https://fonts.googleapis.com")
            link(rel = "preconnect", href = "https://fonts.gstatic.com") {
                attributes["crossorigin"] = "anonymous"
            }
            link(
                rel = "stylesheet",
                href = "https://fonts.googleapis.com/css2?family=Inter:ital,opsz,wght@0,14..32,100..900;1,14..32,100..900&family=Nunito:ital,wght@0,200..1000;1,200..1000&display=swap"
            )

            // personal styling
            link(rel = "stylesheet", href = "/webjars/bootstrap/bootstrap.css")
        }
        body {
            header("d-flex flex-wrap justify-content-between py-3 mb-4 border-bottom") {
                nav(classes = "navbar navbar-expand-lg bg-body-tertiary w-100") {
                    div("container-fluid") {
                        a(classes = "navbar-brand me-4", href = "#") { +"Orange_Tree" }

                        button(classes = "navbar-toggler", type = ButtonType.button) {
                            attributes["data-bs-toggle"] = "collapse"
                            attributes["data-bs-target"] = "#navbarNav"
                            attributes["aria-controls"] = "navbarNav"
                            attributes["aria-expanded"] = "false"
                            attributes["aria-label"] = "Toggle navigation"
                            span("navbar-toggler-icon") {}
                        }

                        div("collapse navbar-collapse") {
                            attributes["id"] = "navbarNav"
                            ul("navbar-nav") {
                                li("nav-item") { a(href = "/", classes = "nav-link") { +"Home" } }
                                li("nav-item") { a(href = "/blogs", classes = "nav-link") { +"Blogs" } }
                                li("nav-item") { a(href = "/about", classes = "nav-link") { +"About" } }
                            }
                        }
                    }
                }
            }
            main {
                div(classes = "container") {
                    insert(content)
                }
            }
            footer("container py-3 mt-4 border-top") {
                div("row") {
                    div("col-md-6") {
                        p { +"© 2025 My Blog" }
                    }
                    div("col-md-6 d-flex justify-content-end") {
                        nav {
                            a(href = "https://github.com/jolvera2001") { +"GitHub" }
                            +"  |  "
                            a(href = "/rss") { +"RSS" }
                        }
                    }
                }
            }
            script(src = "/webjars/bootstrap/bootstrap.js") {}
        }
    }
}

