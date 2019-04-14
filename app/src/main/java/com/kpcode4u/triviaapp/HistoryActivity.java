package com.kpcode4u.triviaapp;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.kpcode4u.triviaapp.Adapters.HistoryAdapter;
import com.kpcode4u.triviaapp.RoomDatabase.QuizEntitiy;
import com.kpcode4u.triviaapp.RoomDatabase.QuizViewModel;

import java.util.List;

public class HistoryActivity extends AppCompatActivity {
    RecyclerView rv;
    QuizViewModel viewModel;
    private HistoryAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        rv = findViewById(R.id.recycler_history);

        viewModel = ViewModelProviders.of(this).get(QuizViewModel.class);

        viewModel.getLive_list().observe(this, new Observer<List<QuizEntitiy>>() {
            @Override
            public void onChanged(@Nullable List<QuizEntitiy> quizEntities) {
                adapter = new HistoryAdapter(HistoryActivity.this, quizEntities,rv);
                rv.setAdapter(adapter);
            }
        });

        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));

    }
}
