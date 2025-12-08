package com.example.myapplication.Model;

public class Commande
{
    private PersistantCommande persistantCommande;

    private Pizza[] tabPizza;

    //Les index du tableau de nombre sont les memes que pour la pizza correspondante.
    // Par exemple, tabNombre[2] == 2 signifie qu'on commende deux exemplaire de la la pizza tabPizza[2]
    private int[] tabNombre;

    public Commande(Pizza[] tabPizza)
    {
        this.persistantCommande = new PersistantCommande();
        setTabPizza(tabPizza);
    }

    public PersistantCommande getPersistantCommande() {
        return persistantCommande;
    }

    public Pizza[] getTabPizza() {
        return tabPizza;
    }

    public int[] getTabNombre() {
        return tabNombre;
    }

    public void setPersistantCommande(PersistantCommande persistantCommande) {
        this.persistantCommande = persistantCommande;
    }

    public void setTabPizza(Pizza[] tabPizza) {
        this.tabPizza = tabPizza;

        tabNombre = new int[tabPizza.length];
        for(int i = 0; i < tabNombre.length; i++)
        {
            tabNombre[i] = 0;
        }
    }

}
