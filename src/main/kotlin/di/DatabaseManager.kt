package dev.jolvera.di

import org.jetbrains.exposed.sql.Database

class DatabaseManager(
    private val jdbcUrl: String,
    private val driver: String,
    private val user: String = "",
    private val password: String = "",
    public var db: Database? = null
) {
    fun connect() {
        val database = Database.connect(
            url = jdbcUrl,
            driver = driver,
            user = user,
            password = password
        )

        db = database
    }
}