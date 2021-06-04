package com.example.firebasedemo.model.getall;

public class UserLinks {
    private String self;
    private String html;
    private String photos;
    private String likes;
    private String portfolio;
    private String following;
    private String followers;

    public String getSelf() { return self; }
    public void setSelf(String value) { this.self = value; }

    public String getHTML() { return html; }
    public void setHTML(String value) { this.html = value; }

    public String getPhotos() { return photos; }
    public void setPhotos(String value) { this.photos = value; }

    public String getLikes() { return likes; }
    public void setLikes(String value) { this.likes = value; }

    public String getPortfolio() { return portfolio; }
    public void setPortfolio(String value) { this.portfolio = value; }

    public String getFollowing() { return following; }
    public void setFollowing(String value) { this.following = value; }

    public String getFollowers() { return followers; }
    public void setFollowers(String value) { this.followers = value; }
}
