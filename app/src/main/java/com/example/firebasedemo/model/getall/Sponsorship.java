package com.example.firebasedemo.model.getall;

import java.util.List;

public class Sponsorship {
    private List<String> impressionUrls;
    private String tagline;
    private String taglineURL;
    private User sponsor;

    public List<String> getImpressionUrls() { return impressionUrls; }
    public void setImpressionUrls(List<String> value) { this.impressionUrls = value; }

    public String getTagline() { return tagline; }
    public void setTagline(String value) { this.tagline = value; }

    public String getTaglineURL() { return taglineURL; }
    public void setTaglineURL(String value) { this.taglineURL = value; }

    public User getSponsor() { return sponsor; }
    public void setSponsor(User value) { this.sponsor = value; }
}

