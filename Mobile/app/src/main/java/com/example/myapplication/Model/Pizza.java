package com.example.myapplication.Model;

import com.facebook.stetho.json.annotation.JsonValue;
import com.google.gson.annotations.SerializedName;

public class Pizza
{
    private int id;

    private String sorte;

    private String type;

    @SerializedName("idImage")
    private int image;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSorte() {
        return sorte;
    }

    public void setSorte(String sorte) {
        this.sorte = sorte;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
