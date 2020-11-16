package com.example.dailytrade;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Tip extends Fragment {


    public Tip() {
        // Required empty public constructor
    }
    public EditText pclose;
    private TextView firstbuy, secondbuy, thirdbuy, firstsell, secondsell, thirdsell;
    private Button s1,  s2 ;
    private float buy1, buy2,fb ,sb,tb,fs,ss,ts;
    public float prevalue;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_tip, container, false);




        return view;
    }

}
