package com.example.student;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class mood_ter_step1_2_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mood_ter_step1_2);
        getSupportActionBar().hide();//關閉標題列

        //建立共用變數類別
        GlobalVariable gv = (GlobalVariable)getApplicationContext();

        //宣告Button物件
        Button nextpage =findViewById(R.id.nextpage);
        Button uppage =findViewById(R.id.uppage);

        //宣告ImageButton物件
        ImageButton exit =findViewById(R.id.exit);

        //宣告Imageview物件
        ImageView g1 =findViewById(R.id.g1);
        ImageView g2 =findViewById(R.id.g2);
        ImageView g3 =findViewById(R.id.g3);
        ImageView g4 =findViewById(R.id.g4);
        ImageView g5 =findViewById(R.id.g5);
        ImageView g6 =findViewById(R.id.g6);
        ImageView g7 =findViewById(R.id.g7);

        //宣告LinearLayout物件
        LinearLayout L1=findViewById(R.id.L1);
        LinearLayout L2=findViewById(R.id.L2);
        LinearLayout L3=findViewById(R.id.L3);
        LinearLayout L4=findViewById(R.id.L4);
        LinearLayout L5=findViewById(R.id.L5);
        LinearLayout L6=findViewById(R.id.L6);
        LinearLayout L7=findViewById(R.id.L7);


        //情緒7點擊事件
        L7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                g7.setColorFilter(Color.YELLOW);
                //改變其他btn為黑
                g6.setColorFilter(Color.GRAY);
                g5.setColorFilter(Color.GRAY);
                g4.setColorFilter(Color.GRAY);
                g3.setColorFilter(Color.GRAY);
                g2.setColorFilter(Color.GRAY);
                g1.setColorFilter(Color.GRAY);
                //將答案存入全域變數
                gv.setter1_2("非常快樂");
            }
        });
        //情緒6點擊事件
        L6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                g6.setColorFilter(Color.YELLOW);
                //改變其他btn為黑
                g7.setColorFilter(Color.GRAY);
                g5.setColorFilter(Color.GRAY);
                g4.setColorFilter(Color.GRAY);
                g3.setColorFilter(Color.GRAY);
                g2.setColorFilter(Color.GRAY);
                g1.setColorFilter(Color.GRAY);
                //將答案存入全域變數
                gv.setter1_2("興奮");
            }
        });
        //情緒5點擊事件
        L5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                g5.setColorFilter(Color.YELLOW);
                //改變其他btn為黑
                g7.setColorFilter(Color.GRAY);
                g6.setColorFilter(Color.GRAY);
                g4.setColorFilter(Color.GRAY);
                g3.setColorFilter(Color.GRAY);
                g2.setColorFilter(Color.GRAY);
                g1.setColorFilter(Color.GRAY);
                //將答案存入全域變數
                gv.setter1_2("開心");
            }
        });
        //情緒4點擊事件
        L4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                g4.setColorFilter(Color.YELLOW);
                //改變其他btn為黑
                g7.setColorFilter(Color.GRAY);
                g6.setColorFilter(Color.GRAY);
                g5.setColorFilter(Color.GRAY);
                g3.setColorFilter(Color.GRAY);
                g2.setColorFilter(Color.GRAY);
                g1.setColorFilter(Color.GRAY);
                //將答案存入全域變數
                gv.setter1_2("平靜");
            }
        });
        //情緒3點擊事件
        L3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                g3.setColorFilter(Color.YELLOW);
                //改變其他btn為黑
                g7.setColorFilter(Color.GRAY);
                g6.setColorFilter(Color.GRAY);
                g5.setColorFilter(Color.GRAY);
                g4.setColorFilter(Color.GRAY);
                g2.setColorFilter(Color.GRAY);
                g1.setColorFilter(Color.GRAY);
                //將答案存入全域變數
                gv.setter1_2("不高興");
            }
        });
        //情緒2點擊事件
        L2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                g2.setColorFilter(Color.YELLOW);
                //改變其他btn為黑
                g7.setColorFilter(Color.GRAY);
                g6.setColorFilter(Color.GRAY);
                g5.setColorFilter(Color.GRAY);
                g4.setColorFilter(Color.GRAY);
                g3.setColorFilter(Color.GRAY);
                g1.setColorFilter(Color.GRAY);
                //將答案存入全域變數
                gv.setter1_2("憤怒發脾氣");
            }
        });
        //情緒1點擊事件
        L1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                g1.setColorFilter(Color.YELLOW);
                //改變其他btn為黑
                g7.setColorFilter(Color.GRAY);
                g6.setColorFilter(Color.GRAY);
                g5.setColorFilter(Color.GRAY);
                g4.setColorFilter(Color.GRAY);
                g3.setColorFilter(Color.GRAY);
                g2.setColorFilter(Color.GRAY);
                //將答案存入全域變數
                gv.setter1_2("怒氣沖沖失去理智");
            }
        });

        //離開點擊事件
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳至主頁面
                Intent intent =new Intent(mood_ter_step1_2_activity.this,main_activity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_TASK_ON_HOME);
                startActivity(intent);
            }
        });

        //下一步點擊事件
        nextpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳至下一頁面
                Intent intent =new Intent(mood_ter_step1_2_activity.this, mood_ter_step1_3_activity.class);
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