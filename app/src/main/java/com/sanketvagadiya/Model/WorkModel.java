package com.sanketvagadiya.Model;

public class WorkModel {

    String roleName, companyName, companyLocation, joinFrom, joinTo, jobResponsibilities;
    String imageUrl;



    public WorkModel(String roleName, String companyName, String companyLocation, String joinFrom, String joinTo, String jobResponsibilities, String imageUrl) {
        this.roleName = roleName;
        this.companyName = companyName;
        this.companyLocation = companyLocation;
        this.joinFrom = joinFrom;
        this.joinTo = joinTo;
        this.jobResponsibilities = jobResponsibilities;
        this.imageUrl = imageUrl;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyLocation() {
        return companyLocation;
    }

    public void setCompanyLocation(String companyLocation) {
        this.companyLocation = companyLocation;
    }

    public String getJoinFrom() {
        return joinFrom;
    }

    public void setJoinFrom(String joinFrom) {
        this.joinFrom = joinFrom;
    }

    public String getJoinTo() {
        return joinTo;
    }

    public void setJoinTo(String joinTo) {
        this.joinTo = joinTo;
    }

    public String getJobResponsibilities() {
        return jobResponsibilities;
    }

    public void setJobResponsibilities(String jobResponsibilities) {
        this.jobResponsibilities = jobResponsibilities;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
