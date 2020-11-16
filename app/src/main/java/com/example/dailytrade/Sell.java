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

import java.text.DecimalFormat;


/**
 * A simple {@link Fragment} subclass.
 */
public class Sell extends Fragment {


    public Sell() {
        // Required empty public constructor
    }
    TextView displaybuy;
    public EditText am,cr;
    float tempbuy,tempcr;
    public Button showbutton,clearbutton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
      final   View view = inflater.inflate(R.layout.fragment_sell, container, false);
        showbutton = view.findViewById(R.id.checkbuy);
        clearbutton = view.findViewById(R.id.clearsell);

        am = view.findViewById(R.id.buyamount);
        cr = view.findViewById(R.id.buycr);
        displaybuy = view.findViewById(R.id.buymainamount);

        showbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                tempbuy = Float.parseFloat(am.getText().toString());
                tempcr = Float.parseFloat(cr.getText().toString());

                float mainbuy = tempbuy*tempcr;

                displaybuy.setText("You will get " + new DecimalFormat("##.##").format(mainbuy) +" RS");
            }
        });



        clearbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                am.setText("");
                cr.setText("");
                displaybuy.setText("");
            }
        });

        am.addTextChangedListener(loginTextWatcher);
        cr.addTextChangedListener(loginTextWatcher);

        return view;
    }
    private TextWatcher loginTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String unername = am.getText().toString().trim();
            String currentrate  = cr.getText().toString().trim();
            showbutton.setEnabled(!unername.isEmpty()&& !currentrate.isEmpty());
            clearbutton.setEnabled(!unername.isEmpty()&& !currentrate.isEmpty());
        }
        @Override
        public void afterTextChanged(Editable s) {
        }
    };
}
