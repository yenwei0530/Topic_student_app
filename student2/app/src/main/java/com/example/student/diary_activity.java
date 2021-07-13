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

public class diary_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.diary);
        getSupportActionBar().hide();//關閉標題列

        //建立共用變數類別
        GlobalVariable gv = (GlobalVariable)getApplicationContext();

        //宣告Button物件
        Button next =findViewById(R.id.next);

        //宣告LinearLayout物件
        LinearLayout L1=findViewById(R.id.L1);
        LinearLayout L2=findViewById(R.id.L2);
        LinearLayout L3=findViewById(R.id.L3);
        LinearLayout L4=findViewById(R.id.L4);
        LinearLayout L5=findViewById(R.id.L5);
        LinearLayout L6=findViewById(R.id.L6);
        LinearLayout L7=findViewById(R.id.L7);

        //宣告ImageButton物件
        ImageButton exit =findViewById(R.id.exit);
        ImageButton mood1 =findViewById(R.id.mood1);
        ImageButton mood2 =findViewById(R.id.mood2);
        ImageButton mood3 =findViewById(R.id.mood3);
        ImageButton mood4 =findViewById(R.id.mood4);
        ImageButton mood5 =findViewById(R.id.mood5);
        ImageButton mood6 =findViewById(R.id.mood6);
        ImageButton mood7 =findViewById(R.id.mood7);

        //宣告TextView物件
        TextView txt1 =findViewById(R.id.txt1);
        TextView txt2 =findViewById(R.id.txt2);
        TextView txt3 =findViewById(R.id.txt3);
        TextView txt4 =findViewById(R.id.txt4);
        TextView txt5 =findViewById(R.id.txt5);
        TextView txt6 =findViewById(R.id.txt6);
        TextView txt7 =findViewById(R.id.txt7);
        TextView txt8 =findViewById(R.id.txt8);


        if(gv.getabc().equals("T")){
            txt1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/kai08mz.TTC"));
            txt2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/kai08mz.TTC"));
            txt3.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/kai08mz.TTC"));
            txt4.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/kai08mz.TTC"));
            txt5.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/kai08mz.TTC"));
            txt6.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/kai08mz.TTC"));
            txt7.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/kai08mz.TTC"));
            txt8.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/kai08mz.TTC"));
            next.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/kai08mz.TTC"));
        }else {
            txt1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ZCOOLKuaiLe-Regular.ttf"));
            txt2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ZCOOLKuaiLe-Regular.ttf"));
            txt3.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ZCOOLKuaiLe-Regular.ttf"));
            txt4.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ZCOOLKuaiLe-Regular.ttf"));
            txt5.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ZCOOLKuaiLe-Regular.ttf"));
            txt6.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ZCOOLKuaiLe-Regular.ttf"));
            txt7.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ZCOOLKuaiLe-Regular.ttf"));
            txt8.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ZCOOLKuaiLe-Regular.ttf"));
            next.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ZCOOLKuaiLe-Regular.ttf"));
        }
        //語音
        MediaPlayer mp = MediaPlayer.create(this, R.raw.diary);
        mp.start();

        //情緒7點擊事件
        L7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mood7.setColorFilter(Color.GREEN);
                //改變其他btn為黑
                mood6.setColorFilter(Color.BLACK);
                mood5.setColorFilter(Color.BLACK);
                mood4.setColorFilter(Color.BLACK);
                mood3.setColorFilter(Color.BLACK);
                mood2.setColorFilter(Color.BLACK);
                mood1.setColorFilter(Color.BLACK);
                //將答案存入全域變數
                gv.setdiary1("非常快樂");
            }
        });
        //情緒6點擊事件
        L6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mood6.setColorFilter(Color.GREEN);
                //改變其他btn為黑
                mood7.setColorFilter(Color.BLACK);
                mood5.setColorFilter(Color.BLACK);
                mood4.setColorFilter(Color.BLACK);
                mood3.setColorFilter(Color.BLACK);
                mood2.setColorFilter(Color.BLACK);
                mood1.setColorFilter(Color.BLACK);
                //將答案存入全域變數
                gv.setdiary1("興奮");
            }
        });
        //情緒5點擊事件
        L5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mood5.setColorFilter(Color.GREEN);
                //改變其他btn為黑
                mood7.setColorFilter(Color.BLACK);
                mood6.setColorFilter(Color.BLACK);
                mood4.setColorFilter(Color.BLACK);
                mood3.setColorFilter(Color.BLACK);
                mood2.setColorFilter(Color.BLACK);
                mood1.setColorFilter(Color.BLACK);
                //將答案存入全域變數
                gv.setdiary1("開心");
            }
        });
        //情緒4點擊事件
        L4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mood4.setColorFilter(Color.GREEN);
                //改變其他btn為黑
                mood7.setColorFilter(Color.BLACK);
                mood6.setColorFilter(Color.BLACK);
                mood5.setColorFilter(Color.BLACK);
                mood3.setColorFilter(Color.BLACK);
                mood2.setColorFilter(Color.BLACK);
                mood1.setColorFilter(Color.BLACK);
                //將答案存入全域變數
                gv.setdiary1("良好");
            }
        });
        //情緒3點擊事件
        L3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mood3.setColorFilter(Color.GREEN);
                //改變其他btn為黑
                mood7.setColorFilter(Color.BLACK);
                mood6.setColorFilter(Color.BLACK);
                mood5.setColorFilter(Color.BLACK);
                mood4.setColorFilter(Color.BLACK);
                mood2.setColorFilter(Color.BLACK);
                mood1.setColorFilter(Color.BLACK);
                //將答案存入全域變數
                gv.setdiary1("差勁");
            }
        });
        //情緒2點擊事件
        L2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mood2.setColorFilter(Color.GREEN);
                //改變其他btn為黑
                mood7.setColorFilter(Color.BLACK);
                mood6.setColorFilter(Color.BLACK);
                mood5.setColorFilter(Color.BLACK);
                mood4.setColorFilter(Color.BLACK);
                mood3.setColorFilter(Color.BLACK);
                mood1.setColorFilter(Color.BLACK);
                //將答案存入全域變數
                gv.setdiary1("生氣");
            }
        });
        //情緒1點擊事件
        L1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mood1.setColorFilter(Color.GREEN);
                //改變其他btn為黑
                mood7.setColorFilter(Color.BLACK);
                mood6.setColorFilter(Color.BLACK);
                mood5.setColorFilter(Color.BLACK);
                mood4.setColorFilter(Color.BLACK);
                mood3.setColorFilter(Color.BLACK);
                mood2.setColorFilter(Color.BLACK);
                //將答案存入全域變數
                gv.setdiary1("惱火");
            }
        });

        //離開點擊事件
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               finish();
                mp.pause();
            }
        });

        //下一頁點擊事件
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳至下一頁面
                Intent intent =new Intent(diary_activity.this,diary_activity2.class);
                startActivity(intent);
                mp.pause();
            }
        });



    }
}