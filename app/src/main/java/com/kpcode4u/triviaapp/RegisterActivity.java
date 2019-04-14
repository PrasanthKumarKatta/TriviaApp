package com.kpcode4u.triviaapp;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity
{
    TextInputEditText et_uName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        et_uName = findViewById(R.id.et_UserName);

    }

    public void next(View view)
    {
        String uName = et_uName.getText().toString().trim();
        if (uName.length() !=0){
            Toast.makeText(this, "User Name: "+uName, Toast.LENGTH_SHORT).show();
            Intent i = new Intent(this,QuizActivity1.class);
            i.putExtra("NameKey",uName);
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(i);
            et_uName.setText(null);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId())
        {
            case R.id.history:
                Intent i = new Intent(this,HistoryActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
