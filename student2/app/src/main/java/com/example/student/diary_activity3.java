package com.example.student;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class diary_activity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.diary3);
        getSupportActionBar().hide();//關閉標題列

        //宣告LinearLayout物件
        Button next =findViewById(R.id.next);

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
            }
        });

        //下一頁點擊事件
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳至下一頁面
                Intent intent =new Intent(diary_activity3.this,diary_activity4.class);
                startActivity(intent);

            }
        });


    }
}