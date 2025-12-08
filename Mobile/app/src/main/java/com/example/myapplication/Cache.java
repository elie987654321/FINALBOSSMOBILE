package com.example.myapplication;

import com.example.myapplication.Model.Commande;
import com.example.myapplication.Model.Compte;

public class Cache
{
    private Compte compte;

    private Commande commande;

    private static Cache instance;

    private Cache()
    {

    }

    public static Cache getInstance()
    {
        if(instance == null)
        {
            instance = new Cache();
        }

        return instance;
    }

    public Compte getCompte() {
        return compte;
    }

    public void setCompte(Compte compte) {
        this.compte = compte;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }
}
