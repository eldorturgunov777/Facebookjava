package com.example.facebookjava.model;

/**
 * Created by Eldor Turgunov on 14.06.2022.
 * Facebook java
 * eldorturgunov777@gmail.com
 */
public class Story {
    int profile;
    String fullname;

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

    public Story(int profile, String fullname) {
        this.profile = profile;
        this.fullname = fullname;
    }
}
