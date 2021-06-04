package com.example.firebasedemo.model.getall;

import android.net.Uri;

import java.io.Serializable;

public class MyPost implements Serializable {
    private String name,date,describe;
    private Uri uri;

    public MyPost() {
    }

    public MyPost(String name, String date, String describe, Uri uri) {
        this.name = name;
        this.date = date;
        this.describe = describe;
        this.uri = uri;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public Uri getUri() {
        return uri;
    }

    public void setUri(Uri uri) {
        this.uri = uri;
    }
}
