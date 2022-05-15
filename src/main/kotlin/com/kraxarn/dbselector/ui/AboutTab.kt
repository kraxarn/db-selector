package com.kraxarn.dbselector.ui

import com.intellij.openapi.project.Project
import com.kraxarn.dbselector.extensions.notifyError
import java.awt.Desktop
import java.net.URI
import kotlin.random.Random

class AboutTab(private val form: MainForm, private val project: Project)
{
	init
	{
		form.buttonAboutOpenSource.addActionListener {
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

		val version = javaClass.`package`.implementationVersion
		if (version != null)
		{
			form.labelAppName.text += " $version"
		}

		form.labelAboutSecret.isVisible = Random.Default.nextInt() < Int.MAX_VALUE / 10
	}
}