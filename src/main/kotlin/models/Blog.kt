package dev.jolvera.models

import kotlinx.datetime.LocalDateTime
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
