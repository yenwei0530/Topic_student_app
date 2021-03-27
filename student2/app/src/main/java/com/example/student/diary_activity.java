package com.example.student;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class diary_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.diary);
        getSupportActionBar().hide();//關閉標題列

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
            }
        });

        //離開點擊事件
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               finish();
            }
        });

        //下一頁點擊事件
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳至下一頁面
                Intent intent =new Intent(diary_activity.this,diary_activity2.class);
                startActivity(intent);
            }
        });



    }
}