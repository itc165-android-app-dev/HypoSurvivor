package com.example.hypo_survivor;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;



public class FinalScreenFrag extends MainActivity{
    public static SharedPreferences savedValues;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_final_screen);

        // Get the Intent that started this activity and extract the string


        // Capture the layout's TextView and set the string as its text
        TextView userName1 = findViewById(R.id.userName);
       userName1.setText(userName);
    }
}