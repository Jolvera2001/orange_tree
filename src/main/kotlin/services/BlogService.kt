package dev.jolvera.services

import dev.jolvera.di.DatabaseManager
import dev.jolvera.models.Blog
import dev.jolvera.models.BlogEntity
import kotlinx.datetime.Clock
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import org.jetbrains.exposed.sql.transactions.transaction
import java.util.UUID

class BlogService(
    private val db: DatabaseManager,
) {
    fun PublishBlog(newBlog: BlogDto): Blog {
        val validationErrors = newBlog.validate()
        if (validationErrors.isNotEmpty()) {
            throw ValidationException("Validation failed: ${validationErrors.joinToString("\n")}", validationErrors)
        }

        val blog = newBlog.toBlog()

        return transaction(db.db) {
            val now = Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault())
            val entity = BlogEntity.new {
                title = blog.title
                subtitle = blog.subtitle
                author = blog.author
                body = blog.body
                createdAt = now
                updatedAt = now
                views = blog.views
            }

            entity.toBlog()
        }
    }

    fun GetBlog(id: UUID): Blog? {
        return transaction(db.db) {
            BlogEntity.findById(id)?.toBlog()
        }
    }

    fun UpdateBlog(id: UUID, blogDto: BlogDto): Blog? {
        val validationErrors = blogDto.validate()
        if (validationErrors.isNotEmpty()) {
            throw ValidationException("Validation failed: ${validationErrors.joinToString("\n")}", validationErrors)
        }

        return transaction(db.db) {
            val entity = BlogEntity.findById(id) ?: return@transaction null

            blogDto.title.let { entity.title = it }
            blogDto.subtitle.let { entity.subtitle = it }
            blogDto.author.let { entity.author = it }
            blogDto.body.let { entity.body = it }

            entity.updatedAt = Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault())

            entity.toBlog()
        }
    }

    fun DeleteBlog(id: UUID): Boolean {
        return transaction(db.db) {
            val entity = BlogEntity.findById(id) ?: return@transaction false
            entity.delete()
            true
        }
    }
}

class ValidationException(message: String, val errors: List<String> = emptyList()) : RuntimeException(message)

data class BlogDto(
    val title: String,
    val subtitle: String,
    val author: String,
    val body: String,
) {
    fun validate(): List<String> {
        val errors = mutableListOf<String>()

        if (title.isBlank()) {
            errors.add("Title cannot be empty")
        } else if (title.length > 100) {
            errors.add("Title cannot exceed 100 characters")
        }

        if (subtitle.length > 200) {
            errors.add("Subtitle cannot exceed 200 characters")
        }

        if (author.isBlank()) {
            errors.add("Author cannot be empty")
        }

        if (body.isBlank()) {
            errors.add("Blog content cannot be empty")
        }

        return errors
    }

    fun toBlog(): Blog {
        val now = Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault())
        return Blog(
            id = UUID.randomUUID(),
            title = title,
            subtitle = subtitle,
            author = author,
            body = body,
            createdAt = now,
            updatedAt = now,
            views = 0,
        )
    }
}