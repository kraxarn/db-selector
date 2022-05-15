package com.kraxarn.dbselector

import com.microsoft.sqlserver.jdbc.SQLServerDriver
import java.sql.Connection
import java.sql.DriverManager

class Database(private val hostname: String, private val databaseName: String?)
{
	private val connection: Connection

	private val connectionUrl: String
		get() = "jdbc:sqlserver://$hostname;databaseName=${databaseName ?: "master"}"

	val databaseNames: List<String>
		get()
		{
			val sql = "select * from sys.databases where has_perms_by_name(name, 'database', 'create_table') = 1";
			val results = mutableListOf<String>()

			val stmt = connection.createStatement()
			val result = stmt.executeQuery(sql)
			while (result.next())
			{
				results.add(result.getString(0))
			}

			return results
		}

	init
	{
		DriverManager.registerDriver(SQLServerDriver())
		DriverManager.setLoginTimeout(3)
		connection = DriverManager.getConnection(connectionUrl)
	}
}