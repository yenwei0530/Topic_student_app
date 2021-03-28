package com.example.student;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

public class dirary_activity5 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.diary5);
        getSupportActionBar().hide();//關閉標題列

        //宣告Button物件
        Button nextpage =findViewById(R.id.nextpage);
        Button uppage =findViewById(R.id.uppage);

        //宣告ImageButton物件
        ImageButton exit =findViewById(R.id.exit);

        //宣告ImageView物件
        ImageView imageView=findViewById(R.id.imageView);
        ImageView imageView2=findViewById(R.id.imageView2);
        ImageView imageView3=findViewById(R.id.imageView3);

        //宣告EditText物件
        EditText edt1=findViewById(R.id.edt1);

        //ImageView點擊事件
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] start = {"今天在家裡，", "我喜歡", "最快樂的時候，我會", "我想知道","我最大的恐懼是","每一個媽媽","我覺得","運動","別的小孩","我沒有能"};
                int r = 0;
                r = (int)(Math.random()*9);
                edt1.setText(start[r]);
            }
        });

        //ImageView2點擊事件
        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] start = {"和女生在一起時","將來的日子","我需要","我最棒的時候","使我痛苦的是","在學校裡","唯一的困難","我希望","我的爸爸"};
                int r = 0;
                r = (int)(Math.random()*8);
                edt1.setText(start[r]);
            }
        });

        //ImageView3點擊事件
        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] start = {"我的媽媽","我秘密地","跳舞","多數女孩子","我想成為一個","和男生在一起時","和女生在一起時","這個測驗"};
                int r = 0;
                r = (int)(Math.random()*7);
                edt1.setText(start[r]);
            }
        });

        //離開點擊事件
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳至主頁面
                Intent intent =new Intent(dirary_activity5.this,main_activity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_TASK_ON_HOME);
                startActivity(intent);
            }
        });

        //下一頁點擊事件
        nextpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳至下一頁面
                Intent intent =new Intent(dirary_activity5.this,main_activity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_TASK_ON_HOME);
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