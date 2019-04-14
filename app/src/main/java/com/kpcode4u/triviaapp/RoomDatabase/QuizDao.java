package com.kpcode4u.triviaapp.RoomDatabase;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface QuizDao
{
    @Insert
    void saveHistory(QuizEntitiy quizEntitiy);

    @Query("select * from QuizEntitiy")
    LiveData<List<QuizEntitiy>> readAllQuizAns();

}
