package com.kpcode4u.triviaapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class QuizActivity1 extends AppCompatActivity {

    private static final String NameKey = "NameKey";
    private static final String q1AnsKey = "Q1AnsKey";
    RadioGroup rg;
    String ans_rbtn,uName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz1);
        rg = findViewById(R.id.rg);
        uName = getIntent().getStringExtra(NameKey);

    }

    public void next_question(View view)
    {
        int radioId = rg.getCheckedRadioButtonId();
        RadioButton radioButton = findViewById(radioId);

        ans_rbtn = radioButton.getText().toString();
        callQuiz2Activity();
    }

    private void callQuiz2Activity()
    {
        Toast.makeText(this,  ans_rbtn, Toast.LENGTH_SHORT).show();
        Intent i = new Intent(this, QuizActivity2.class);
        i.putExtra(NameKey,uName);
        i.putExtra(q1AnsKey,ans_rbtn);
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(i);
    }
}