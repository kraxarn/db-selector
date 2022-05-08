@file:Suppress("UnstableApiUsage")

package com.kraxarn.dbselector

import com.intellij.icons.AllIcons
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.project.DumbAwareAction
import com.intellij.openapi.project.Project
import com.intellij.openapi.ui.DialogPanel
import com.intellij.ui.dsl.builder.RowLayout
import com.intellij.ui.dsl.builder.bindItem
import com.intellij.ui.dsl.builder.panel
import com.jetbrains.rd.ui.bedsl.dsl.tabbedControl

// Kotlin UI DSL v2 is "experimental" in 2021.3
@Suppress("Experimental")

fun mainPanel(project: Project): DialogPanel
{
	val model = getModel()
	return panel {
//		group("Path to Repository") {
//			row("Path") {
//				textFieldWithBrowseButton(
//					"Path to Repository", project,
//					FileChooserDescriptorFactory.createSingleFolderDescriptor()
//				) {
//					project.notifyInfo("Selected ${it.name}", it.path)
//					it.path
//				}.horizontalAlign(HorizontalAlign.FILL)
//			}
//		}
		group("Settings") {
			row {
				label("Database server")
				comboBox(model.allServers)
					.bindItem(model::currentServer)
				actionButton(object : DumbAwareAction("Add", "Add server", AllIcons.General.Add)
				{
					override fun actionPerformed(event: AnActionEvent)
					{
					}
				})
			}.layout(RowLayout.PARENT_GRID)
		}

		tabbedControl(null)

		group("Databases") {
		}
	}
}

internal fun getModel(): Model
{
	return Model(arrayOf("localhost"), "localhost")
}