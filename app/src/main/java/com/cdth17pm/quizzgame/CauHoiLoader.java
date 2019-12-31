package com.cdth17pm.quizzgame;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.loader.content.AsyncTaskLoader;

public class CauHoiLoader extends AsyncTaskLoader<String> {
    int id;

    public CauHoiLoader(@NonNull Context context,int id_linh_vuc) {
        super(context);
        this.id = id_linh_vuc;
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        forceLoad();
    }

    @Nullable
    @Override
    public String loadInBackground() {
        return Network.getJSONData("cau-hoi?linh_vuc="+id,"GET");
    }
}
