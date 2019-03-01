package com.example.imaxinacion.currencyconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.Html;
import android.text.InputType;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    String[] mainTitle = new String[]{"USD", "RUP", "NAI", "AUD", "YEN", "KR", "CAD", "CHF", "YUAN", "ZAR", "AED", "NKR", "RUB", "RM", "SGD", "BRL"};
    String[] mainName = new String[]{"American Dollar", "Indian Rupee", "Nigerian Naira", "Australian Dollar", "Japanese Yen", "Swedish Krona", "Canadian Dollar",
                                        "Swiss Franc", "Chinese Yuan", "South African Rand", "United Emirates Dinar", "Norwegian Krone", "Russian Ruble", "Malaysian Ringgit",
                                        "Singaporean Dollar", "Brazilian Real"};
    int[] mainImages = new int[]{R.drawable.us_sm,
            R.drawable.in_sm,
            R.drawable.ng_sm,
            R.drawable.au_sm,
            R.drawable.jp_sm,
            R.drawable.se_sm,
            R.drawable.ca_sm,
            R.drawable.ch_sm,
            R.drawable.cn_sm,
            R.drawable.za_sm,
            R.drawable.ae_sm,
            R.drawable.no_sm,
            R.drawable.ru_sm,
            R.drawable.my,
            R.drawable.sg,
            R.drawable.br};

    EditText enterCurrency = null;
    private static final String TAG = "Your App";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner mainCurrency = (Spinner) findViewById(R.id.mainCurrency);

        final String[] testCur = {""};

        final double[] result = {};

        final TextView valFirst = (TextView) findViewById(R.id.valCurrency);
        final TextView valSecond = (TextView) findViewById(R.id.valSecond);
        final TextView valThird = (TextView) findViewById(R.id.valThird);

        final Button resetBtn = (Button) findViewById(R.id.resetBtn);

        enterCurrency = (EditText) findViewById(R.id.enterCurrency);

        CustomSpinnerAdapter rCustomAdapter = new CustomSpinnerAdapter(MainActivity.this, mainTitle, mainImages, mainName);
        mainCurrency.setAdapter(rCustomAdapter);

        mainCurrency.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(MainActivity.this, mainTitle[position], Toast.LENGTH_LONG).show();
                testCur[0] = mainTitle[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        final TextWatcher myWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String somin = (String) testCur[0];
                Log.v(TAG, somin);

                switch(testCur[0]) {
                    case "USD":
                        valFirst.setText("$" + generalConvert(enterCurrency.getText().toString(), 1.00));
                        valSecond.setText("€" + generalConvert(enterCurrency.getText().toString(), 0.88));
                        valThird.setText("£" + generalConvert(enterCurrency.getText().toString(), 0.78));
                        break;
                    case "RUP":
                        valFirst.setText("$" + generalConvert(enterCurrency.getText().toString(), 0.014));
                        valSecond.setText("€" + generalConvert(enterCurrency.getText().toString(), 0.012));
                        valThird.setText("£" + generalConvert(enterCurrency.getText().toString(), 0.011));
                        break;
                    case "NAI":
                        valFirst.setText("$" + generalConvert(enterCurrency.getText().toString(), 0.0027));
                        valSecond.setText("€" + generalConvert(enterCurrency.getText().toString(), 0.0024));
                        valThird.setText("£" + generalConvert(enterCurrency.getText().toString(), 0.0021));
                        break;
                    case "AUD":
                        valFirst.setText("$" + generalConvert(enterCurrency.getText().toString(), 0.73));
                        valSecond.setText("€" + generalConvert(enterCurrency.getText().toString(), 0.64));
                        valThird.setText("£" + generalConvert(enterCurrency.getText().toString(), 0.57));
                        break;
                    case "YEN":
                        valFirst.setText("$" + generalConvert(enterCurrency.getText().toString(), 0.14));
                        valSecond.setText("€" + generalConvert(enterCurrency.getText().toString(), 0.13));
                        valThird.setText("£" + generalConvert(enterCurrency.getText().toString(), 0.11));
                        break;
                    case "KR":
                        valFirst.setText("$" + generalConvert(enterCurrency.getText().toString(), 0.11));
                        valSecond.setText("€" + generalConvert(enterCurrency.getText().toString(), 0.097));
                        valThird.setText("£" + generalConvert(enterCurrency.getText().toString(), 0.087));
                        break;
                    case "CAD":
                        valFirst.setText("$" + generalConvert(enterCurrency.getText().toString(), 0.76));
                        valSecond.setText("€" + generalConvert(enterCurrency.getText().toString(), 0.67));
                        valThird.setText("£" + generalConvert(enterCurrency.getText().toString(), 0.59));
                        break;
                    case "CHF":
                        valFirst.setText("$" + generalConvert(enterCurrency.getText().toString(), 1.00));
                        valSecond.setText("€" + generalConvert(enterCurrency.getText().toString(), 0.88));
                        valThird.setText("£" + generalConvert(enterCurrency.getText().toString(), 0.78));
                        break;
                    case "YUAN":
                        valFirst.setText("$" + generalConvert(enterCurrency.getText().toString(), 0.14));
                        valSecond.setText("€" + generalConvert(enterCurrency.getText().toString(), 0.13));
                        valThird.setText("£" + generalConvert(enterCurrency.getText().toString(), 0.11));
                        break;
                    case "ZAR":
                        valFirst.setText("$" + generalConvert(enterCurrency.getText().toString(), 0.071));
                        valSecond.setText("€" + generalConvert(enterCurrency.getText().toString(), 0.063));
                        valThird.setText("£" + generalConvert(enterCurrency.getText().toString(), 0.056));
                        break;
                    case "AED":
                        valFirst.setText("$" + generalConvert(enterCurrency.getText().toString(), 3.67));
                        valSecond.setText("€" + generalConvert(enterCurrency.getText().toString(), 4.19));
                        valThird.setText("£" + generalConvert(enterCurrency.getText().toString(), 4.70));
                        break;
                    case "NKR":
                        valFirst.setText("$" + generalConvert(enterCurrency.getText().toString(), 0.12));
                        valSecond.setText("€" + generalConvert(enterCurrency.getText().toString(), 0.10));
                        valThird.setText("£" + generalConvert(enterCurrency.getText().toString(), 0.092));
                        break;
                    case "RUB":
                        valFirst.setText("$" + generalConvert(enterCurrency.getText().toString(), 0.015));
                        valSecond.setText("€" + generalConvert(enterCurrency.getText().toString(), 0.013));
                        valThird.setText("£" + generalConvert(enterCurrency.getText().toString(), 0.012));
                        break;
                    case "RM":
                        valFirst.setText("$" + generalConvert(enterCurrency.getText().toString(), 0.24));
                        valSecond.setText("€" + generalConvert(enterCurrency.getText().toString(), 0.21));
                        valThird.setText("£" + generalConvert(enterCurrency.getText().toString(), 0.19));
                        break;
                    case "SGD":
                        valFirst.setText("$" + generalConvert(enterCurrency.getText().toString(), 0.73));
                        valSecond.setText("€" + generalConvert(enterCurrency.getText().toString(), 0.64));
                        valThird.setText("£" + generalConvert(enterCurrency.getText().toString(), 0.57));
                        break;
                    case "BRL":
                        valFirst.setText("$" + generalConvert(enterCurrency.getText().toString(), 0.27));
                        valSecond.setText("€" + generalConvert(enterCurrency.getText().toString(), 0.23));
                        valThird.setText("£" + generalConvert(enterCurrency.getText().toString(), 0.21));
                        break;
                    default:
                        valFirst.setText("$0.00");
                        valSecond.setText("€0.00");
                        valThird.setText("£0.00");
                        break;
                }

            }
        };

        resetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valFirst.setText("$0.00");
                valSecond.setText("€0.00");
                valThird.setText("£0.00");
                enterCurrency.removeTextChangedListener(myWatcher);
                enterCurrency.setText(null);
                enterCurrency.addTextChangedListener(myWatcher);
            }
        });

        enterCurrency.addTextChangedListener(myWatcher);

    }

    public String generalConvert(String val, Double rate) {
        Double result = Double.parseDouble(val) * rate;
        String stringDouble = Double.toString(result);

        return stringDouble;
    }
}