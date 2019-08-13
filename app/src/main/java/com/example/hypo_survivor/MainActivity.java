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
    public static final String EXTRA_MESSAGE = "com.example.hypo_survivor.MESSAGE";

    //variables for username and start button
    public static EditText userName;

    //SharedPreferences object to store username
    public static SharedPreferences savedValues;

    //input data variables
    public static String uName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //create references for variables
        userName = findViewById(R.id.userName);
        Button startButton = findViewById(R.id.startButton);

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
        editor.putString("uName", uName);
        editor.apply();

        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();

        // Instance variables for onResume() method
        uName = savedValues.getString(String.valueOf(userName), uName);

        // Set userName
        userName.setText(uName);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, QuestionActivity.class);
        EditText editText = findViewById(R.id.userName);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
        //startActivity(new Intent(MainActivity.this, QuestionActivity.class));
    }

    @Override
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        return false;
    }
}
