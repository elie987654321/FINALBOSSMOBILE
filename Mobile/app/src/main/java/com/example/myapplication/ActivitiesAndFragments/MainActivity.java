package com.example.myapplication.ActivitiesAndFragments;

import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;


import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.example.myapplication.Model.Compte;
import com.example.myapplication.R;
import com.google.android.material.navigation.NavigationView;


public class MainActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;

    NavigationView navigationView;


    Compte compte;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.mainDrwayerLayout);
        navigationView = findViewById(R.id.mainNavigationView);

        MainFragment mainFragment = new MainFragment();

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(Gravity.LEFT);
            }
        });

        navigationView.setNavigationItemSelectedListener((view) ->
               {
                        Fragment fragment ;

                        if(view.getItemId() == R.id.menuItemHome)
                        {
                            fragment = mainFragment;
                        }

                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.mainFrame, mainFragment)
                                .commit();

                        return true;
                    }

        );

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.mainFrame, mainFragment)
                .commit();
    }
}