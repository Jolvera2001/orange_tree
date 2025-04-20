package dev.jolvera.models

import org.bson.types.ObjectId

data class Analytics(
    val blogId: ObjectId,
    val clicked: Long,
)
