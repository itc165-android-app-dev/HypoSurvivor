package com.example.hypo_survivor;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;



public class FinalScreenFrag extends MainActivity implements View.OnClickListener{
    public static SharedPreferences savedValues;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_final_screen);

        // Get the Intent that started this activity and extract the string


        // Capture the layout's TextView and set the string as its text
        TextView userName1 = findViewById(R.id.uName);
       userName1.setText(userName);
    }

    @Override
    public void onClick(View v) {
        startActivity(new Intent(FinalScreenFrag.this, MainActivity.class));

    }

    public void onBackPressed() {
        startActivity(new Intent(FinalScreenFrag.this, MainActivity.class));
    }

    //     Before 2.0
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            startActivity(new Intent(FinalScreenFrag.this, MainActivity.class));
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}



