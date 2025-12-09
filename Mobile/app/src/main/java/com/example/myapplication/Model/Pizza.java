package com.example.myapplication.Model;

import com.facebook.stetho.json.annotation.JsonValue;
import com.google.gson.annotations.SerializedName;

public class Pizza
{
    private int id;

    private String sorte;

    private String type;


    @SerializedName("PrixPetite")
    private float prixPetite;

    @SerializedName("PrixMoyenne")
    private float prixMoyenne;

    @SerializedName("PrixGrande")
    private float prixGrande;

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

    public float getPrixPetite() {
        return prixPetite;
    }

    public void setPrixPetite(float prixPetite) {
        this.prixPetite = prixPetite;
    }

    public float getPrixMoyenne() {
        return prixMoyenne;
    }

    public void setPrixMoyenne(float prixMoyenne) {
        this.prixMoyenne = prixMoyenne;
    }

    public float getPrixGrande() {
        return prixGrande;
    }

    public void setPrixGrande(float prixGrande) {
        this.prixGrande = prixGrande;
    }
}
