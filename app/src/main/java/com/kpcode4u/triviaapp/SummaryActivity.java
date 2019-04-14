package com.kpcode4u.triviaapp;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.kpcode4u.triviaapp.RoomDatabase.QuizEntitiy;
import com.kpcode4u.triviaapp.RoomDatabase.QuizViewModel;

import java.util.Calendar;

public class SummaryActivity extends AppCompatActivity {

    TextView tv_dateTime, tv_UName, tv_q1Ans, tv_q2Ans;
    QuizViewModel mQuizViewModel;
    String dateTime, UName, q1Ans, q2Ans;

    private static final String NameKey = "NameKey";
    private static final String q1AnsKey = "Q1AnsKey";
    private static final String q2AnsKey = "Q2AnsKey";
    private Calendar calendar;
    private String Formate_zone;
    private int hr,min,formate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);
        tv_dateTime = findViewById(R.id.date_time_history);
        tv_UName = findViewById(R.id.uName_history);
        tv_q1Ans = findViewById(R.id.q1_ans__history);
        tv_q2Ans = findViewById(R.id.q2_ans__history);

        UName = getIntent().getStringExtra(NameKey);
        q1Ans = getIntent().getStringExtra(q1AnsKey);
        q2Ans = getIntent().getStringExtra(q2AnsKey);

        calendar = Calendar.getInstance();

        callCurrentTime();
        tv_dateTime.setText(dateTime);
        tv_UName.setText(UName);
        tv_q1Ans.setText("Answer: "+q1Ans);
        tv_q2Ans.setText(q2Ans);

        mQuizViewModel = ViewModelProviders.of(this).get(QuizViewModel.class);
    }

    public void finish(View view)
    {
        dateTime = tv_dateTime.getText().toString().trim();
        UName = tv_UName.getText().toString().trim();
        q1Ans = tv_q1Ans.getText().toString().trim();
        q2Ans = tv_q2Ans.getText().toString().trim();

        mQuizViewModel.insert(setValuesToEntity());

        Snackbar.make(view, "Game Saved in History", Snackbar.LENGTH_SHORT).show();

        Intent i = new Intent(this,RegisterActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP |Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(i);
    }

    private QuizEntitiy setValuesToEntity()
    {

        QuizEntitiy quizEntitiy = new QuizEntitiy();
        quizEntitiy.setDateTime(dateTime);
        quizEntitiy.setName(UName);
        quizEntitiy.setQ1Ans(q1Ans);
        quizEntitiy.setQ2Ans(q2Ans);
        return quizEntitiy;

    }

    private void callCurrentTime()
    {
         hr = calendar.get(Calendar.HOUR);
         min = calendar.get(Calendar.MINUTE);
         formate = calendar.get(Calendar.AM_PM);

        if (formate == 0){
            Formate_zone = "AM";
        } else {
            Formate_zone = "PM";
        }
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int month = calendar.get(Calendar.MONTH);
        String m = null;
        switch (month)
        {
            case 0:
                m = "JANUARY";
                break;
            case 1:
                m = "February";
                break;
            case 2:
                m = "March";
                break;
            case 3:
                m = "April";
                break;
            case 4:
                m = "May";
                break;
            case 5:
                m = "June";
                break;
            case 6:
                m = "July";
                break;
            case 7:
                m = "August";
                break;
            case 8:
                m = "September";
                break;
            case 9:
                m = "October";
                break;
            case 10:
                m = "November";
                break;
            case 11:
                m = "December";
                break;
        }

        String time = hr + ":"+ min + " " + Formate_zone ;
        // dateTime = String.valueOf(day)+"th "+(month + 1)+" "+time;
        dateTime = String.valueOf(day)+"th "+m +" "+time;
    }

    public void history(View view)
    {
        Intent i = new Intent(this,HistoryActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(i);
    }
}
