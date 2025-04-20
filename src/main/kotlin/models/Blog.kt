package dev.jolvera.models

import kotlinx.datetime.LocalDateTime
import org.bson.types.ObjectId
import java.util.UUID

data class Blog(
    val _id: ObjectId? = null,
    val slug: String,
    val title: String,
    val subtitle: String,
    val author: String,
    val content: String,
    val updatedAt: LocalDateTime,
    val createdAt: LocalDateTime,
)
