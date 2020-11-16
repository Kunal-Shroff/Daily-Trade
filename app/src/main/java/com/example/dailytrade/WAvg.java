package com.example.dailytrade;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;


/**
 * A simple {@link Fragment} subclass.
 */
public class WAvg extends Fragment {

    public EditText pclose,p1close;
    private TextView firstbuy, secondbuy, thirdbuy,firstsell, secondsell, thirdsell;
    private Button s1,  s2,c1,c2 ;
    private float buy1, buy2,fb ,sb,tb,fs,ss,ts;
    public float prevalue,wavg;
    public WAvg() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       final View view= inflater.inflate(R.layout.fragment_wavg, container, false);

        s1 = view.findViewById(R.id.show1);//buttons
        c1 = view.findViewById(R.id.clear1);
        s2 = view.findViewById(R.id.show2);
        c2 = view.findViewById(R.id.clear2);

        pclose = view.findViewById(R.id.prevclose);//EditText
        p1close = view.findViewById(R.id.prev1close);

        firstbuy = view.findViewById(R.id.fbuy);//Buy
        secondbuy = view.findViewById(R.id.sbuy);
        thirdbuy = view.findViewById(R.id.tbuy);

        firstsell = view.findViewById(R.id.fsell);//Sell
        secondsell = view.findViewById(R.id.ssell);
        thirdsell = view.findViewById(R.id.tsell);


        s1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                prevalue = Float.parseFloat(pclose.getText().toString());

                fb = (float) (prevalue*1.65/100)-(prevalue);

                sb = (float) (prevalue*3.65/100)-(prevalue);

                tb = (float) (prevalue*5/100)-(prevalue);


                firstbuy.setText(""+ new DecimalFormat("##.##").format(fb));

                secondbuy.setText(""+ new DecimalFormat("##.##").format(sb));

                thirdbuy.setText((""+ new DecimalFormat("##.##").format(tb)));

            }
        });
        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pclose.setText("");
                firstbuy.setText("");
                secondbuy.setText("");
                thirdbuy.setText("");

            }
        });


        s2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                wavg = Float.parseFloat(p1close.getText().toString());

                fs = (float) (wavg*2/100)+(wavg);

                ss = (float) (wavg*3.5/100)+(wavg);

                ts = (float) (wavg*5.5/100)+(wavg);

                firstsell.setText(""+ new DecimalFormat("##.##").format(fs));

                secondsell.setText(""+new DecimalFormat("##.##").format(ss));

                thirdsell.setText((""+ new DecimalFormat("##.##").format(ts)));

            }
        });

        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                p1close.setText("");
                firstsell.setText("");
                secondsell.setText("");
                thirdsell.setText("");
            }

        });









        pclose.addTextChangedListener(loginTextWatcher);
        p1close.addTextChangedListener(loginTextWatcher1);


        return view;
    }
    private TextWatcher loginTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String unername = pclose.getText().toString().trim();
            s1.setEnabled(!unername.isEmpty());
            c1.setEnabled(!unername.isEmpty());
        }
        @Override
        public void afterTextChanged(Editable s) {
        }
    };

    private TextWatcher loginTextWatcher1 = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {


        }
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String unername = p1close.getText().toString().trim();
            s2.setEnabled(!unername.isEmpty());
            c2.setEnabled(!unername.isEmpty());



        }
        @Override
        public void afterTextChanged(Editable s) {

        }
    };



}
