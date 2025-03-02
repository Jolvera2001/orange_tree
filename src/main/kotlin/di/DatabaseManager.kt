package dev.jolvera.di

import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.transactions.transaction

class DatabaseManager(
    private val jdbcUrl: String,
    private val driver: String,
    private val user: String = "",
    private val password: String = ""
) {
    fun connect(): Database {
        val database = Database.connect(
            url = jdbcUrl,
            driver = driver,
            user = user,
            password = password
        )

        transaction(database) {
            // SchemaUtils.create( [model here] )
        }

        return database
    }
}