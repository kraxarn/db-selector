package com.kraxarn.dbselector.extensions

import com.intellij.notification.NotificationGroupManager
import com.intellij.notification.NotificationType
import com.intellij.openapi.project.Project

fun Project?.notifyInfo(title: String, content: String) =
	this.notify(title, content, NotificationType.INFORMATION)

fun Project?.notifyWarn(title: String, content: String) =
	this.notify(title, content, NotificationType.WARNING)

fun Project?.notifyError(title: String, content: String) =
	this.notify(title, content, NotificationType.ERROR)

private fun Project?.notify(title: String, content: String, type: NotificationType) {
	NotificationGroupManager
		.getInstance()
		.getNotificationGroup("Notifications")
		.createNotification(title, content, type)
		.notify(this)
}
