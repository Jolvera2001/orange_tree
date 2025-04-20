package dev.jolvera.models

import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId

data class Analytics(
    @BsonId val id: ObjectId? = null,
    val blogId: ObjectId,
    val clicked: Long,
)
