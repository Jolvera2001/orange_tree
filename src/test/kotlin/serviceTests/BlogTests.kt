package dev.jolvera.serviceTests

import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.server.testing.*
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import org.jetbrains.exposed.sql.Database
import java.util.UUID
import kotlin.test.Test

class BlogTests {
    private val mockDatabase = mockk<Database>()
    private val blogService = BlogService(mockDatabase)

    @Test
    fun `test getting a blog`() = runTest {
        // expecting ID, Title, Subtitle, Body, Date Published, Date Updated, views
        val blogId = UUID.randomUUID()
        val now = Clock.System.now()
        val expectedBlog = Blog(
            id = blogId,
            title = "Title",
            subtitle = "Subtitle",
            body = "Body",
            datePublished = now,
            dateUpdated = now,
            views = 0
        )
        coEvery { mockDatabase. }

    }

    fun `test updating a blog`() = runTest {

    }

    fun `test posting a blog`() = runTest {

    }

    fun `test deleting a blog`() = runTest {

    }
}