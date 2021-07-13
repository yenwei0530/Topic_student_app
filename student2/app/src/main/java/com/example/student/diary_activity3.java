package com.example.student;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class diary_activity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.diary3);
        getSupportActionBar().hide();//關閉標題列

        //建立共用變數類別
        GlobalVariable gv = (GlobalVariable)getApplicationContext();

        //宣告Button物件
        Button nextpage =findViewById(R.id.nextpage);
        Button uppage =findViewById(R.id.uppage);

        //宣告LinearLayout物件
        LinearLayout L1=findViewById(R.id.L1);
        LinearLayout L2=findViewById(R.id.L2);
        LinearLayout L3=findViewById(R.id.L3);
        LinearLayout L4=findViewById(R.id.L4);

        //宣告ImageButton物件
        ImageButton exit =findViewById(R.id.exit);
        ImageButton ib1 =findViewById(R.id.ib1);
        ImageButton ib2 =findViewById(R.id.ib2);
        ImageButton ib3 =findViewById(R.id.ib3);
        ImageButton ib4 =findViewById(R.id.ib4);

        //宣告TextView物件
        TextView txt1 =findViewById(R.id.txt1);
        TextView txt2 =findViewById(R.id.txt2);
        TextView txt3 =findViewById(R.id.txt3);
        TextView txt4 =findViewById(R.id.txt4);
        TextView txt5 =findViewById(R.id.txt5);

        if(gv.getabc().equals("T")){
            txt1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/kai08mz.TTC"));
            txt2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/kai08mz.TTC"));
            txt3.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/kai08mz.TTC"));
            txt4.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/kai08mz.TTC"));
            txt5.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/kai08mz.TTC"));
            nextpage.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/kai08mz.TTC"));
            uppage.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/kai08mz.TTC"));
        }else {
            txt1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ZCOOLKuaiLe-Regular.ttf"));
            txt2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ZCOOLKuaiLe-Regular.ttf"));
            txt3.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ZCOOLKuaiLe-Regular.ttf"));
            txt4.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ZCOOLKuaiLe-Regular.ttf"));
            txt5.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ZCOOLKuaiLe-Regular.ttf"));
            nextpage.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ZCOOLKuaiLe-Regular.ttf"));
            uppage.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ZCOOLKuaiLe-Regular.ttf"));
        }
        //語音
        MediaPlayer mp = MediaPlayer.create(this, R.raw.diary3);
        mp.start();

        //who1點擊事件
        L1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ib1.setColorFilter(Color.GREEN);
                //改變其他btn為黑
                ib2.setColorFilter(Color.BLACK);
                ib3.setColorFilter(Color.BLACK);
                ib4.setColorFilter(Color.BLACK);
                //將答案存入全域變數
                gv.setdiary3("自己");

            }
        });

        //who2點擊事件
        L2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ib2.setColorFilter(Color.GREEN);
                //改變其他btn為黑
                ib1.setColorFilter(Color.BLACK);
                ib3.setColorFilter(Color.BLACK);
                ib4.setColorFilter(Color.BLACK);
                //將答案存入全域變數
                gv.setdiary3("家人");

            }
        });

        //who3點擊事件
        L3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ib3.setColorFilter(Color.GREEN);
                //改變其他btn為黑
                ib2.setColorFilter(Color.BLACK);
                ib1.setColorFilter(Color.BLACK);
                ib4.setColorFilter(Color.BLACK);
                //將答案存入全域變數
                gv.setdiary3("朋友");

            }
        });

        //who4點擊事件
        L4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ib4.setColorFilter(Color.GREEN);
                //改變其他btn為黑
                ib2.setColorFilter(Color.BLACK);
                ib3.setColorFilter(Color.BLACK);
                ib1.setColorFilter(Color.BLACK);
                //將答案存入全域變數
                gv.setdiary3("老師");

            }
        });
        //離開點擊事件
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳至主頁面
                Intent intent =new Intent(diary_activity3.this,main_activity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_TASK_ON_HOME);
                startActivity(intent);
                mp.pause();
            }
        });

        //下一頁點擊事件
        nextpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳至下一頁面
                Intent intent =new Intent(diary_activity3.this,diary_activity4.class);
                startActivity(intent);
                mp.pause();

            }
        });

        //上一頁點擊事件
        uppage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //關閉目前頁面
                finish();
                mp.pause();
            }
        });


    }
}