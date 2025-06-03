package dev.jolvera.models

import kotlinx.datetime.Instant
import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId

data class Blog(
    @BsonId val id: ObjectId? = null,
    val slug: String,
    val title: String,
    val subtitle: String,
    val author: String,
    val content: String,
    val updatedAt: Instant,
    val createdAt: Instant,
)
