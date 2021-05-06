package com.example.student;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class mood_ter_step1_4_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mood_ter_step1_4);
        getSupportActionBar().hide();//關閉標題列

        //建立共用變數類別
        GlobalVariable gv = (GlobalVariable)getApplicationContext();

        //宣告Button物件
        Button nextpage =findViewById(R.id.nextpage);
        Button uppage =findViewById(R.id.uppage);

        //宣告ImageButton物件
        ImageButton exit =findViewById(R.id.exit);

        //宣告TextView物件
        TextView t1=findViewById(R.id.t1);
        TextView t2=findViewById(R.id.t2);
        TextView t3=findViewById(R.id.t3);
        TextView t4=findViewById(R.id.t4);
        TextView t5=findViewById(R.id.t5);
        TextView t6=findViewById(R.id.t6);


        //預設想打自己
        t1.setBackgroundColor(Color.GREEN);

        //想打自己點擊事件
        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //取TextView顏色背景
                ColorDrawable viewColor = (ColorDrawable) t1.getBackground();
                int colorId = viewColor.getColor();
                //如果是綠色就變白色
                if(colorId==-16711936){
                    t1.setBackgroundColor(Color.WHITE);
                }
                //如果是白色就變綠色
                if(colorId==-1){
                    t1.setBackgroundColor(Color.GREEN);
                }

            }
        });

        //想咬自己點擊事件
        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //取TextView顏色背景
                ColorDrawable viewColor = (ColorDrawable) t2.getBackground();
                int colorId = viewColor.getColor();
                //如果是綠色就變白色
                if(colorId==-16711936){
                    t2.setBackgroundColor(Color.WHITE);
                }
                //如果是白色就變綠色
                if(colorId==-1){
                    t2.setBackgroundColor(Color.GREEN);
                }

            }
        });

        //想打他點擊事件
        t3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //取TextView顏色背景
                ColorDrawable viewColor = (ColorDrawable) t3.getBackground();
                int colorId = viewColor.getColor();
                //如果是綠色就變白色
                if(colorId==-16711936){
                    t3.setBackgroundColor(Color.WHITE);
                }
                //如果是白色就變綠色
                if(colorId==-1){
                    t3.setBackgroundColor(Color.GREEN);
                }

            }
        });

        //想罵他點擊事件
        t4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //取TextView顏色背景
                ColorDrawable viewColor = (ColorDrawable) t4.getBackground();
                int colorId = viewColor.getColor();
                //如果是綠色就變白色
                if(colorId==-16711936){
                    t4.setBackgroundColor(Color.WHITE);
                }
                //如果是白色就變綠色
                if(colorId==-1){
                    t4.setBackgroundColor(Color.GREEN);
                }

            }
        });

        //想撕掉作業簿點擊事件
        t5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //取TextView顏色背景
                ColorDrawable viewColor = (ColorDrawable) t5.getBackground();
                int colorId = viewColor.getColor();
                //如果是綠色就變白色
                if(colorId==-16711936){
                    t5.setBackgroundColor(Color.WHITE);
                }
                //如果是白色就變綠色
                if(colorId==-1){
                    t5.setBackgroundColor(Color.GREEN);
                }

            }
        });

        //想把東西弄壞點擊事件
        t6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //取TextView顏色背景
                ColorDrawable viewColor = (ColorDrawable) t6.getBackground();
                int colorId = viewColor.getColor();
                //如果是綠色就變白色
                if(colorId==-16711936){
                    t6.setBackgroundColor(Color.WHITE);
                }
                //如果是白色就變綠色
                if(colorId==-1){
                    t6.setBackgroundColor(Color.GREEN);
                }

            }
        });


        //離開點擊事件
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(mood_ter_step1_4_activity.this,main_activity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_TASK_ON_HOME);
                startActivity(intent);
            }
        });

        //下一步點擊事件
        nextpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ColorDrawable viewColor = (ColorDrawable) t1.getBackground();
                ColorDrawable viewColor2 = (ColorDrawable) t2.getBackground();
                ColorDrawable viewColor3 = (ColorDrawable) t3.getBackground();
                ColorDrawable viewColor4 = (ColorDrawable) t4.getBackground();
                ColorDrawable viewColor5 = (ColorDrawable) t5.getBackground();
                ColorDrawable viewColor6 = (ColorDrawable) t6.getBackground();
                int colorId = viewColor.getColor();
                int colorId2 = viewColor2.getColor();
                int colorId3 = viewColor3.getColor();
                int colorId4 = viewColor4.getColor();
                int colorId5 = viewColor5.getColor();
                int colorId6 = viewColor6.getColor();
                if(colorId==-1){
                    //將答案存入全域變數
                    gv.setter1_4("");
                }
                if(colorId==-16711936){
                    //將答案存入全域變數
                    gv.setter1_4("想打自己");
                }
                if(colorId2==-16711936){
                    //將答案存入全域變數
                    gv.setter1_4(gv.getter1_4()+",想咬自己");
                }
                if(colorId3==-16711936){
                    //將答案存入全域變數
                    gv.setter1_4(gv.getter1_4()+",想打他");
                }
                if(colorId4==-16711936){
                    //將答案存入全域變數
                    gv.setter1_4(gv.getter1_4()+",想罵他");
                }
                if(colorId5==-16711936){
                    //將答案存入全域變數
                    gv.setter1_4(gv.getter1_4()+",想撕掉作業簿");
                }
                if(colorId6==-16711936){
                    //將答案存入全域變數
                    gv.setter1_4(gv.getter1_4()+",想把東西弄壞");
                }
                //跳至下一頁面
                Intent intent =new Intent(mood_ter_step1_4_activity.this, mood_ter_step2_activity.class);
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