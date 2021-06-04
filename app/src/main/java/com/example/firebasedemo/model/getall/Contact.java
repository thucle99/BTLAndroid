package com.example.firebasedemo.model.getall;

import java.io.Serializable;

public class Contact implements Serializable {
    private String name,phone,email,date,address,key;

    public Contact() {
    }

    public Contact(String name, String phone, String email, String dateOfBirth, String address) {

    }
    public Contact(String name, String phone, String email, String date, String address, String key) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.date = date;
        this.address = address;
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}

