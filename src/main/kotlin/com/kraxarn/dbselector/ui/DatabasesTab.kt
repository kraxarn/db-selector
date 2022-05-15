package com.kraxarn.dbselector.ui

import javax.swing.DefaultListModel

class DatabasesTab(private val form: MainForm)
{
	fun setDatabases(databases: List<String>)
	{
		val model = DefaultListModel<Any>()
		form.listServers.model = model

		for (database in databases)
		{
			model.addElement(database)
		}
	}
}