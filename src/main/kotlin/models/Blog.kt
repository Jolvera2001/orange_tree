package dev.jolvera.models

import kotlinx.datetime.LocalDateTime
import org.jetbrains.exposed.dao.id.UUIDTable
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.UUIDEntity
import org.jetbrains.exposed.dao.UUIDEntityClass
import org.jetbrains.exposed.sql.kotlin.datetime.datetime
import java.util.UUID

data class Blog(
    val id: UUID,
    val title: String,
    val subtitle: String,
    val author: String,
    val body: String,
    val updatedAt: LocalDateTime,
    val createdAt: LocalDateTime,
    val views: Int
)

object BlogsTable : UUIDTable("blogs") {
    val title = varchar("title", 255)
    val subtitle = varchar("subtitle", 255).nullable()
    val author = varchar("author", 255)
    val body = text("body")
    val createdAt = datetime("created_at")
    val updatedAt = datetime("updated_at")
    val views = integer("views").default(0)
}

class BlogEntity(id: EntityID<UUID>) : UUIDEntity(id) {
    companion object : UUIDEntityClass<BlogEntity>(BlogsTable)

    var title by BlogsTable.title
    var subtitle by BlogsTable.subtitle
    var author by BlogsTable.author
    var body by BlogsTable.body
    var createdAt by BlogsTable.createdAt
    var updatedAt by BlogsTable.updatedAt
    var views by BlogsTable.views

    fun toBlog(): Blog = Blog(
        id = id.value,
        title = title,
        subtitle = subtitle ?: "",
        author = author,
        body = body,
        createdAt = createdAt,
        updatedAt = updatedAt,
        views = views
    )
}
