package com.github.kraxarn.dbselector

import com.intellij.openapi.project.Project
import com.intellij.openapi.wm.ToolWindow
import com.intellij.openapi.wm.ToolWindowFactory
import com.intellij.ui.content.ContentFactory

class MainWindowFactory : ToolWindowFactory {
	override fun createToolWindowContent(project: Project, toolWindow: ToolWindow) {
		val window = MainWindow(toolWindow)
		val contentFactory = ContentFactory.SERVICE.getInstance()
		val content = contentFactory.createContent(window.getContent(), "", false)
		toolWindow.contentManager.addContent(content)
	}
}