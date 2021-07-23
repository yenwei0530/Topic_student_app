package com.example.student;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

public class main_activity extends AppCompatActivity {
    private final String DB_NAME = "treatment.db";
    private String TABLE_NAME = "student";
    private final int DB_VERSION = 1;
    SQLiteDataBaseHelper mDBHelper;

    ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();//取得所有資料

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        getSupportActionBar().hide();//關閉標題列

        //建立共用變數類別
        GlobalVariable gv = (GlobalVariable)getApplicationContext();

        mDBHelper = new SQLiteDataBaseHelper(this, DB_NAME, null, DB_VERSION, TABLE_NAME);//初始化資料庫

        arrayList = mDBHelper.student(gv.getuser());

        //宣告imageview物件
        ImageView exit=findViewById(R.id.exit);


        gv.setname(arrayList.get(0).get("name"));
        gv.setstudentid(arrayList.get(0).get("student_id"));
        gv.setpassword(arrayList.get(0).get("password"));
        gv.setsex(arrayList.get(0).get("sex"));
        gv.setbirthday(arrayList.get(0).get("birthday"));
        Log.v("DB", "寫入資料完成：" + arrayList.get(0).get("student_id"));

        //宣告TextView物件
        TextView text_name=findViewById(R.id.text_name);
        text_name.setText(gv.getname());
        TextView t1=findViewById(R.id.t1);
        TextView t2=findViewById(R.id.t2);
        TextView t3=findViewById(R.id.t3);
        TextView t4=findViewById(R.id.t4);
        TextView t5=findViewById(R.id.t5);
        TextView t6=findViewById(R.id.t6);
        TextView t7=findViewById(R.id.t7);
        TextView t8=findViewById(R.id.t8);
        TextView t9=findViewById(R.id.t9);

        //宣告CardView物件
        CardView card1=findViewById(R.id.card1);
        CardView card2=findViewById(R.id.card2);
        CardView card3=findViewById(R.id.card3);
        CardView card4=findViewById(R.id.card4);
        CardView card5=findViewById(R.id.card5);
        CardView card6=findViewById(R.id.card6);
        CardView card7=findViewById(R.id.card7);
        CardView card8=findViewById(R.id.card8);
        CardView card9=findViewById(R.id.card9);

        //是否注音
        if(gv.getabc().equals("T")){
            text_name.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/kai08mz.TTC"));
            t1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/kai08mz.TTC"));
            t2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/kai08mz.TTC"));
            t3.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/kai08mz.TTC"));
            t4.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/kai08mz.TTC"));
            t5.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/kai08mz.TTC"));
            t6.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/kai08mz.TTC"));
            t7.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/kai08mz.TTC"));
            t8.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/kai08mz.TTC"));
            t9.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/kai08mz.TTC"));
        }else {
            t1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ZCOOLKuaiLe-Regular.ttf"));
            t2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ZCOOLKuaiLe-Regular.ttf"));
            t3.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ZCOOLKuaiLe-Regular.ttf"));
            t4.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ZCOOLKuaiLe-Regular.ttf"));
            t5.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ZCOOLKuaiLe-Regular.ttf"));
            t6.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ZCOOLKuaiLe-Regular.ttf"));
            t7.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ZCOOLKuaiLe-Regular.ttf"));
            t8.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ZCOOLKuaiLe-Regular.ttf"));
            t9.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ZCOOLKuaiLe-Regular.ttf"));
            text_name.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ZCOOLKuaiLe-Regular.ttf"));
        }

        //心情溫度計觸發事件
        card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳至心情溫度計頁面
                Intent intent =new Intent(main_activity.this, mood_ter_step1_activity.class);
                startActivity(intent);
            }
        });

        //心情日記觸發事件
        card2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳至心情日記頁面
                Intent intent =new Intent(main_activity.this,diary_activity.class);
                startActivity(intent);
            }
        });

        //拼圖遊戲觸發事件
        card3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳至上拼圖遊戲
                Intent intent =new Intent(main_activity.this,puzzle_start_activity.class);
                startActivity(intent);
            }
        });

        //認識情緒觸發事件
        card4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳至認識情緒頁面
                Intent intent =new Intent(main_activity.this,mood_game_activity.class);
                startActivity(intent);
            }
        });

        //上傳影片觸發事件
        card5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳至上傳影片頁面
                Intent intent =new Intent(main_activity.this,video_activity.class);
                startActivity(intent);
            }
        });

        //我的收藏庫事件
        card6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳至我的收藏庫頁面
                Intent intent =new Intent(main_activity.this,video_select_activity.class);
                startActivity(intent);
            }
        });



        //個人專區觸發事件
        card7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳至個人專區頁面
                Intent intent =new Intent(main_activity.this,student_information_activity.class);
                startActivity(intent);
            }
        });

        //使用說明觸發事件
        card8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳至個人專區頁面
                Intent intent =new Intent(main_activity.this,explanation1_activity.class);
                startActivity(intent);
            }
        });

        //心情統計觸發事件
        card9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar c = Calendar.getInstance();
                int year = c.get(Calendar.YEAR);
                int month = c.get(Calendar.MONTH);
                int day = c.get(Calendar.DAY_OF_MONTH);
                new DatePickerDialog(main_activity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        month=month+1;
                        gv.setstatistics(year+"-"+month+"-"+dayOfMonth);
                        //跳至心情溫度計頁面
                        Intent intent =new Intent(main_activity.this, mood_statistics_activity.class);
                        startActivity(intent);
                    }
                },year,month,day).show();
            }
        });

        //登出觸發事件
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳至登入頁面
                Intent intent =new Intent(main_activity.this,exit_mood_ter_step1_1_activity.class);
                startActivity(intent);
            }
        });
    }
}