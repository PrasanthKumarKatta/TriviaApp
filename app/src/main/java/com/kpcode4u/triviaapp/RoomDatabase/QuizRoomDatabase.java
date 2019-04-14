package com.kpcode4u.triviaapp.RoomDatabase;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = {QuizEntitiy.class},version = 1, exportSchema = false)
public abstract class QuizRoomDatabase extends RoomDatabase
{
    private static final String DATABASE = "quiz_database";

    public abstract QuizDao mQuizDao();

    private static volatile QuizRoomDatabase INSTANCE;

    static QuizRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (QuizRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            QuizRoomDatabase.class, DATABASE)
                            .allowMainThreadQueries()
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
