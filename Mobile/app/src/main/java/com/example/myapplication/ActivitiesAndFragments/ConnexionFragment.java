package com.example.myapplication.ActivitiesAndFragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.codepath.asynchttpclient.AsyncHttpClient;
import com.codepath.asynchttpclient.RequestParams;
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler;
import com.example.myapplication.Cache;
import com.example.myapplication.Model.Compte;
import com.example.myapplication.R;
import com.google.gson.Gson;

import okhttp3.Headers;

public class ConnexionFragment extends Fragment
{
    AsyncHttpClient client;

    EditText editTextEmail;
    EditText editTextPassword;
    Button boutonConnexion;
    Button boutonGoToInscription;
    TextView errorText;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_connexion, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        client = new AsyncHttpClient();

        editTextEmail = view.findViewById(R.id.connexionFragEmail);
        editTextPassword = view.findViewById(R.id.connexionFragPassword);
        boutonConnexion = view.findViewById(R.id.connexionFragButtonConnect);
        boutonGoToInscription = view.findViewById(R.id.connexionFragButtonCreerCompte);
        errorText = view.findViewById(R.id.connexionFragErrorText);

        boutonConnexion.setOnClickListener((viewButton) ->
        {
            Connect();
        });

        boutonGoToInscription.setOnClickListener((viewButton) ->
        {
            GoToInscription();
        });
    }

    private boolean ValidateInput()
    {
        if(editTextEmail.getText().length() < 3)
        {
            errorText.setText("Veuillez entrer un email valide");
            return false;
        }
        else if(editTextPassword.getText().length() == 0)
        {
            errorText.setText("Veuillez entrer un mot de passe");
            return false;
        }

        return true;
    }

    protected void Connect()
    {
        if(ValidateInput())
        {
            String email = editTextEmail.getText().toString();
            String password = editTextPassword.getText().toString();

            RequestParams params = new RequestParams();
            params.put("email", email);
            params.put("password",password);
            client.get("http://10.0.2.2:5062/Compte/GetCompteByEmailAndPassword", params, new JsonHttpResponseHandler() {
                @Override
                public void onSuccess(int statusCode, Headers headers, JSON json) {
                    String jsonObjectString =  json.jsonObject.toString();
                    Compte compte = new Gson().fromJson(jsonObjectString, Compte.class);
                    Cache.getInstance().setCompte(compte);

                    ListePizzaFragment fragment = new ListePizzaFragment();

                    MainActivity mainActivity = (MainActivity) getActivity();
                    mainActivity.AddMenuItems();

                    getParentFragmentManager()
                            .beginTransaction()
                            .replace(R.id.mainFrame, fragment)
                            .commit();
                }

                @Override
                public void onFailure(int statusCode, Headers headers, String response, Throwable throwable) {
                    errorText.setText("Courriel ou mot de passe invalide");
                }
            });
        }


    }

    protected void GoToInscription()
    {
        InscriptionFragment inscriptionFragment = new InscriptionFragment();
        getParentFragmentManager()
                .beginTransaction()
                .replace(R.id.mainFrame, inscriptionFragment)
                .commit();
    }
}