package com.cdth17pm.quizzgame;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONObject;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class FetchRank extends AsyncTask<Void,Void,String> {
    private final WeakReference<ArrayList<ranking>> mListRank;
    final WeakReference<RankAdapter> mRankAdapter;

    public FetchRank(RankAdapter rankAdapter,ArrayList<ranking> listRank) {
        mListRank = new WeakReference<>(listRank);
        mRankAdapter = new WeakReference<>(rankAdapter);
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        try{
            JSONObject jsonObject = new JSONObject(s);
            JSONArray itemArray = jsonObject.getJSONArray("data");
            for(int i =0 ; i<itemArray.length();i++){
                int id = itemArray.getJSONObject(i).getInt("id");
                String username = itemArray.getJSONObject(i).getString("ten_dang_nhap");
                String mail = itemArray.getJSONObject(i).getString("mail");
                String image = itemArray.getJSONObject(i).getString("hinh_dai_dien");
                Double diem = itemArray.getJSONObject(i).getDouble("diem_cao_nhat");
                int credit = itemArray.getJSONObject(i).getInt("credit");
                mListRank.get().add(new ranking(id,username,mail,image,diem,credit));
            }
            mRankAdapter.get().notifyDataSetChanged();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected String doInBackground(Void... voids) {
        return Network.getJSONData("nguoi-choi","GET");
    }
}
