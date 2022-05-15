package com.kraxarn.dbselector.ui

import com.intellij.openapi.project.Project
import com.kraxarn.dbselector.extensions.notifyInfo
import java.awt.GridBagConstraints
import java.awt.Insets
import java.io.File
import java.nio.file.Paths
import javax.swing.JButton

class ScriptsTab(private val form: MainForm, private val project: Project)
{
	private val path = findScriptsPath()

	init
	{
		if (path == null)
		{
			form.listScripts.isVisible = false
		} else
		{
			form.labelScriptsNoScripts.isVisible = false
			addOptions()
		}
	}

	private fun findScriptsPath(): String?
	{
		for (file in File(project.basePath ?: return null).walk())
		{
			if (file.extension == "sql")
			{
				return file.parent
			}
		}

		return null
	}

	private fun addOptions()
	{
		val panel = form.panelScriptsList
		val constraints = GridBagConstraints()
		constraints.fill = GridBagConstraints.HORIZONTAL
		constraints.gridx = 0
		constraints.weightx = 1.0
		constraints.insets = Insets(8, 12, 0, 12)

		val filenames = (File(path ?: return).listFiles() ?: return)
			.map { it.nameWithoutExtension }
			.sorted()

		for (filename in filenames)
		{
			val button = JButton(filename)
			button.addActionListener {
				runScript(filename)
			}

			panel.add(button, constraints)
		}
	}

	private fun runScript(filename: String)
	{
		val scriptPath = Paths.get(path ?: return, "$filename.sql")
		project.notifyInfo("Path", scriptPath.toString())
	}
}