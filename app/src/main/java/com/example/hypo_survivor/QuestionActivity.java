package com.example.hypo_survivor;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;

import android.os.Bundle;
import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

@SuppressLint("Registered")
public class QuestionActivity extends AppCompatActivity {

    private QuestionBank mQuestionLibrary = new QuestionBank();

    // private TextView mScoreView;   // view for current total score
    private TextView mQuestionView;  //current question to answer
    private Button mButtonChoice1; // multiple choice 1 for mQuestionView
    private Button mButtonChoice2; // multiple choice 2 for mQuestionView
    private Button mButtonChoice3; // multiple choice 3 for mQuestionView
    private Button mButtonChoice4; // multiple choice 4 for mQuestionView

    private String mAnswer;  // correct answer for question in mQuestionView
    // private int mScore = 0;  // current total score
    private int mQuestionNumber = 0; // current question number

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        // setup screen for the first question with four alternative to answer
        // mScoreView = (TextView)findViewById(R.id.score);
        mQuestionView = findViewById(R.id.question);
        mButtonChoice1 = findViewById(R.id.a1);
        mButtonChoice2 = findViewById(R.id.a2);
        mButtonChoice3 = findViewById(R.id.a3);
        mButtonChoice4 = findViewById(R.id.a4);

        mQuestionLibrary.initQuestions(getApplicationContext());
        updateQuestion();
        // show current total score for the user
        // updateScore(mScore);
    }

    private void updateQuestion(){
        // check if we are not outside array bounds for questions
        if(mQuestionNumber<mQuestionLibrary.getLength() ){
            // set the text for new question,
            // and new 4 alternative to answer on four buttons
            mQuestionView.setText(mQuestionLibrary.getQuestion(mQuestionNumber));
            mButtonChoice1.setText(mQuestionLibrary.getChoice(mQuestionNumber, 1));
            mButtonChoice2.setText(mQuestionLibrary.getChoice(mQuestionNumber, 2));
            mButtonChoice3.setText(mQuestionLibrary.getChoice(mQuestionNumber, 3));
            mButtonChoice4.setText(mQuestionLibrary.getChoice(mQuestionNumber,4));
            mAnswer = mQuestionLibrary.getCorrectAnswer(mQuestionNumber);
            mQuestionNumber++;
        }
        else {
            lastQuestion();

        }
    }

    private void lastQuestion(){
        if(mQuestionNumber==mQuestionLibrary.getLength() ) {
           // Intent intent = getIntent();
            //String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
            startActivity(new Intent(QuestionActivity.this, FinalScreenFrag.class));
        }
    }

    // show current total score for the user
    //private void updateScore(int point) {
    //     mScoreView.setText(""+mScore+"/"+mQuestionLibrary.getLength());
    // }

    public void onClick(View view) {
        //all logic for all answers buttons in one method
        Button answer = (Button) view;
        // if the answer is correct, increase the score
        if (answer.getText().equals(mAnswer)){
            // mScore = mScore + 1;
            Toast.makeText(QuestionActivity.this, "Correct!", Toast.LENGTH_SHORT).show();
        }else
           // startActivity(new Intent(QuestionActivity.this, AnswerFragment.class));
            startActivity(new Intent(QuestionActivity.this, AnswerFragment.class));
        // show current total score for the user
        // updateScore(mScore);
        // once user answer the question, we move on to the next one, if any
        updateQuestion();
    }
}