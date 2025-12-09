package com.example.myapplication.Model;

public class Commande
{
    private PersistantCommande persistantCommande;

    //Les index du tableau de nombre sont les memes que pour la pizza correspondante.
    // Par exemple, tabNombre[2] == 2 signifie qu'on commende deux exemplaire de la la pizza tabPizza[2]

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
}
