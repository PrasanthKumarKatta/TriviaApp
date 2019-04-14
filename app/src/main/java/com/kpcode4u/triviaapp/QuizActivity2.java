package com.kpcode4u.triviaapp;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.kpcode4u.triviaapp.RoomDatabase.QuizEntitiy;
import com.kpcode4u.triviaapp.RoomDatabase.QuizViewModel;

public class QuizActivity2 extends AppCompatActivity {

    private static final String NameKey = "NameKey";
    private static final String q1AnsKey = "Q1AnsKey";
    private static final String q2AnsKey = "Q2AnsKey";
    String name,q1Ans;
    CheckBox ch1,ch2,ch3,ch4;
    String ch_data_result, ch1_data, ch2_data, ch3_data, ch4_data;
    Integer First,Second,Third,Fourth;
    Integer Total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz2);
        ch1 = findViewById(R.id.ch1);
        ch2 = findViewById(R.id.ch2);
        ch3 = findViewById(R.id.ch3);
        ch4 = findViewById(R.id.ch4);

        name = getIntent().getStringExtra(NameKey);
        q1Ans = getIntent().getStringExtra(q1AnsKey);

    }

    public void nex_summary(View view)
    {
        if(ch1.isChecked())
        {
            First = 1;
            Total = First;
        }
        if(ch2.isChecked())
        {
            Second = 2;
            Total = Second;
        }
        if(ch3.isChecked())
        {
            Third = 3;
            Total = Third;
        }
        if(ch4.isChecked())
        {
            Fourth = 4;
            Total = Fourth;
        }
        if(ch1.isChecked() && ch2.isChecked())
        {
            Total = 12;
        }
        if(ch1.isChecked() && ch3.isChecked())
        {
            Total = 13;
        }
        if(ch1.isChecked() && ch4.isChecked())
        {
            Total = 14;
        }
        if(ch2.isChecked() && ch3.isChecked())
        {
            Total = 23;
        }
        if(ch2.isChecked() && ch4.isChecked())
        {
            Total = 24;
        }
        if(ch3.isChecked() && ch4.isChecked())
        {
            Total = 34;
        }
        if(ch1.isChecked() && ch2.isChecked() && ch3.isChecked())
        {
            Total = 123;
        }
        if(ch1.isChecked() && ch2.isChecked() && ch4.isChecked())
        {
            Total = 124;
        }
        if(ch1.isChecked() && ch3.isChecked() && ch4.isChecked())
        {
            Total = 134;
        }
        if(ch2.isChecked() && ch3.isChecked() && ch4.isChecked())
        {
            Total = 234;
        }
        if(ch1.isChecked() && ch2.isChecked() && ch3.isChecked() && ch4.isChecked())
        {
            Total = 1234;
        }

        ch1_data = ch1.getText().toString();
        ch2_data = ch2.getText().toString();
        ch3_data = ch3.getText().toString();
        ch4_data = ch4.getText().toString();

        switch(Total)
        {
            case 1:
                ch_data_result = ch1_data;
                callSummaryActivity();
                break;
            case 2:
                ch_data_result = ch2_data;
                callSummaryActivity();
                break;
            case 3:
                ch_data_result = ch3_data;
                callSummaryActivity();
                break;
            case 4:
                ch_data_result  = ch4_data;
                callSummaryActivity();
                break;
            case 12:
                ch_data_result = ch1_data +","+ch2_data;
                callSummaryActivity();
                break;
            case 13:
                ch_data_result = ch1_data +","+ch3_data;
                callSummaryActivity();
                break;
            case 14:
                ch_data_result = ch1_data +","+ch4_data;
                callSummaryActivity();
                break;
            case 23:
                ch_data_result = ch2_data +","+ch3_data;
                callSummaryActivity();
                break;
            case 24:
                ch_data_result = ch2_data +","+ch4_data;
                callSummaryActivity();
                break;
            case 34:
                ch_data_result = ch3_data +","+ch4_data;
                callSummaryActivity();
                break;
            case 123:
                ch_data_result = ch1_data +","+ch2_data+","+ch3_data;
                callSummaryActivity();
                break;
            case 124:
                ch_data_result = ch1_data +","+ch2_data+","+ch4_data;
                callSummaryActivity();
                break;
            case 134:
                ch_data_result = ch1_data +","+ch3_data+","+ch4_data;
                callSummaryActivity();
                break;
            case 234:
                ch_data_result = ch2_data +","+ch3_data+","+ch4_data;
                callSummaryActivity();
                break;
            case 1234:
                ch_data_result = ch1_data +","+ch2_data+","+ch3_data +","+ch4_data;
                callSummaryActivity();
                break;
        }

    }

    private void callSummaryActivity()
    {
        Toast.makeText(this, ch_data_result, Toast.LENGTH_SHORT).show();
        Intent i = new Intent(this, SummaryActivity.class);
        i.putExtra(NameKey, name);
        i.putExtra(q1AnsKey, q1Ans);
        i.putExtra(q2AnsKey, ch_data_result);
        startActivity(i);

    }
}
