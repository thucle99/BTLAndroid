package com.example.firebasedemo.model.user;

import java.util.List;

public class FluffyCoverPhoto {
    private String id;
    private String created_at;
    private String updated_at;
    private String promoted_at;
    private Long width;
    private Long height;
    private String color;
    private String blur_hash;
    private String description;
    private String alt_description;
    private Urls urls;
    private CoverPhotoLinks links;
    private List<Object> categories;
    private Long likes;
    private Boolean liked_by_user;
    private List<Object> current_user_collections;
    private Object sponsorship;
    private FluffyUser user;

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

    public Long getWidth() {
        return width;
    }

    public void setWidth(Long width) {
        this.width = width;
    }

    public Long getHeight() {
        return height;
    }

    public void setHeight(Long height) {
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

    public CoverPhotoLinks getLinks() {
        return links;
    }

    public void setLinks(CoverPhotoLinks links) {
        this.links = links;
    }

    public List<Object> getCategories() {
        return categories;
    }

    public void setCategories(List<Object> categories) {
        this.categories = categories;
    }

    public Long getLikes() {
        return likes;
    }

    public void setLikes(Long likes) {
        this.likes = likes;
    }

    public Boolean getLiked_by_user() {
        return liked_by_user;
    }

    public void setLiked_by_user(Boolean liked_by_user) {
        this.liked_by_user = liked_by_user;
    }

    public List<Object> getCurrent_user_collections() {
        return current_user_collections;
    }

    public void setCurrent_user_collections(List<Object> current_user_collections) {
        this.current_user_collections = current_user_collections;
    }

    public Object getSponsorship() {
        return sponsorship;
    }

    public void setSponsorship(Object sponsorship) {
        this.sponsorship = sponsorship;
    }

    public FluffyUser getUser() {
        return user;
    }

    public void setUser(FluffyUser user) {
        this.user = user;
    }
}
