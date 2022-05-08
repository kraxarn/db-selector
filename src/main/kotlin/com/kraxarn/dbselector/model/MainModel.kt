package com.kraxarn.dbselector.model

internal data class MainModel(
	val allServers: Array<String>,
	var currentServer: String,
)
