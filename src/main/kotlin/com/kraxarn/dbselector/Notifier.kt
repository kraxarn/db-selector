package com.kraxarn.dbselector

import com.intellij.notification.NotificationGroupManager
import com.intellij.notification.NotificationType
import com.intellij.openapi.project.Project

class Notifier {
	companion object {
		fun info(project: Project?, title: String, content: String) =
			notify(project, title, content, NotificationType.INFORMATION)

		fun warn(project: Project?, title: String, content: String) =
			notify(project, title, content, NotificationType.WARNING)

		fun error(project: Project?, title: String, content: String) =
			notify(project, title, content, NotificationType.ERROR)

		private fun notify(project: Project?, title: String, content: String, type: NotificationType) {
			NotificationGroupManager
				.getInstance()
				.getNotificationGroup("Notifications")
				.createNotification(title, content, type)
				.notify(project)
		}
	}
}