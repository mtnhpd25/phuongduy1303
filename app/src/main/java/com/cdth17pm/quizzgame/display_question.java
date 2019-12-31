package com.cdth17pm.quizzgame;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class display_question extends AppCompatActivity implements LoaderManager.LoaderCallbacks<String> {

    TextView tvCauHoi;
    Button paA_btn,paB_btn,paC_btn,paD_btn;
    private static TextView tv_count_down;
    public int counter = 10;
    Context context;
    public static int dem = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_question);

        Intent intent = getIntent();
        int id = intent.getIntExtra("linhvuc_id",0);
        Bundle bundle = new Bundle();
        bundle.putInt("id_linh_vuc",id);

        tvCauHoi = findViewById(R.id.cauHoi_textView);
        paA_btn = findViewById(R.id.paA_button);
        paB_btn = findViewById(R.id.paB_button);
        paC_btn = findViewById(R.id.paC_button);
        paD_btn = findViewById(R.id.paD_button);
        tv_count_down = findViewById(R.id.tv_display_question_countdown_second);
        new CountDownTimer(10000,1000){
            @Override
            public void onTick(long millisUntilFinished){
                tv_count_down.setText(String.valueOf(counter));
                counter--;
            }
            @Override
            public void onFinish(){
            }
        }.start();




        if(getSupportLoaderManager().getLoader(1)!=null)
            getSupportLoaderManager().initLoader(1,bundle,this);
        getSupportLoaderManager().restartLoader(1,bundle,this);



    }

    public void openDisplayAnswer(View view) {
        Intent intent = new Intent(this, choose_answer.class);
        startActivity(intent);
    }

    @NonNull
    @Override
    public Loader<String> onCreateLoader(int id, @Nullable Bundle args) {
        int id_linh_vuc = args.getInt("id_linh_vuc",0);
        return new CauHoiLoader(this,id_linh_vuc);
    }

    @Override
    public void onLoadFinished(@NonNull Loader<String> loader, String data) {
        try {
            JSONObject jsonObject = new JSONObject(data);
            JSONArray cauHoi_jsonArray = jsonObject.getJSONArray("data");


            for (int i = 0; i < cauHoi_jsonArray.length(); i++) {

                String noiDungCauHoi = cauHoi_jsonArray.getJSONObject(i).getString("noi_dung");
                final String phuongAnA = cauHoi_jsonArray.getJSONObject(i).getString("phuong_an_a");
                String phuongAnB = cauHoi_jsonArray.getJSONObject(i).getString("phuong_an_b");
                String phuongAnC = cauHoi_jsonArray.getJSONObject(i).getString("phuong_an_c");
                String phuongAnD = cauHoi_jsonArray.getJSONObject(i).getString("phuong_an_d");
                final String dap_an = cauHoi_jsonArray.getJSONObject(i).getString("dap_an");

                tvCauHoi.setText(noiDungCauHoi);
                paA_btn.setText(phuongAnA);
                paB_btn.setText(phuongAnB);
                paC_btn.setText(phuongAnC);
                paD_btn.setText(phuongAnD);


                 //Xử lý onclick nút Phương án A

                paA_btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //Đổi màu nút A khi được click
                        if (dem <= 0) {
                            paA_btn.setBackgroundColor(Color.parseColor("#FFC107"));
                            dem++;
                        } else {
                            Toast.makeText(context, "Chỉ được chọn 1 đáp án", Toast.LENGTH_SHORT).show();
                        }
                    }
                });


            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onLoaderReset(@NonNull Loader<String> loader) {

    }

    public void viewDialog(View view) {
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_bar_chart);
        dialog.setCanceledOnTouchOutside(false);
        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,WindowManager.LayoutParams.MATCH_PARENT);
        Button btn = dialog.findViewById(R.id.khanGia_button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();


    }
}
