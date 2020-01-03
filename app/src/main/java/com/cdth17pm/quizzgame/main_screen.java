package com.cdth17pm.quizzgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class main_screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
    }

    public void openManageAccount(View view) {
        Intent intent = new Intent(this,manage_account.class);
        startActivity(intent);
    }

    public void openChooseField(View view) {
        Intent intent = new Intent (this,choose_field.class);
        startActivity(intent);
    }

    public void openRanking(View view) {
        Intent intent = new Intent(this,Rank.class);
        startActivity(intent);
    }
}
