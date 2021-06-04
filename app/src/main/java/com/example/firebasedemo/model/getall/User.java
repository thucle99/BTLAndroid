package com.example.firebasedemo.model.getall;

import java.time.OffsetDateTime;

public class User {
    private String id;
    private String updated_at;
    private String username;
    private String name;
    private String first_name;
    private String last_name;
    private String twitter_username;
    private String portfolio_url;
    private String bio;
    private String location;
    private UserLinks links;
    private ProfileImage profile_image;
    private String instagram_username;
    private long total_collections;
    private long total_likes;
    private long total_photos;
    private boolean accepted_tos;
    private boolean for_hire;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getTwitter_username() {
        return twitter_username;
    }

    public void setTwitter_username(String twitter_username) {
        this.twitter_username = twitter_username;
    }

    public String getPortfolio_url() {
        return portfolio_url;
    }

    public void setPortfolio_url(String portfolio_url) {
        this.portfolio_url = portfolio_url;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public UserLinks getLinks() {
        return links;
    }

    public void setLinks(UserLinks links) {
        this.links = links;
    }

    public ProfileImage getProfile_image() {
        return profile_image;
    }

    public void setProfile_image(ProfileImage profile_image) {
        this.profile_image = profile_image;
    }

    public String getInstagram_username() {
        return instagram_username;
    }

    public void setInstagram_username(String instagram_username) {
        this.instagram_username = instagram_username;
    }

    public long getTotal_collections() {
        return total_collections;
    }

    public void setTotal_collections(long total_collections) {
        this.total_collections = total_collections;
    }

    public long getTotal_likes() {
        return total_likes;
    }

    public void setTotal_likes(long total_likes) {
        this.total_likes = total_likes;
    }

    public long getTotal_photos() {
        return total_photos;
    }

    public void setTotal_photos(long total_photos) {
        this.total_photos = total_photos;
    }

    public boolean isAccepted_tos() {
        return accepted_tos;
    }

    public void setAccepted_tos(boolean accepted_tos) {
        this.accepted_tos = accepted_tos;
    }

    public boolean isFor_hire() {
        return for_hire;
    }

    public void setFor_hire(boolean for_hire) {
        this.for_hire = for_hire;
    }
}

