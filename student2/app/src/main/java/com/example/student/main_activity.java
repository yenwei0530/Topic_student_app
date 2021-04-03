package com.example.student;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class main_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        getSupportActionBar().hide();//關閉標題列

        //宣告imageview物件
        ImageView exit=findViewById(R.id.exit);

        //宣告TextView物件
        CardView card1=findViewById(R.id.card1);
        CardView card2=findViewById(R.id.card2);
        CardView card4=findViewById(R.id.card4);
        CardView card5=findViewById(R.id.card5);

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

        //認識情緒觸發事件
        card4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳至認識情緒頁面
                Intent intent =new Intent(main_activity.this,mood_game_activity.class);
                startActivity(intent);
            }
        });

        //個人專區觸發事件
        card5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳至個人專區頁面
                Intent intent =new Intent(main_activity.this,student_information_activity.class);
                startActivity(intent);
            }
        });

        //登出觸發事件
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳至登入頁面
                Intent intent =new Intent(main_activity.this,logine_activity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_TASK_ON_HOME);
                startActivity(intent);
            }
        });
    }
}