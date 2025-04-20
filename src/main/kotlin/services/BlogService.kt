package dev.jolvera.services

import com.mongodb.kotlin.client.coroutine.MongoClient

class BlogService(private val mongoClient: MongoClient) {
    suspend fun GetBlogs() {

    }

    suspend fun GetBlogBySlug(slug: String) {

    }
}