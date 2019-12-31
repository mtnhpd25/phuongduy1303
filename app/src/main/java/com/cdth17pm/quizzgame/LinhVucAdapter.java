package com.cdth17pm.quizzgame;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

    public class LinhVucAdapter extends RecyclerView.Adapter<LinhVucAdapter.LinhVucViewHolder> {

    final ArrayList<LinhVuc> mListLinhVuc;
    private LayoutInflater mInflater;
    Context context;


    public LinhVucAdapter(Context context, ArrayList<LinhVuc> mListLinhVuc) {
        this.context = context;
        this.mListLinhVuc = mListLinhVuc;
        mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public LinhVucAdapter.LinhVucViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = this.mInflater.inflate(R.layout.item_linh_vuc,parent,false);
        return new LinhVucViewHolder(itemView,this);
    }

    @Override
    public void onBindViewHolder(@NonNull LinhVucAdapter.LinhVucViewHolder holder, int position) {

        LinhVuc linhVuc = mListLinhVuc.get(position);
        holder.mTenLinhVuc.setText(linhVuc.getTenLinhVuc());
    }

    @Override
    public int getItemCount() {
        return mListLinhVuc.size();
    }

    public class LinhVucViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        final TextView  mTenLinhVuc;
        final LinhVucAdapter mAdapter;
        CardView cardView;

        public LinhVucViewHolder(@NonNull View itemView, LinhVucAdapter adapter) {
            super(itemView);
            this.mAdapter = adapter;
            mTenLinhVuc = itemView.findViewById(R.id.tv_linh_vuc);
            cardView = itemView.findViewById(R.id.linhVuc_cardview);
            cardView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

            LinhVuc linhVuc = mListLinhVuc.get(getLayoutPosition());
            int id = linhVuc.getId();
            Intent intent = new Intent(context,display_question.class);
            intent.putExtra("linhvuc_id",id);
            context.startActivity(intent);

        }
    }
}
