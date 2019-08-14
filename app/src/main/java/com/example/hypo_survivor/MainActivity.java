package com.example.hypo_survivor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity{
    public static String userName;
    Button startButton;
    EditText uName;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        uName = findViewById(R.id.userName); //(EditText)
        startButton = findViewById(R.id.startButton); //(Button)

        startButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                //set condition
                userName = uName.getText().toString();
                if ((uName.length()==0)&& (userName!="") &&(userName != null)) {
                    uName.setError("Please enter your Name");

                }
                else{
                    startActivity(new Intent(MainActivity.this, QuestionActivity.class));
                }

            }
        });

    }



}