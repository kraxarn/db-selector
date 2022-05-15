package com.kraxarn.dbselector.ui

import com.intellij.openapi.project.Project
import com.kraxarn.dbselector.Database
import com.kraxarn.dbselector.extensions.notifyError
import com.kraxarn.dbselector.extensions.notifyWarn
import java.sql.SQLException

class Options(private val form: MainForm,
	private val databasesTab: DatabasesTab,
	private val project: Project)
{
	init
	{
		form.comboBoxServer.addItem("localhost")

		form.comboBoxServer.addActionListener {
			databasesTab.setDatabases(getDatabases())
		}
	}

	private fun getDatabases(): List<String>
	{
		val hostname = form.comboBoxServer.selectedItem
		if (hostname !is String)
		{
			project.notifyWarn("No server", "No server selected")
			return listOf()
		}

		try
		{
			val db = Database(hostname, null)
			return db.databaseNames
		}
		catch (e: SQLException)
		{
			project.notifyError("Database error", e.message ?: e.sqlState)
		}

		return listOf()
	}
}