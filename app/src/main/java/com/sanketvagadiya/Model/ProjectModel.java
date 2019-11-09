package com.sanketvagadiya.Model;


public class ProjectModel {
    String projectName;
    String imageUrl;
    String projectUrl;

    public ProjectModel(String projectName, String imageUrl, String projectUrl) {
        this.projectName = projectName;
        this.imageUrl = imageUrl;
        this.projectUrl = projectUrl;
    }

    public String getProjectUrl() {
        return projectUrl;
    }

    public String getProjectName() {
        return projectName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

}
