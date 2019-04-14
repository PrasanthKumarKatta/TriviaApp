package com.kpcode4u.triviaapp.RoomDatabase;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity
public class QuizEntitiy
{
    @PrimaryKey (autoGenerate = true)
    @NonNull
    private int id;
    private String dateTime;
    private String Name;
    private String q1Ans;
    private String q2Ans;

    public QuizEntitiy() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    @NonNull
    public String getName() {
        return Name;
    }

    public void setName(@NonNull String name) {
        Name = name;
    }

    public String getQ1Ans() {
        return q1Ans;
    }

    public void setQ1Ans(String q1Ans) {
        this.q1Ans = q1Ans;
    }

    public String getQ2Ans() {
        return q2Ans;
    }

    public void setQ2Ans(String q2Ans) {
        this.q2Ans = q2Ans;
    }
}
