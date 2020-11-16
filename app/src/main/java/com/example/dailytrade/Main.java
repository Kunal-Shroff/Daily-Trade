package com.example.dailytrade;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

import com.google.android.material.bottomnavigation.BottomNavigationView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Main extends Fragment {


    public Main() {
        // Required empty public constructor
    }

public TextView pclose,wavg,buy,sell;
    public ImageView buyi,selli,wavgi,prevcloi;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

          View view =  inflater.inflate(R.layout.fragment_main, container, false);
        BottomNavigationView bottom = view.findViewById(R.id.bottom_nav);

        bottom.setOnNavigationItemSelectedListener(mainobj);


       buyi = view.findViewById(R.id.buyimage);
        buyi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.frame, new Buy());
                fragmentTransaction.commit();
                fragmentTransaction.addToBackStack(null);
            }
        });

        wavgi = view.findViewById(R.id.wavgimage);
        wavgi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.frame, new WAvg());
                fragmentTransaction.commit();
                fragmentTransaction.addToBackStack(null);
            }
        });

        prevcloi = view.findViewById(R.id.previousclose);
        prevcloi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.frame, new PrevCL());
                fragmentTransaction.commit();
                fragmentTransaction.addToBackStack(null);
            }
        });

        selli = view.findViewById(R.id.imageView3);
        selli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.frame, new Sell());
                fragmentTransaction.commit();
                fragmentTransaction.addToBackStack(null);
            }
        });

          return view;
    }
    private BottomNavigationView.OnNavigationItemSelectedListener mainobj = new
            BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {




                    Fragment selectedfragment = null;

                    switch (menuItem.getItemId()){

                        case R.id.Main:
                            selectedfragment = new Main();
                            break;

                        case R.id.All:
                            selectedfragment = new Allout();
                            break;

                        case R.id.tips:
                            selectedfragment = new Tip();
                            break;


                    }

                    getFragmentManager().beginTransaction().replace(R.id.mainfrag,selectedfragment).addToBackStack(null).commit();
                    return true;
                }
            };


}
