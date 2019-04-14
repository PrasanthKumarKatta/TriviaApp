package com.kpcode4u.triviaapp.RoomDatabase;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

public class QuizRepository
{
    private QuizDao mQuizDao;
    private LiveData<List<QuizEntitiy>> mAllQuizHistory;

    QuizRepository(Application application) {
        QuizRoomDatabase db = QuizRoomDatabase.getDatabase(application);
        mQuizDao = db.mQuizDao();
        mAllQuizHistory = mQuizDao.readAllQuizAns();
    }

    public LiveData<List<QuizEntitiy>> getAllQuizHistory() {
        return mAllQuizHistory;
    }
    void insert(QuizEntitiy quizEntitiy)
    {
        new InsertAsyncTask(mQuizDao).execute(quizEntitiy);

    }

    private static class InsertAsyncTask extends AsyncTask<QuizEntitiy,Void,Void>
    {
        private QuizDao mQDao;

        public InsertAsyncTask(QuizDao mQDao) {
            this.mQDao = mQDao;
        }

        @Override
        protected Void doInBackground(QuizEntitiy... quizEntitiys)
        {
            mQDao.saveHistory(quizEntitiys[0]);
            return null;
        }
    }
}
