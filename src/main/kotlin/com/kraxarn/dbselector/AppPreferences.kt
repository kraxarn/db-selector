package com.kraxarn.dbselector

import java.util.prefs.Preferences

class AppPreferences {
	private val preferences: Preferences = Preferences.userNodeForPackage(AppPreferences::class.java)

	var repositoryPath: String?
		get() = preferences.get("repositoryPath", null)
		set(value) = preferences.put("repositoryPath", value)

	fun save() = preferences.flush()
}