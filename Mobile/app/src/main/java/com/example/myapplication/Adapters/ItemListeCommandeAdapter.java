package com.example.myapplication.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.Model.LigneCommande;
import com.example.myapplication.Model.LigneCommandeType;
import com.example.myapplication.Model.Pizza;
import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.function.Consumer;

public class ItemListeCommandeAdapter extends BaseAdapter
{
    Context context;
    ArrayList<LigneCommandeType> listLigneCommandeType ;
    Consumer<Void> callbackUpdateInfos;

    public ItemListeCommandeAdapter(Context context, ArrayList<LigneCommandeType> listLigneCommandeType, Consumer<Void> callbackUpdateInfos)
    {
        this.context = context;
        this.listLigneCommandeType = listLigneCommandeType;
        this.callbackUpdateInfos = callbackUpdateInfos;
    }

    @Override
    public int getCount() {
        return listLigneCommandeType.size();
    }

    @Override
    public Object getItem(int i) {
        return listLigneCommandeType.get(i);
    }

    @Override
    public long getItemId(int i) {
        return -1;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = LayoutInflater.from(context)
                .inflate(R.layout.item_liste_voire_commande, viewGroup, false);

        LigneCommandeType ligneCommandeType = (LigneCommandeType) getItem(i);
        LigneCommande ligneCommande = ligneCommandeType.getLigneCommande();
        Pizza pizza = ligneCommande.getPizza();

        float prixUnitaire = 0;
        int nombrePizza = 0;
        String stringType = "";

        switch (ligneCommandeType.getTypePizza())
        {
            case Petite:
                prixUnitaire = pizza.getPrixPetite();
                nombrePizza  = ligneCommande.getNombrePetites();
                stringType   = "Petite";
                break;
            case Moyenne:
                prixUnitaire = pizza.getPrixMoyenne();
                nombrePizza = ligneCommande.getNombreMoyennes();
                stringType = "Moyenne";
                break;
            case Grande:
                prixUnitaire = pizza.getPrixGrande();
                nombrePizza = ligneCommande.getNombreGrandes();
                stringType = "Grande";
                break;
        }

        ImageView imagePizza = view.findViewById(R.id.itemCommandeImagePizza);
        TextView sorteTypeText = view.findViewById(R.id.itemCommandeSorteEtType);
        TextView prixUnitaireText = view.findViewById(R.id.itemCommandePrixUnitaire);
        TextView prixTotalText = view.findViewById(R.id.itemCommandePrixTotal);
        TextView nombrePizzaText = view.findViewById(R.id.itemCommandeNombre);
        Button boutonAjouter = view.findViewById(R.id.itemCommandeBoutonPlus);
        Button boutonEnlever = view.findViewById(R.id.itemCommandeBoutonMoins);

        imagePizza.setImageResource(ligneCommandeType.getLigneCommande().getPizza().getImage());

        prixUnitaireText.setText("Price :" + prixUnitaire);
        prixTotalText.setText("Total : " + (prixUnitaire * nombrePizza));
        sorteTypeText.setText(pizza.getSorte().toUpperCase() + " " + stringType.toUpperCase());
        nombrePizzaText.setText(String.valueOf(nombrePizza));

        boutonAjouter.setOnClickListener((viewButton) ->
        {
            switch(ligneCommandeType.getTypePizza())
            {
                case Petite:
                    ligneCommande.setNombrePetites(ligneCommande.getNombrePetites() + 1);
                    nombrePizzaText.setText(String.valueOf(ligneCommande.getNombrePetites()));
                    prixTotalText.setText("Total : " + (pizza.getPrixPetite() * ligneCommande.getNombrePetites()));
                    break;
                case Moyenne:
                    ligneCommande.setNombreMoyennes(ligneCommande.getNombreMoyennes() + 1);
                    nombrePizzaText.setText(String.valueOf(ligneCommande.getNombreMoyennes()));
                    prixTotalText.setText("Total : " + (pizza.getPrixMoyenne() * ligneCommande.getNombreMoyennes()));
                    break;
                case Grande:
                    ligneCommande.setNombreGrandes(ligneCommande.getNombreGrandes() + 1);
                    nombrePizzaText.setText(String.valueOf(ligneCommande.getNombreGrandes()));
                    prixTotalText.setText("Total : " + (pizza.getPrixGrande() * ligneCommande.getNombreGrandes()));
                    break;
            }
            callbackUpdateInfos.accept(null);
        });

        boutonEnlever.setOnClickListener((viewButton) ->
        {
            switch(ligneCommandeType.getTypePizza())
            {
                case Petite:
                    ligneCommande.setNombrePetites(ligneCommande.getNombrePetites() - 1);
                    nombrePizzaText.setText(String.valueOf(ligneCommande.getNombrePetites()));
                    prixTotalText.setText("Total : " + (pizza.getPrixPetite() * ligneCommande.getNombrePetites()));
                    break;
                case Moyenne:
                    ligneCommande.setNombreMoyennes(ligneCommande.getNombreMoyennes() - 1);
                    nombrePizzaText.setText(String.valueOf(ligneCommande.getNombreMoyennes()));
                    prixTotalText.setText("Total : " + (pizza.getPrixMoyenne() * ligneCommande.getNombreMoyennes()));
                    break;
                case Grande:
                    ligneCommande.setNombreGrandes(ligneCommande.getNombreGrandes() - 1);
                    nombrePizzaText.setText(String.valueOf(ligneCommande.getNombreGrandes()));
                    prixTotalText.setText("Total : " + (pizza.getPrixGrande() * ligneCommande.getNombreGrandes()));
                    break;
            }
            callbackUpdateInfos.accept(null);
        });

        return view;
    }
}
