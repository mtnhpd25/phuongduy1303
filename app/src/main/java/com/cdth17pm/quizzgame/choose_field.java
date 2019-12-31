package com.cdth17pm.quizzgame;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class choose_field extends AppCompatActivity implements LoaderManager.LoaderCallbacks<String> {
    private RecyclerView mRecyclerView;
    private LinhVucAdapter mAdapter;
    public final ArrayList<LinhVuc> mListLinhVuc = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_field);

        this.mRecyclerView = findViewById(R.id.rcv_linh_vuc);
        this.mAdapter =new LinhVucAdapter(this,this.mListLinhVuc);
        this.mRecyclerView.setAdapter(this.mAdapter);
        this.mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        if(getSupportLoaderManager().getLoader(0)!=null)
            getSupportLoaderManager().initLoader(0,null,this);
        getSupportLoaderManager().restartLoader(0,null,this);
    }


    @NonNull
    @Override
    public Loader<String> onCreateLoader(int id, @Nullable Bundle args) {
        return new LinhVucLoader(this);
    }

    @Override
    public void onLoadFinished(@NonNull Loader<String> loader, String data) {
        try {

            JSONObject jsonObject = new JSONObject(data);
            JSONArray itemArray = jsonObject.getJSONArray("data");
            for(int i = 0 ; i<itemArray.length();i++){
                int id = itemArray.getJSONObject(i).getInt("id");
                String tenlv= itemArray.getJSONObject(i).getString("ten_linh_vuc");
                this.mListLinhVuc.add(new LinhVuc(id,tenlv));
            }
            this.mAdapter.notifyDataSetChanged();
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onLoaderReset(@NonNull Loader<String> loader) {

    }
}
