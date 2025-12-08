package com.example.myapplication.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.myapplication.Model.Commande;
import com.example.myapplication.Model.Pizza;
import com.example.myapplication.R;

import java.util.ArrayList;

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
        return commande.getTabPizza().length;
    }

    @Override
    public Object getItem(int i) {
        return commande.getTabPizza()[i];
    }

    @Override
    public long getItemId(int i) {
        return commande.getTabPizza()[i].getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null)
        {
            view = LayoutInflater.from(context)
                    .inflate(R.layout.item_liste_pizza, viewGroup, false);
        }

        Pizza pizza = commande.getTabPizza()[i];

        ImageView imagePizza = view.findViewById(R.id.itemListePizzaImage);
        TextView textTypePizza = view.findViewById(R.id.itemListePizzaType);
        TextView textSortePizza = view.findViewById(R.id.itemListePizzaSorte);
        TextView textPrixPizza = view.findViewById(R.id.itemListePizzaPrix);
        Spinner spinnerType = view.findViewById(R.id.itemListePizzaSpinnerType);
        Button boutonAjouter = view.findViewById(R.id.itemListePizzaBoutonAjouter);

        imagePizza.setImageDrawable(context.getDrawable(pizza.getImage()));
        textTypePizza.setText(pizza.getType());
        textSortePizza.setText(pizza.getSorte());
        textPrixPizza.setText(pizza.getSorte());

        return  view;
    }

}
