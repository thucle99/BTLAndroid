package com.example.firebasedemo.model.user;

public class Aggregated {
    private String type;
    private String title;
    private AggregatedSource source;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public AggregatedSource getSource() {
        return source;
    }

    public void setSource(AggregatedSource source) {
        this.source = source;
    }
}
