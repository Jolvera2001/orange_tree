package dev.jolvera.views

import dev.jolvera.models.Blog
import kotlinx.datetime.toJavaInstant
import kotlinx.html.*
import java.time.ZoneId
import java.time.format.DateTimeFormatter

class BlogView(private val blogList: List<Blog>? = null) : View() {
    private val formatter = DateTimeFormatter.ofPattern("MMM d, yyy")
        .withZone(ZoneId.of("America/Chicago"))
    override fun FlowContent.apply() {
        if (blogList != null) {
            div("blog-grid") {
                for (blog in blogList) {
                    a(href = "/blogs/${blog.slug}", classes = "blog-card") {
                        div{
                            h2 { +blog.title }
                            h3 { +blog.subtitle }
                        }
                        p { +"Date published: ${formatter.format(blog.createdAt.toJavaInstant())}" }
                    }
                }
            }
        } else {
            div("blog-no-content") {
                h1 { +"Sorry, there's nothing here yet!" }
                h2 { +"Once everything is set up properly, I'll be sure to post some blogs!" }
            }
        }
    }
}