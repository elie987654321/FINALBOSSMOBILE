package com.example.myapplication.ActivitiesAndFragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import com.codepath.asynchttpclient.AsyncHttpClient;
import com.codepath.asynchttpclient.RequestParams;
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler;
import com.example.myapplication.Model.Commande;
import com.example.myapplication.Model.Compte;
import com.example.myapplication.R;
import com.google.gson.Gson;

import okhttp3.Headers;

public class MainFragment extends Fragment {
    ImageView imageViewLogo;

    Button boutonConnexion;
    Button boutonInscription;

    Animation animZoomIn;
    Animation animZoomOut;

    Animation animBigZoomIn;
    Animation animBigZoomOut;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        boutonConnexion = view.findViewById(R.id.mainFragBoutonConnexion);
        boutonInscription = view.findViewById(R.id.mainFragBoutonInscription);

        animZoomIn = AnimationUtils.loadAnimation(getContext(), R.anim.zoom_in);
        animZoomOut = AnimationUtils.loadAnimation(getContext(), R.anim.zoom_out);

        animBigZoomIn = AnimationUtils.loadAnimation(getContext(), R.anim.big_zoom_in);
        animBigZoomOut = AnimationUtils.loadAnimation(getContext(), R.anim.big_zoom_out);

        imageViewLogo = view.findViewById(R.id.mainFragBannerLogo);

        boutonInscription.startAnimation(animZoomIn);

        imageViewLogo.setOnClickListener((viewLogo) ->
            {
                imageViewLogo.startAnimation(animBigZoomIn);
            }
        );

        animZoomIn.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                        boutonInscription.startAnimation(animZoomOut);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        animBigZoomIn.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                imageViewLogo.startAnimation(animBigZoomOut);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });


        boutonConnexion.setOnClickListener((buttonView) ->
        {
            ConnexionFragment connexionFragment = new ConnexionFragment();

            getParentFragmentManager()
                    .beginTransaction()
                    .replace(R.id.mainFrame, connexionFragment)
                    .commit();
        });

        boutonInscription.setOnClickListener((buttonView) -> {
            InscriptionFragment inscriptionFragment = new InscriptionFragment();

            getParentFragmentManager()
                    .beginTransaction()
                    .replace(R.id.mainFrame, inscriptionFragment)
                    .commit();
        } );
    }
}