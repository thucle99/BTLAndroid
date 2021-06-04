package com.example.firebasedemo.model.getall;

import java.time.OffsetDateTime;
import java.util.List;

public class Welcome {
    private String id;
    private String created_at;
    private String updated_at;
    private String promoted_at;
    private long width;
    private long height;
    private String color;
    private String blur_hash;
    private String description;
    private String alt_description;
    private Urls urls;
    private WelcomeLinks links;
    private List<Object> categories;
    private long likes;
    private boolean liked_by_user;
    private List<Object> current_user_collections;
    private Sponsorship sponsorship;
    private User user;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public String getPromoted_at() {
        return promoted_at;
    }

    public void setPromoted_at(String promoted_at) {
        this.promoted_at = promoted_at;
    }

    public long getWidth() {
        return width;
    }

    public void setWidth(long width) {
        this.width = width;
    }

    public long getHeight() {
        return height;
    }

    public void setHeight(long height) {
        this.height = height;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBlur_hash() {
        return blur_hash;
    }

    public void setBlur_hash(String blur_hash) {
        this.blur_hash = blur_hash;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAlt_description() {
        return alt_description;
    }

    public void setAlt_description(String alt_description) {
        this.alt_description = alt_description;
    }

    public Urls getUrls() {
        return urls;
    }

    public void setUrls(Urls urls) {
        this.urls = urls;
    }

    public WelcomeLinks getLinks() {
        return links;
    }

    public void setLinks(WelcomeLinks links) {
        this.links = links;
    }

    public List<Object> getCategories() {
        return categories;
    }

    public void setCategories(List<Object> categories) {
        this.categories = categories;
    }

    public long getLikes() {
        return likes;
    }

    public void setLikes(long likes) {
        this.likes = likes;
    }

    public boolean isLiked_by_user() {
        return liked_by_user;
    }

    public void setLiked_by_user(boolean liked_by_user) {
        this.liked_by_user = liked_by_user;
    }

    public List<Object> getCurrent_user_collections() {
        return current_user_collections;
    }

    public void setCurrent_user_collections(List<Object> current_user_collections) {
        this.current_user_collections = current_user_collections;
    }

    public Sponsorship getSponsorship() {
        return sponsorship;
    }

    public void setSponsorship(Sponsorship sponsorship) {
        this.sponsorship = sponsorship;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}