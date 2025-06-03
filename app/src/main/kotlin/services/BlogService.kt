package dev.jolvera.services

import com.mongodb.client.model.Filters
import com.mongodb.client.model.Sorts
import dev.jolvera.di.MongoData
import dev.jolvera.models.Blog
import kotlinx.coroutines.flow.singleOrNull
import kotlinx.coroutines.flow.toList

class BlogService(private val mongoDatabase: MongoData) {
    private val collection = mongoDatabase.getDatabase().getCollection<Blog>("blogs")

    suspend fun GetBlogs(): List<Blog> {
        return collection
            .find()
            .sort(Sorts.descending(Blog::createdAt.name))
            .toList()
    }

    suspend fun GetBlogBySlug(slug: String): Blog {
        return collection
            .find(Filters.eq("slug", slug))
            .singleOrNull()!!
    }
}