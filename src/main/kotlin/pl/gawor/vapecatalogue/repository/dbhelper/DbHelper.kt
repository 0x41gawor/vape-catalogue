package pl.gawor.vapecatalogue.repository.dbhelper

import java.sql.Connection
import java.sql.DriverManager
import java.sql.Statement

class DbHelper {
    val DB_URL = "jdbc:mysql://localhost:3306/vape_catalogue_db?serverTimezone=UTC"
    val DB_USER = "root"
    val DB_PASSWORD = "ejek"

    fun getConnection(): Connection? {
        val connection: Connection
        return try {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD
            )
            connection
        } catch (ex: Exception) {
            println("Error: " + ex.message)
            null
        }
    }

    fun executeQuery(query: String) {
        val connection = getConnection()
        val statement: Statement
        try {
            statement = connection!!.createStatement()
            statement.executeUpdate(query)
        } catch (ex: java.lang.Exception) {
            ex.printStackTrace()
        }
    }
}