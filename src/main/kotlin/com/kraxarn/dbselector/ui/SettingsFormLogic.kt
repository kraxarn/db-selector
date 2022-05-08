package com.kraxarn.dbselector.ui

import javax.swing.JPanel

class SettingsFormLogic : SettingsForm()
{
	init
	{
		comboBoxLanguage.addItem("Auto")
		comboBoxLanguage.addItem("English")
		comboBoxLanguage.addItem("Swedish")
	}

	val content: JPanel
		get() = panelMain
}