package dev.jolvera.views

import dev.jolvera.models.Blog
import kotlinx.html.FlowContent
import kotlinx.html.div
import kotlinx.html.h1
import kotlinx.html.h2

class BlogView(private val blogList: List<Blog>? = null) : View() {
    override fun FlowContent.apply() {
        if (blogList != null) {
            div("blog-grid") {

            }
        } else {
            div("blog-no-content") {
                h1 { +"Sorry, there's nothing here yet!" }
                h2 { +"Once everything is set up properly, I'll be sure to post some blogs!" }
            }
        }
    }
}