package dev.jolvera

import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.server.testing.*
import kotlin.test.Test
import kotlin.test.assertEquals

class RouteTests {
    @Test
    fun testRoot() = testApplication {
        application {
            module()
        }
        client.get("/").apply {
            assertEquals(HttpStatusCode.OK, status)
        }
    }

    @Test
    fun testAbout() = testApplication {
        application {
            module()
        }
        client.get("/about").apply {
            assertEquals(HttpStatusCode.OK, status)
        }
    }

    @Test
    fun testBlogs() = testApplication {
        application {
            module()
        }
        client.get("/blogs").apply {
            assertEquals(HttpStatusCode.OK, status)
        }
    }

    @Test
    fun testBlogPagination() = testApplication {
        TODO()
    }

    @Test
    fun testBlogView() = testApplication {
        TODO()
    }
}