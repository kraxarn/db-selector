package com.kraxarn.dbselector

import com.intellij.openapi.options.Configurable
import javax.swing.JComponent
import javax.swing.JPanel

class AppConfiguration : Configurable
{
	override fun createComponent(): JComponent = JPanel()

	override fun isModified(): Boolean = false

	override fun apply() = Unit

	override fun getDisplayName(): String = "Database Selector"
}