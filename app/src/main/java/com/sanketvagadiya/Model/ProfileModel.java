package com.sanketvagadiya.Model;

public class ProfileModel {

    String profileName;
    String imageUrl;
    String profileSummary;

    public ProfileModel(String profileName, String imageUrl, String profileSummary) {
        this.profileName = profileName;
        this.imageUrl = imageUrl;
        this.profileSummary = profileSummary;
    }

    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getProfileSummary() {
        return profileSummary;
    }

    public void setProfileSummary(String profileSummary) {
        this.profileSummary = profileSummary;
    }
}
