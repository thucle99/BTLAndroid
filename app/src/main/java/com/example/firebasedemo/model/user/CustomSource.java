package com.example.firebasedemo.model.user;

public class CustomSource {
    private Ancestry ancestry;
    private String title;
    private String subtitle;
    private String description;
    private String meta_title;
    private String meta_description;
    private FluffyCoverPhoto cover_photo;

    public Ancestry getAncestry() {
        return ancestry;
    }

    public void setAncestry(Ancestry ancestry) {
        this.ancestry = ancestry;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMeta_title() {
        return meta_title;
    }

    public void setMeta_title(String meta_title) {
        this.meta_title = meta_title;
    }

    public String getMeta_description() {
        return meta_description;
    }

    public void setMeta_description(String meta_description) {
        this.meta_description = meta_description;
    }

    public FluffyCoverPhoto getCover_photo() {
        return cover_photo;
    }

    public void setCover_photo(FluffyCoverPhoto cover_photo) {
        this.cover_photo = cover_photo;
    }
}
