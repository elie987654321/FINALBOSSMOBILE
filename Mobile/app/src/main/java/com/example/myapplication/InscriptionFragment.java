package com.example.myapplication;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.codepath.asynchttpclient.AsyncHttpClient;
import com.codepath.asynchttpclient.RequestParams;
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler;
import com.google.gson.Gson;

import org.json.JSONObject;

import okhttp3.Headers;

public class InscriptionFragment extends Fragment
{
    EditText editTextName;
    EditText editTextEmail;
    EditText editTextPassword;
    EditText editTextAddress;

    EditText editTextPhone;

    Button buttonCreateAccount;

    TextView errorTextView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



        return inflater.inflate(R.layout.fragment_inscription, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        editTextName = view.findViewById(R.id.inscriptionFragName);
        editTextEmail = view.findViewById(R.id.inscriptionFragEmail);
        editTextPassword = view.findViewById(R.id.inscriptionFragPassword);
        editTextAddress = view.findViewById(R.id.inscriptionFragAdresse);
        editTextPhone = view.findViewById(R.id.inscriptionFragPhone);

        buttonCreateAccount = view.findViewById(R.id.inscriptionFragButtonCreateAccount);

        errorTextView = view.findViewById(R.id.inscriptionFragErreur);

        buttonCreateAccount.setOnClickListener((buttonView) ->
        {
            if(ValidateInput())
            {
                AsyncHttpClient client = new AsyncHttpClient();
                RequestParams requestParams = new RequestParams();
                requestParams.put("email", editTextEmail.getText().toString());
                requestParams.put("password", editTextPassword.getText().toString());
                requestParams.put("name", editTextName.getText().toString());
                requestParams.put("address", editTextAddress.getText().toString());
                requestParams.put("phone", editTextPhone.getText().toString());

                Compte compte = new Compte();
                compte.email = editTextEmail.getText().toString();
                compte.password = editTextPassword.getText().toString();
                compte.address = editTextAddress.getText().toString();
                compte.phone = editTextPhone.getText().toString();
                compte.name = editTextName.getText().toString();

                Gson gson = new Gson();



                String jsonCompte = gson.toJson(compte);

                client.post("http://10.0.2.2:5062/Compte/CreateCompte", jsonCompte,  new JsonHttpResponseHandler() {
                    @Override
                    public void onSuccess(int statusCode, Headers headers, JSON json) {
                        int t = 0;
                    }

                    @Override
                    public void onFailure(int statusCode, Headers headers, String response, Throwable throwable) {
                        int t = 0;
                    }
                });
            }
        });
    }

    private boolean ValidateInput()
    {
        if(editTextName.getText().length() < 3)
        {
            errorTextView.setText(R.string.veuillez_entrer_un_nom_valide);
            return false;
        }
        else if(editTextEmail.getText().length() < 6)
        {
            errorTextView.setText(R.string.veuillez_entrer_un_email_valide);
            return false;
        }
        else if(editTextPassword.getText().length() < 6)
        {
            errorTextView.setText(R.string.veuillez_entrer_un_mot_de_passe_d_au_moins_6_caracteres);
            return false;
        }
        else if(editTextAddress.getText().length() < 6)
        {
            errorTextView.setText(R.string.veuillez_entrer_une_adresse_valide);
            return false;
        }

        return true;
    }
}