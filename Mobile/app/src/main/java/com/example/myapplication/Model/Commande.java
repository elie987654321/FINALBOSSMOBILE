package com.example.myapplication.Model;

public class Commande
{
    private PersistantCommande persistantCommande;

    private LigneCommande[] tabLigneCommande;

    public Commande(Pizza[] tabPizza)
    {
        this.persistantCommande = new PersistantCommande();

        tabLigneCommande = new LigneCommande[tabPizza.length];

        for(int i = 0; i < tabLigneCommande.length; i++)
        {
            tabLigneCommande[i] = new LigneCommande(tabPizza[i]);
        }
    }

    public PersistantCommande getPersistantCommande() {
        return persistantCommande;
    }

    public LigneCommande[] getTabLigneCommande() {
        return tabLigneCommande;
    }

    public void setTabLigneCommande(LigneCommande[] tabLigneCommande) {
        this.tabLigneCommande = tabLigneCommande;
    }

    public float GetTotal()
    {
        float total = 0;

        for(int i = 0 ; i < tabLigneCommande.length; i++)
        {
            LigneCommande ligneCommande = tabLigneCommande[i];
            total += ligneCommande.getNombrePetites() * ligneCommande.getPizza().getPrixPetite();
            total += ligneCommande.getNombreMoyennes() * ligneCommande.getPizza().getPrixMoyenne();
            total += ligneCommande.getNombreGrandes() * ligneCommande.getPizza().getPrixGrande();
        }

        return total;
    }
}
