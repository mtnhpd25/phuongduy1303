package com.cdth17pm.quizzgame;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity  {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void Choose_answer(View view) {
    }

    public void DangNhapMainScreen(View view) {
        Intent intent = new Intent(this,main_screen.class);
        startActivity(intent);
    }

    public void openForgetPassword(View view) {
        Intent intent = new Intent(this,forget_password.class);
        startActivity(intent);
    }

    public void openRegister(View view) {
        Intent intent = new Intent(this,register.class);
        startActivity(intent);
    }

}
