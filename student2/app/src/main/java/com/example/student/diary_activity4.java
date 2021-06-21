package com.example.student;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class diary_activity4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.diary4);
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
                gv.setdiary4("早上");

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
                gv.setdiary4("中午");

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
                gv.setdiary4("下午");

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
                gv.setdiary4("晚上");

            }
        });

        //離開點擊事件
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳至主頁面
                Intent intent =new Intent(diary_activity4.this,main_activity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_TASK_ON_HOME);
                startActivity(intent);
            }
        });

        //下一頁點擊事件
        nextpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳至下一頁面
                Intent intent =new Intent(diary_activity4.this, diary_activity5.class);
                startActivity(intent);

            }
        });

        //上一頁點擊事件
        uppage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //關閉目前頁面
                finish();
            }
        });

    }
}