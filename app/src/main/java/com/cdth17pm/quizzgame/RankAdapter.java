package com.cdth17pm.quizzgame;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class RankAdapter extends RecyclerView.Adapter<RankAdapter.RankViewHolder> {

    private final ArrayList<ranking>mListRank;
    private final LayoutInflater mInflater;
    private Context context;

    public RankAdapter(Context context, ArrayList<ranking> mListRank) {
        this.mListRank = mListRank;
        mInflater = LayoutInflater.from(context);
        this.context = context;
    }

    @NonNull
    @Override
    public RankAdapter.RankViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.item_rank,parent,false);
        return new RankViewHolder(itemView,this);
    }

    @Override
    public void onBindViewHolder(@NonNull RankAdapter.RankViewHolder holder, int position) {
        ranking rank =mListRank.get(position);
        holder.username.setText(rank.getUsername());
        holder.score.setText(rank.getScore().toString());
        Picasso.with(context)
                .load(rank.getImg())
                .into(holder.img);
    }

    @Override
    public int getItemCount() {
        return mListRank.size();
    }

    public class RankViewHolder extends RecyclerView.ViewHolder {
        TextView username,score;
        ImageView img;
        final RankAdapter mRankAdapter;
        public RankViewHolder(@NonNull View itemView, RankAdapter mRankAdapter) {
            super(itemView);
            this.mRankAdapter = mRankAdapter;
            username = itemView.findViewById(R.id.rank_tv_username);
            score = itemView.findViewById(R.id.rank_tv_score);
            img = itemView.findViewById(R.id.rank_img);
        }
    }

}
