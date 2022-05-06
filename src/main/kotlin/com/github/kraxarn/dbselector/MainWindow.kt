package com.github.kraxarn.dbselector

import com.intellij.openapi.wm.ToolWindow
import javax.swing.JPanel

class MainWindow(toolWindow: ToolWindow) {
	private lateinit var mainContent: JPanel

	fun getContent() = mainContent
}