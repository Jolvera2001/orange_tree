package dev.jolvera.di

import com.mongodb.kotlin.client.coroutine.MongoClient
import com.mongodb.kotlin.client.coroutine.MongoDatabase

class MongoData {
    private var database: MongoDatabase? = null
    init {
        val uri = System.getenv("MONGO_CONNECTION_STRING")

        val client = MongoClient.create(uri)
        database = client.getDatabase("OrangeTreeDb")
    }

    public fun getDatabase(): MongoDatabase {
        return database!!
    }
}