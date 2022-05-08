package com.kraxarn.dbselector.ui

import com.intellij.openapi.project.Project
import com.kraxarn.dbselector.extensions.notifyError
import java.awt.Desktop
import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import java.net.URI
import javax.swing.AbstractAction
import javax.swing.JPanel
import kotlin.random.Random

class MainFormLogic(val project: Project) : MainForm()
{
	init
	{
		// Server
		comboBoxServer.addItem("localhost")

		// Databases

		// Scripts

		// Passwords

		//region About

		buttonAboutOpenSource.addActionListener {
			try
			{
				val desktop = Desktop.getDesktop()
				val uri = URI("https://github.com/kraxarn/db-selector")
				desktop.browse(uri)
			} catch (e: Exception)
			{
				project.notifyError("Failed to open link", e.message ?: "Unknown error")
			}
		}

		labelAboutSecret.isVisible = Random.Default.nextInt() < Int.MAX_VALUE / 8

		//endregion
	}

	val content: JPanel
		get() = panelMain
}