package com.example.myapplication.Model;

public class LigneCommande
{
    private Pizza pizza;
    private int nombrePetites;
    private int nombreMoyennes;
    private int nombreGrandes;


    public LigneCommande(Pizza pizza)
    {
        this.pizza = pizza;
        this.nombrePetites = 0;
        this.nombreMoyennes = 0;
        this.nombreGrandes = 0;
    }

    public Pizza getPizza() {
        return pizza;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }

    public int getNombrePetites() {
        return nombrePetites;
    }

    public void setNombrePetites(int nombrePetites) {
        this.nombrePetites = nombrePetites;
    }

    public int getNombreMoyennes() {
        return nombreMoyennes;
    }

    public void setNombreMoyennes(int nombreMoyennes) {
        this.nombreMoyennes = nombreMoyennes;
    }

    public int getNombreGrandes() {
        return nombreGrandes;
    }

    public void setNombreGrandes(int nombreGrandes) {
        this.nombreGrandes = nombreGrandes;
    }
}
