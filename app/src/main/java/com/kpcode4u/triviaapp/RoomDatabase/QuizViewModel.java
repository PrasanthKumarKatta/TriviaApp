package com.kpcode4u.triviaapp.RoomDatabase;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.List;

public class QuizViewModel extends AndroidViewModel
{

    private QuizRepository mQuizRepository;
    private LiveData<List<QuizEntitiy>> live_list;


    public QuizViewModel(@NonNull Application application)
    {
        super(application);
        mQuizRepository = new QuizRepository(application);
        live_list = mQuizRepository.getAllQuizHistory();
    }

    public LiveData<List<QuizEntitiy>> getLive_list() {
        return live_list;
    }
    public void insert(QuizEntitiy quizEntitiy) {
        mQuizRepository.insert(quizEntitiy);
    }
}
