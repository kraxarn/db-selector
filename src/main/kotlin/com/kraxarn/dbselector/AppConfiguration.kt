package com.kraxarn.dbselector

import com.intellij.openapi.options.Configurable
import javax.swing.JComponent
import javax.swing.JPanel

class AppConfiguration : Configurable {
	override fun createComponent(): JComponent {
		return JPanel()
	}

	override fun isModified(): Boolean {
		return false
	}

	override fun apply() {
	}

	override fun getDisplayName(): String {
		return "Database Selector"
	}
}