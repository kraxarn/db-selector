package com.kraxarn.dbselector

import com.intellij.openapi.project.Project
import com.intellij.openapi.wm.ToolWindow
import com.intellij.openapi.wm.ToolWindowFactory
import com.intellij.ui.content.ContentFactory
import com.kraxarn.dbselector.ui.mainPanel

class MainWindowFactory : ToolWindowFactory
{
	override fun createToolWindowContent(project: Project, toolWindow: ToolWindow)
	{
		val contentFactory = ContentFactory.SERVICE.getInstance()
		val content = contentFactory.createContent(mainPanel(project), "", false)
		toolWindow.contentManager.addContent(content)
	}
}