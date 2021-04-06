package com.example.student;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class diary_activity11 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.diary11);
        getSupportActionBar().hide();//關閉標題列

        //宣告TextView物件
        CardView card1=findViewById(R.id.card1);
        CardView card2=findViewById(R.id.card2);
        CardView card3=findViewById(R.id.card3);


       /* //拼圖遊戲觸發事件
        card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳至心情溫度計頁面
                Intent intent =new Intent(mood_ter_step7_activity.this, mood_ter_step1_activity.class);
                startActivity(intent);
            }
        });*/

        //回主頁觸發事件
        card2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳至主頁面
                Intent intent =new Intent(diary_activity11.this,main_activity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_TASK_ON_HOME);
                startActivity(intent);
            }
        });

        //情緒遊戲觸發事件
        card3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳至心情溫度計頁面
                Intent intent =new Intent(diary_activity11.this, mood_game_activity.class);
                startActivity(intent);
            }
        });



    }
}