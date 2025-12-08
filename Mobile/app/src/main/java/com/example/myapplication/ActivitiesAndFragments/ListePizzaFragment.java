package com.example.myapplication.ActivitiesAndFragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.codepath.asynchttpclient.AsyncHttpClient;
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler;
import com.example.myapplication.Adapters.ItemListePizzaAdapter;
import com.example.myapplication.Cache;
import com.example.myapplication.Model.Commande;
import com.example.myapplication.Model.Compte;
import com.example.myapplication.Model.Pizza;
import com.example.myapplication.R;
import com.google.gson.Gson;
import com.google.gson.JsonArray;

import okhttp3.Headers;

public class ListePizzaFragment extends Fragment
{
    ListView listViewCommandesPizza;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_liste_pizza,container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        listViewCommandesPizza = view.findViewById(R.id.listePizzaFragListView);

        AsyncHttpClient client = new AsyncHttpClient();

        client.get("http://10.0.2.2:5062/Pizza/GetAll", new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Headers headers, JSON json) {
                Gson gson = new Gson();
                String jsonString = json.jsonArray.toString();
                Pizza[] tabPizza = gson.fromJson(jsonString, Pizza[].class);

                Cache.getInstance().setCommande(new Commande(tabPizza));

                ItemListePizzaAdapter adapter = new ItemListePizzaAdapter(getContext(), Cache.getInstance().getCommande());
                listViewCommandesPizza.setAdapter(adapter);
            }

            @Override
            public void onFailure(int statusCode, Headers headers, String response, Throwable throwable) {

            }
        });

    }
}
