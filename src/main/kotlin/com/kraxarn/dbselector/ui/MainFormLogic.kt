package com.kraxarn.dbselector.ui

import com.intellij.openapi.project.Project
import javax.swing.JPanel

class MainFormLogic(project: Project) : MainForm()
{
	private val options = Options(this)
	private val databasesTab = DatabasesTab(this)
	private val scriptsTab = ScriptsTab(this, project)
	private val passwordsTab = PasswordsTab(this)
	private val aboutTab = AboutTab(this, project)

	val content: JPanel
		get() = panelMain
}