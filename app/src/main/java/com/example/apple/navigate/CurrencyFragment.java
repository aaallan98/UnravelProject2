package com.example.apple.navigate;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.androidquery.AQuery;
import com.androidquery.callback.AjaxCallback;
import com.androidquery.callback.AjaxStatus;

import org.json.JSONException;
import org.json.JSONObject;


/**
 * A simple {@link Fragment} subclass.
 */
public class CurrencyFragment extends Fragment implements View.OnClickListener {

    public CurrencyFragment() {
        // Required empty public constructor
    }

    private EditText currency;
    private TextView currencyTo;
    private TextView currencyFrom;
    private Spinner spinnerFrom;
    private Spinner spinnerTo;
    private Button convertB;
    private final String base_url = "http://api.fixer.io/latest?";          //currency rate JSON fixer.io
    private AQuery aq;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_currency, container, false);

        currency = (EditText) v.findViewById(R.id.editText_currency);
        currencyTo = (TextView) v.findViewById(R.id.textView_to);
        currencyFrom = (TextView) v.findViewById(R.id.textView_from);
        spinnerFrom = (Spinner) v.findViewById(R.id.spinner_from);
        spinnerTo = (Spinner) v.findViewById(R.id.spinner_to);
        convertB = (Button) v.findViewById(R.id.button_convert);
        aq = new AQuery(getActivity());

        //getting country list
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(), R.array.currency_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerFrom.setAdapter(adapter);
        spinnerTo.setAdapter(adapter);
        convertB.setOnClickListener(this);
        return v;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.infocurrency) {                   //getting currency information
            CurrencyInfoFragment fragment1 = new CurrencyInfoFragment();
            android.support.v4.app.FragmentTransaction fragmentTransaction =
                    getFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, fragment1);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }
        else {
            //asking putting value if no value is put
            if (currency.getText().toString().length() < 1) {
                Toast.makeText(getActivity(), "Write a value", Toast.LENGTH_LONG).show();
            }
            else {
                //getting input value, choose two countries for converting
                final Double currency_from_value = Double.valueOf(currency.getText().toString());
                String from_currency = String.valueOf(spinnerFrom.getSelectedItem());
                String to_currency = String.valueOf(spinnerTo.getSelectedItem());

                //getting currency rates from JSON
                String url = base_url + "base=" + from_currency + "&to=" + to_currency;
                aq.ajax(url, JSONObject.class, new AjaxCallback<JSONObject>() {
                    @Override
                    public void callback(String url, JSONObject json, AjaxStatus status) {
                        if (json != null) {

                            try {
                                //currencyFrom Item(Base), currencyTo Item(Final)
                                currencyFrom.setText(currency.getText().toString() + " " + spinnerFrom.getSelectedItem().toString());
                                String selectItem = spinnerTo.getSelectedItem().toString();
                                JSONObject ratesObject = json.getJSONObject("rates");

                                //if currencyFrom == currencyTo (choose same countries)
                                if (selectItem.equals(spinnerFrom.getSelectedItem().toString())) {
                                    Double rateValue = 1.0;
                                    Double result = currency_from_value * rateValue;
                                    currencyTo.setText(String.valueOf(result) + " " + spinnerTo.getSelectedItem().toString());
                                }

                                //Final currency == AUD
                                if (selectItem.equals("AUD")) {
                                    Double rateValue = ratesObject.getDouble("AUD");
                                    Double result = currency_from_value * rateValue;
                                    currencyTo.setText(String.valueOf(result) + " " + spinnerTo.getSelectedItem().toString());
                                }

                                //Final currency == BGN
                                if (selectItem.equals("BGN")) {
                                    Double rateValue = ratesObject.getDouble("BGN");
                                    Double result = currency_from_value * rateValue;
                                    currencyTo.setText(String.valueOf(result) + " " + spinnerTo.getSelectedItem().toString());
                                }

                                //Final currency == CAD
                                if (selectItem.equals("CAD")) {
                                    Double rateValue = ratesObject.getDouble("CAD");
                                    Double result = currency_from_value * rateValue;
                                    currencyTo.setText(String.valueOf(result) + " " + spinnerTo.getSelectedItem().toString());
                                }

                                //Final currency == CHF
                                if (selectItem.equals("CHF")) {
                                    Double rateValue = ratesObject.getDouble("CHF");
                                    Double result = currency_from_value * rateValue;
                                    currencyTo.setText(String.valueOf(result) + " " + spinnerTo.getSelectedItem().toString());
                                }

                                //Final currency == CNY
                                if (selectItem.equals("CNY")) {
                                    Double rateValue = ratesObject.getDouble("CNY");
                                    Double result = currency_from_value * rateValue;
                                    currencyTo.setText(String.valueOf(result) + " " + spinnerTo.getSelectedItem().toString());
                                }

                                //Final currency == CZK
                                if (selectItem.equals("CZK")) {
                                    Double rateValue = ratesObject.getDouble("CZK");
                                    Double result = currency_from_value * rateValue;
                                    currencyTo.setText(String.valueOf(result) + " " + spinnerTo.getSelectedItem().toString());
                                }

                                //Final currency == EUR
                                if (selectItem.equals("EUR")) {
                                    Double rateValue = ratesObject.getDouble("EUR");
                                    Double result = currency_from_value * rateValue;
                                    currencyTo.setText(String.valueOf(result) + " " + spinnerTo.getSelectedItem().toString());
                                }

                                //Final currency == DKK
                                if (selectItem.equals("DKK")) {
                                    Double rateValue = ratesObject.getDouble("DKK");
                                    Double result = currency_from_value * rateValue;
                                    currencyTo.setText(String.valueOf(result) + " " + spinnerTo.getSelectedItem().toString());
                                }

                                //Final currency == GBP
                                if (selectItem.equals("GBP")) {
                                    Double rateValue = ratesObject.getDouble("GBP");
                                    Double result = currency_from_value * rateValue;
                                    currencyTo.setText(String.valueOf(result) + " " + spinnerTo.getSelectedItem().toString());
                                }

                                //Final currency == HKD
                                if (selectItem.equals("HKD")) {
                                    Double rateValue = ratesObject.getDouble("HKD");
                                    Double result = currency_from_value * rateValue;
                                    currencyTo.setText(String.valueOf(result) + " " + spinnerTo.getSelectedItem().toString());
                                }

                                //Final currency == HRK
                                if (selectItem.equals("HRK")) {
                                    Double rateValue = ratesObject.getDouble("HRK");
                                    Double result = currency_from_value * rateValue;
                                    currencyTo.setText(String.valueOf(result) + " " + spinnerTo.getSelectedItem().toString());
                                }

                                //Final currency == HUF
                                if (selectItem.equals("HUF")) {
                                    Double rateValue = ratesObject.getDouble("HUF");
                                    Double result = currency_from_value * rateValue;
                                    currencyTo.setText(String.valueOf(result) + " " + spinnerTo.getSelectedItem().toString());
                                }

                                //Final currency == IDR
                                if (selectItem.equals("IDR")) {
                                    Double rateValue = ratesObject.getDouble("IDR");
                                    Double result = currency_from_value * rateValue;
                                    currencyTo.setText(String.valueOf(result) + " " + spinnerTo.getSelectedItem().toString());
                                }

                                //Final currency == ILS
                                if (selectItem.equals("ILS")) {
                                    Double rateValue = ratesObject.getDouble("ILS");
                                    Double result = currency_from_value * rateValue;
                                    currencyTo.setText(String.valueOf(result) + " " + spinnerTo.getSelectedItem().toString());
                                }

                                //Final currency == INR
                                if (selectItem.equals("INR")) {
                                    Double rateValue = ratesObject.getDouble("INR");
                                    Double result = currency_from_value * rateValue;
                                    currencyTo.setText(String.valueOf(result) + " " + spinnerTo.getSelectedItem().toString());
                                }

                                //Final currency == JPY
                                if (selectItem.equals("JPY")) {
                                    Double rateValue = ratesObject.getDouble("JPY");
                                    Double result = currency_from_value * rateValue;
                                    currencyTo.setText(String.valueOf(result) + " " + spinnerTo.getSelectedItem().toString());
                                }

                                //Final currency == KRW
                                if (selectItem.equals("KRW")) {
                                    Double rateValue = ratesObject.getDouble("KRW");
                                    Double result = currency_from_value * rateValue;
                                    currencyTo.setText(String.valueOf(result) + " " + spinnerTo.getSelectedItem().toString());
                                }

                                //Final currency == MXN
                                if (selectItem.equals("MXN")) {
                                    Double rateValue = ratesObject.getDouble("MXN");
                                    Double result = currency_from_value * rateValue;
                                    currencyTo.setText(String.valueOf(result) + " " + spinnerTo.getSelectedItem().toString());
                                }

                                //Final currency == MYR
                                if (selectItem.equals("MYR")) {
                                    Double rateValue = ratesObject.getDouble("MYR");
                                    Double result = currency_from_value * rateValue;
                                    currencyTo.setText(String.valueOf(result) + " " + spinnerTo.getSelectedItem().toString());
                                }

                                //Final currency == NOK
                                if (selectItem.equals("NOK")) {
                                    Double rateValue = ratesObject.getDouble("NOK");
                                    Double result = currency_from_value * rateValue;
                                    currencyTo.setText(String.valueOf(result) + " " + spinnerTo.getSelectedItem().toString());
                                }

                                //Final currency == NZD
                                if (selectItem.equals("NZD")) {
                                    Double rateValue = ratesObject.getDouble("NZD");
                                    Double result = currency_from_value * rateValue;
                                    currencyTo.setText(String.valueOf(result) + " " + spinnerTo.getSelectedItem().toString());
                                }

                                //Final currency == PHP
                                if (selectItem.equals("PHP")) {
                                    Double rateValue = ratesObject.getDouble("PHP");
                                    Double result = currency_from_value * rateValue;
                                    currencyTo.setText(String.valueOf(result) + " " + spinnerTo.getSelectedItem().toString());
                                }

                                //Final currency == PLN
                                if (selectItem.equals("PLN")) {
                                    Double rateValue = ratesObject.getDouble("PLN");
                                    Double result = currency_from_value * rateValue;
                                    currencyTo.setText(String.valueOf(result) + " " + spinnerTo.getSelectedItem().toString());
                                }

                                //Final currency == RON
                                if (selectItem.equals("RON")) {
                                    Double rateValue = ratesObject.getDouble("RON");
                                    Double result = currency_from_value * rateValue;
                                    currencyTo.setText(String.valueOf(result) + " " + spinnerTo.getSelectedItem().toString());
                                }

                                //Final currency == RUB
                                if (selectItem.equals("RUB")) {
                                    Double rateValue = ratesObject.getDouble("RUB");
                                    Double result = currency_from_value * rateValue;
                                    currencyTo.setText(String.valueOf(result) + " " + spinnerTo.getSelectedItem().toString());
                                }

                                //Final currency == SEK
                                if (selectItem.equals("SEK")) {
                                    Double rateValue = ratesObject.getDouble("SEK");
                                    Double result = currency_from_value * rateValue;
                                    currencyTo.setText(String.valueOf(result) + " " + spinnerTo.getSelectedItem().toString());
                                }

                                //Final currency == SGD
                                if (selectItem.equals("SGD")) {
                                    Double rateValue = ratesObject.getDouble("SGD");
                                    Double result = currency_from_value * rateValue;
                                    currencyTo.setText(String.valueOf(result) + " " + spinnerTo.getSelectedItem().toString());
                                }

                                //Final currency == THB
                                if (selectItem.equals("THB")) {
                                    Double rateValue = ratesObject.getDouble("THB");
                                    Double result = currency_from_value * rateValue;
                                    currencyTo.setText(String.valueOf(result) + " " + spinnerTo.getSelectedItem().toString());
                                }

                                //Final currency == TRY
                                if (selectItem.equals("TRY")) {
                                    Double rateValue = ratesObject.getDouble("TRY");
                                    Double result = currency_from_value * rateValue;
                                    currencyTo.setText(String.valueOf(result) + " " + spinnerTo.getSelectedItem().toString());
                                }

                                //Final currency == USD
                                if (selectItem.equals("USD")) {
                                    Double rateValue = ratesObject.getDouble("USD");
                                    Double result = currency_from_value * rateValue;
                                    currencyTo.setText(String.valueOf(result) + " " + spinnerTo.getSelectedItem().toString());
                                }

                                //Final currency == ZAR
                                if (selectItem.equals("ZAR")) {
                                    Double rateValue = ratesObject.getDouble("ZAR");
                                    Double result = currency_from_value * rateValue;
                                    currencyTo.setText(String.valueOf(result) + " " + spinnerTo.getSelectedItem().toString());
                                }
                            }
                            catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        else      //If it occurs error
                        {
                            Toast.makeText(aq.getContext(), "Error:" + status.getCode(), Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
        }
    }
}

