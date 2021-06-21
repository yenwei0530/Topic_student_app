package com.example.student;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class mood_ter_step7_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mood_ter_step7);
        getSupportActionBar().hide();//關閉標題列

        //宣告TextView物件
        CardView card1=findViewById(R.id.card1);
        CardView card2=findViewById(R.id.card2);
        CardView card3=findViewById(R.id.card3);

        //建立共用變數類別
        GlobalVariable gv = (GlobalVariable)getApplicationContext();


        //寫入資料
        new Thread(new Runnable(){
            @Override
            public void run(){
                MysqlCon con = new MysqlCon();
                con.insertthermometer(gv.getuser(),gv.getter1_1(),gv.getter1_2(),gv.getter1_3(),gv.getter1_4(),gv.getter3_1(),gv.getter6_1());
            }
        }).start();


        //拼圖遊戲觸發事件
        card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳至拼圖遊戲
                Intent intent =new Intent(mood_ter_step7_activity.this, puzzle_start_activity.class);
                startActivity(intent);
            }
        });

        //回主頁觸發事件
        card2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳至主頁面
                Intent intent =new Intent(mood_ter_step7_activity.this,main_activity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_TASK_ON_HOME);
                startActivity(intent);
            }
        });

        //情緒遊戲觸發事件
        card3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳至心情溫度計頁面
                Intent intent =new Intent(mood_ter_step7_activity.this, mood_game_activity.class);
                startActivity(intent);
            }
        });



    }
}