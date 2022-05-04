package com.github.kraxarn.dbselector.services

import com.intellij.openapi.project.Project
import com.github.kraxarn.dbselector.MyBundle

class MyProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))
    }
}
