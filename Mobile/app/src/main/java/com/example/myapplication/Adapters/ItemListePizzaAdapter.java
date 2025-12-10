package com.example.myapplication.Adapters;

import static android.widget.Toast.LENGTH_LONG;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import com.example.myapplication.Model.Commande;
import com.example.myapplication.Model.LigneCommande;
import com.example.myapplication.Model.Pizza;
import com.example.myapplication.R;

public class ItemListePizzaAdapter extends BaseAdapter
{
    private Context context;
    private Commande commande;

    public ItemListePizzaAdapter(Context context, Commande commande)
    {
        this.context = context;
        this.commande = commande;
    }

    @Override
    public int getCount() {
        return commande.getTabLigneCommande().length;
    }

    @Override
    public Object getItem(int i) {
        return commande.getTabLigneCommande()[i];
    }

    @Override
    public long getItemId(int i) {
        return commande.getTabLigneCommande()[i].getPizza().getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null)
        {
            view = LayoutInflater.from(context)
                    .inflate(R.layout.item_liste_pizza, viewGroup, false);
        }

        Pizza pizza = commande.getTabLigneCommande()[i].getPizza();

        ImageView imagePizza = view.findViewById(R.id.itemListePizzaImage);
        TextView textSortePizza = view.findViewById(R.id.itemListePizzaSorte);
        TextView textPrixPizza = view.findViewById(R.id.itemListePizzaPrix);
        Spinner spinnerType = view.findViewById(R.id.itemListePizzaSpinnerType);
        Button boutonAjouter = view.findViewById(R.id.itemListePizzaBoutonAjouter);

        imagePizza.setImageDrawable(context.getDrawable(pizza.getImage()));
        textSortePizza.setText(pizza.getSorte());
        textPrixPizza.setText(pizza.getSorte());

        String[] tabTypes = { "petite", "moyenne", "grande" };
        ArrayAdapter<String> adapter = new ArrayAdapter<>(context, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, tabTypes);

        spinnerType.setAdapter(adapter);

        spinnerType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                  @Override
                  public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                      switch (spinnerType.getSelectedItemPosition())
                      {
                          case 0:
                              textPrixPizza.setText(String.valueOf(pizza.getPrixPetite()) + "$");
                              break;
                          case 1:
                              textPrixPizza.setText(String.valueOf(pizza.getPrixMoyenne()) + "$");
                              break;
                          case 2:
                              textPrixPizza.setText(String.valueOf(pizza.getPrixGrande()) + "$");
                              break;
                          default:
                              break;
                      }
                  }

                  @Override
                  public void onNothingSelected(AdapterView<?> adapterView) {

                  }
              }
        );

        boutonAjouter.setOnClickListener((buttonView) ->
        {
            LigneCommande ligneCommande = commande.getTabLigneCommande()[i];

            switch (spinnerType.getSelectedItemPosition())
            {
                case 0:
                    ligneCommande.setNombrePetites(ligneCommande.getNombrePetites() + 1) ;
                    Toast.makeText(context, "Petite " + pizza.getSorte() + " commander", LENGTH_LONG).show();
                break;
                case 1:
                    ligneCommande.setNombreMoyennes(ligneCommande.getNombreMoyennes() + 1);
                    Toast.makeText(context, "Moyenne " + pizza.getSorte() + " commander", LENGTH_LONG).show();
                    break;
                case 2:
                    ligneCommande.setNombreGrandes(ligneCommande.getNombreGrandes() + 1);
                    Toast.makeText(context, "Grande " + pizza.getSorte() + " commander", LENGTH_LONG).show();
                    break;
                default:
                    break;
            }
        });
        return  view;
    }

}
