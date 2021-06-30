package com.example.student;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class main_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        getSupportActionBar().hide();//關閉標題列

        //宣告imageview物件
        ImageView exit=findViewById(R.id.exit);

        //建立共用變數類別
        GlobalVariable gv = (GlobalVariable)getApplicationContext();

        //宣告TextView物件
        TextView text_name=findViewById(R.id.text_name);
        text_name.setText(gv.getname());

        //宣告CardView物件
        CardView card1=findViewById(R.id.card1);
        CardView card2=findViewById(R.id.card2);
        CardView card3=findViewById(R.id.card3);
        CardView card4=findViewById(R.id.card4);
        CardView card5=findViewById(R.id.card5);
        CardView card6=findViewById(R.id.card6);
        CardView card7=findViewById(R.id.card7);
        CardView card8=findViewById(R.id.card8);

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