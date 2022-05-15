package com.kraxarn.dbselector.ui

class PasswordsTab(private val form: MainForm)
{
	init
	{
		form.checkBoxPasswordsAllUsers.addActionListener {
			form.textFieldPasswordUsername.isEnabled = !form.checkBoxPasswordsAllUsers.isSelected
		}

		form.checkBoxPasswordsClearPassword.addActionListener {
			form.passwordFieldPasswordsPassword.isEnabled = !form.checkBoxPasswordsClearPassword.isSelected
		}
	}
}