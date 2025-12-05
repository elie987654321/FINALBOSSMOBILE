package com.example.myapplication;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class MainFragment extends Fragment {

    Button boutonConnexion;
    Button boutonInscription;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        boutonInscription = view.findViewById(R.id.mainFragBoutonInscription);
        boutonConnexion = view.findViewById(R.id.mainFragBoutonConnexion);

        boutonInscription.setOnClickListener((buttonView) -> {
            InscriptionFragment inscriptionFragment = new InscriptionFragment();

            getParentFragmentManager()
                    .beginTransaction()
                    .replace(R.id.mainFrame, inscriptionFragment)
                    .commit();
        } );
    }
}