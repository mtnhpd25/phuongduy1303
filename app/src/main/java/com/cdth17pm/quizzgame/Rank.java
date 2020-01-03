package com.cdth17pm.quizzgame;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class Rank extends AppCompatActivity {

    private final ArrayList<ranking> mListRank = new ArrayList<>();
    RankAdapter mRankAdapter;
    RecyclerView mRecyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rank);

        mRecyclerView = findViewById(R.id.rcv_rank);

        mRankAdapter = new RankAdapter(this,mListRank);
        mRecyclerView.setAdapter(mRankAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        new FetchRank(mRankAdapter,mListRank).execute();
    }

}
