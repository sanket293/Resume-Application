package com.sanketvagadiya.Model


class ProjectModel(projectName: String, imageUrl: String, projectUrl: String) {
    var projectName: String
        internal set
    var imageUrl: String
        internal set
    var projectUrl: String
        internal set

    init {
        this.projectName = projectName
        this.imageUrl = imageUrl
        this.projectUrl = projectUrl
    }

}
