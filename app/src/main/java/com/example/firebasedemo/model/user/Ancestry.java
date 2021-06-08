package com.example.firebasedemo.model.user;

public class Ancestry {
    private Category type;
    private Category category;
    private Category subcategory;

    public Category getType() {
        return type;
    }

    public void setType(Category type) {
        this.type = type;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Category getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(Category subcategory) {
        this.subcategory = subcategory;
    }
}
