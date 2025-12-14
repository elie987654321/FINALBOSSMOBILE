package com.example.myapplication.ActivitiesAndFragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.codepath.asynchttpclient.AbsCallback;
import com.codepath.asynchttpclient.AsyncHttpClient;
import com.codepath.asynchttpclient.RequestHeaders;
import com.codepath.asynchttpclient.RequestParams;
import com.codepath.asynchttpclient.callback.TextHttpResponseHandler;
import com.example.myapplication.Adapters.ItemListeCommandeAdapter;
import com.example.myapplication.Cache;
import com.example.myapplication.Model.Commande;
import com.example.myapplication.Model.LigneCommande;
import com.example.myapplication.Model.LigneCommandeType;
import com.example.myapplication.Model.PizzaTypeEnum;
import com.example.myapplication.R;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.function.Consumer;

import okhttp3.Call;
import okhttp3.Headers;
import okhttp3.Response;

public class VoirCommandeFragment extends Fragment
{
    Commande commande;

    ListView listViewPizzaFragment;

    TextView outputTotal;

    TextView outputEconomie;

    TextView outputTotalAvecPoints;

    Button buttonAddToCart;

    Consumer<Void> consumerUpdateInfos;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_voir_commande, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        commande = Cache.getInstance().getCommande();


        consumerUpdateInfos = (Void) -> { UpdaterInfos(); };

        listViewPizzaFragment = view.findViewById(R.id.mesCommandesFragListView);
        buttonAddToCart = view.findViewById(R.id.mesCommandesFragBoutonCommander);
        outputTotal = view.findViewById(R.id.mesCommandesFragTotal);

        ArrayList<LigneCommandeType> listLigneCommandeType = new ArrayList<LigneCommandeType>();
        LigneCommande[] tabLigneCommandes = Cache.getInstance().getCommande().getTabLigneCommande();

        for(int i = 0; i < tabLigneCommandes.length ; i++)
        {
            LigneCommande ligneCommande = tabLigneCommandes[i];
            if(ligneCommande.getNombrePetites() > 0)
            {
                LigneCommandeType ligneCommandeTypePetite = new LigneCommandeType(ligneCommande, PizzaTypeEnum.Petite);
                ligneCommandeTypePetite.setLigneCommande(ligneCommande);
                ligneCommandeTypePetite.setTypePizza(PizzaTypeEnum.Petite);
                listLigneCommandeType.add(ligneCommandeTypePetite);
            }
            if(ligneCommande.getNombreMoyennes() > 0)
            {
                LigneCommandeType ligneCommandeTypeMoyenne = new LigneCommandeType(ligneCommande, PizzaTypeEnum.Moyenne);
                ligneCommandeTypeMoyenne.setLigneCommande(ligneCommande);
                ligneCommandeTypeMoyenne.setTypePizza(PizzaTypeEnum.Moyenne);
                listLigneCommandeType.add(ligneCommandeTypeMoyenne);
            }
            if (ligneCommande.getNombreGrandes() > 0)
            {
                LigneCommandeType ligneCommandeTypeGrande = new LigneCommandeType(ligneCommande, PizzaTypeEnum.Grande);
                ligneCommandeTypeGrande.setLigneCommande(ligneCommande);
                ligneCommandeTypeGrande.setTypePizza(PizzaTypeEnum.Grande);
                listLigneCommandeType.add(ligneCommandeTypeGrande);
            }
        }

        buttonAddToCart.setOnClickListener((viewButton) ->
            {
                AddToCart();
            }
        );

        ItemListeCommandeAdapter adapter = new ItemListeCommandeAdapter(getContext(), listLigneCommandeType, consumerUpdateInfos);
        listViewPizzaFragment.setAdapter(adapter);

        UpdaterInfos();
    }

    public void UpdaterInfos()
    {
        String stringTotal = String.valueOf(commande.GetTotal());
        outputTotal.setText("Total price :" + stringTotal);
    }

    public void AddToCart()
    {
        AsyncHttpClient client = new AsyncHttpClient();


        RequestParams requestParams = new RequestParams();
        requestParams.put("nomClient", Cache.getInstance().getCompte().name);
        requestParams.put("montant", String.valueOf(Cache.getInstance().getCommande().GetTotal()));
        requestParams.put("date", LocalDateTime.now().toLocalDate().toString());

        client.post("http://10.0.2.2:5062/Commande/AddCommande", new RequestHeaders(), requestParams, "", new AbsCallback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                int t = 0;
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                int t = 0;
            }
        });
    }
}