package com.kraxarn.dbselector.ui

class Options(private val form: MainForm)
{
	init
	{
		form.comboBoxServer.addItem("localhost")
	}
}