package dev.jolvera.di

import com.mongodb.kotlin.client.coroutine.MongoClient

class MongoData {
    private val databaseClient: MongoClient? = null
    init {
        val uri = "" // Get from env var

        val client = MongoClient.create(uri)
    }

    public fun getDatabase(): MongoClient {
        return databaseClient!!
    }
}