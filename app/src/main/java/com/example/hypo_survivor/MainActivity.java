package com.example.hypo_survivor;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity<string> extends AppCompatActivity implements TextView.OnEditorActionListener, View.OnClickListener {

    //variables for username and start button
    private EditText userName;
    private Button startButton;

    //SharedPreferences object to store username
    private SharedPreferences savedValues;

    //input data variables
    private string uName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //create references for variables
        userName = findViewById(R.id.userName);
        startButton = findViewById(R.id.startButton);

        //create listeners
        userName.setOnEditorActionListener(this);
        startButton.setOnClickListener(this);

        //stored input value
        savedValues = getSharedPreferences("SavedValues", MODE_PRIVATE);
    }

    @Override
    protected void onPause() {
        // Instance variables for onPause() method
        SharedPreferences.Editor editor = savedValues.edit();
        editor.putString("uName", (String) uName);
        editor.apply();

        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();

        // Instance variables for onResume() method
        uName = (string) savedValues.getString("uName", "");

        // Set userName
        userName.setText((String) uName);
    }

    @Override
    public void onClick(View v) {
        startActivity(new Intent(MainActivity.this, QuestionActivity.class));
    }

    @Override
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        return false;
    }
}
