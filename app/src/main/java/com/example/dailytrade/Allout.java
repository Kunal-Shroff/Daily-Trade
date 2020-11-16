package com.example.dailytrade;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.text.DecimalFormat;


/**
 * A simple {@link Fragment} subclass.
 */
public class Allout extends Fragment {


    public Allout() {
        // Required empty public constructor
    }
    private Button btcheck, btshow,btclear,btclearshow;
    private EditText e1, e2, e3;
    private TextView t1, t2;

    private float dividee1;
    private float a;
    private float b;
    private float c;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_allout, container, false);




        btcheck = view.findViewById(R.id.check1);
        btshow = view.findViewById(R.id.show1);
        btclear = view.findViewById(R.id.clear1);
        btclearshow = view.findViewById(R.id.clear2);

        e1 = view.findViewById(R.id.amounte1);
        e2 = view.findViewById(R.id.sharese1);
        t1 = view.findViewById(R.id.buye1);

        e3 = view.findViewById(R.id.currentratee1);
        t2 = view.findViewById(R.id.currentamount);

            btcheck.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {



                    a = Integer.parseInt(e1.getText().toString());
                    b = Integer.parseInt(e2.getText().toString());

                    dividee1 = a / b;

                    t1.setText("" + new DecimalFormat("##.##").format(dividee1) );



                }
            });

        btshow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                c = Float.parseFloat(e3.getText().toString());

                float avgbuy = c-dividee1;


                float currate = (b*avgbuy);

                if (currate > 0) {


                    t2.setText("Your Profit is " + new DecimalFormat("##.##").format(currate) );
                }

                if (currate < 0) {


                    t2.setText("Your loss is " + new DecimalFormat("##.##").format(currate));
                }


            }
        });

        btclear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                e1.setText("");
                e2.setText("");
                t1.setText("");


            }
        });

        btclearshow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                e3.setText("");

                t2.setText("");

            }
        });


        e1.addTextChangedListener(login);
        e2.addTextChangedListener(login);
        e3.addTextChangedListener(login1);



        return view;
    }
    private TextWatcher login = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String amount = e1.getText().toString().trim();
            String  shares = e2.getText().toString().trim();

            btcheck.setEnabled(!amount.isEmpty() && !shares.isEmpty());
            btclear.setEnabled(!amount.isEmpty() && !shares.isEmpty());
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    private TextWatcher login1 = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String camount = e3.getText().toString().trim();

            btshow.setEnabled(!camount.isEmpty());
            btclearshow.setEnabled(!camount.isEmpty());
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

}
