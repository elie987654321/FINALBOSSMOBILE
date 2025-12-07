package com.example.myapplication.ActivitiesAndFragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myapplication.Cache;
import com.example.myapplication.Model.Compte;

public class ListePizzaFragment extends Fragment
{
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        Compte compte = Cache.getInstance().getCompte();

        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
