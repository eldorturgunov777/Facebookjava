package com.example.facebookjava.model;

/**
 * Created by Eldor Turgunov on 14.06.2022.
 * Facebook java
 * eldorturgunov777@gmail.com
 */
public class Post {
    int profile;
    String fullname;
    int photo;

    public Post(int profile, String fullname, int photo) {
        this.profile = profile;
        this.fullname = fullname;
        this.photo = photo;
    }

    public int getProfile() {
        return profile;
    }

    public void setProfile(int profile) {
        this.profile = profile;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }
}
