package com.example.apple.navigate;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

public class NightmodeActivity extends AppCompatActivity {

    private Switch nightMode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nightmode);


        nightMode = (Switch) findViewById(R.id.nightmode);
        nightMode.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(!nightMode.isChecked())
                {

                    AppCompatDelegate
                            .setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    //   Toast.makeText(this, "Nightmode on", Toast.LENGTH_SHORT).show();


                }
                else
                {
                    AppCompatDelegate
                            .setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    //  Toast.makeText(this, "Nightmode off", Toast.LENGTH_SHORT).show();
                }

            }

        });

    }

    @Override
    public void onPause() {
        super.onPause();
        save(nightMode.isChecked());
    }

    @Override
    public void onResume() {
        super.onResume();
        nightMode.setChecked(load());
    }


    private void save(final boolean isChecked) {
        SharedPreferences sharedPreferences = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("check", isChecked);
        editor.commit();
    }

    private boolean load() {
        SharedPreferences sharedPreferences = getPreferences(Context.MODE_PRIVATE);
        return sharedPreferences.getBoolean("check", false);
    }
}
