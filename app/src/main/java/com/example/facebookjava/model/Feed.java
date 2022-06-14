package com.example.facebookjava.model;

import java.util.ArrayList;

/**
 * Created by Eldor Turgunov on 14.06.2022.
 * Facebook java
 * eldorturgunov777@gmail.com
 */
public class Feed {
    Boolean isHeader = false;
    Post post = null;
    ArrayList<Story> stories =new ArrayList<Story>();

    public Feed(Boolean isHeader) {
        this.isHeader = true;
    }

    public Feed(Boolean isHeader, Post post) {
        this.isHeader = false;
        this.post = post;
    }

    public Feed(Boolean isHeader, ArrayList<Story> stories) {
        this.isHeader = false;
        this.stories = stories;
    }

    public Boolean getHeader() {
        return isHeader;
    }

    public void setHeader(Boolean header) {
        isHeader = header;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public ArrayList<Story> getStories() {
        return stories;
    }

    public void setStories(ArrayList<Story> stories) {
        this.stories = stories;
    }
}
