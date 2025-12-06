package com.example.myapplication;

import com.google.gson.annotations.SerializedName;

public class Compte
{
    @SerializedName("Id")
    public int id;
    @SerializedName("Email")
    public String email;
    @SerializedName("Password")
    public String password;
    @SerializedName("Name")
    public String name;
    @SerializedName("Address")
    public String address;
    @SerializedName("Phone")
    public String phone;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
