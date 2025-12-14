package com.example.myapplication.Model;

//Class cree parse qu'il faut donner un array que quelque chose en parametres aux adapteurs
public class LigneCommandeType
{
    private LigneCommande ligneCommande;
    private PizzaTypeEnum typePizza;

    public LigneCommandeType(LigneCommande ligneCommande, PizzaTypeEnum typePizza)
    {
        this.ligneCommande = ligneCommande;
        this.typePizza = typePizza;
    }

    public LigneCommande getLigneCommande() {
        return ligneCommande;
    }

    public void setLigneCommande(LigneCommande ligneCommande) {
        this.ligneCommande = ligneCommande;
    }

    public PizzaTypeEnum getTypePizza() {
        return typePizza;
    }

    public void setTypePizza(PizzaTypeEnum typePizza) {
        this.typePizza = typePizza;
    }
}
