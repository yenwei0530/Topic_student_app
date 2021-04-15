package com.example.student;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class exit_mood_ter_step1_1_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exit_mood_ter_step1_1);
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
        TextView t7=findViewById(R.id.t7);



        //情緒7點擊事件
        t7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t7.setTextColor(Color.GREEN);
                //改變其他btn為黑
                t6.setTextColor(Color.BLACK);
                t5.setTextColor(Color.BLACK);
                t4.setTextColor(Color.BLACK);
                t3.setTextColor(Color.BLACK);
                t2.setTextColor(Color.BLACK);
                t1.setTextColor(Color.BLACK);
                //將答案存入全域變數
                gv.setexit_ter1_1("7非常快樂");
            }
        });
        //情緒6點擊事件
        t6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t6.setTextColor(Color.GREEN);
                //改變其他btn為黑
                t7.setTextColor(Color.BLACK);
                t5.setTextColor(Color.BLACK);
                t4.setTextColor(Color.BLACK);
                t3.setTextColor(Color.BLACK);
                t2.setTextColor(Color.BLACK);
                t1.setTextColor(Color.BLACK);
                //將答案存入全域變數
                gv.setexit_ter1_1("6興奮");
            }
        });
        //情緒5點擊事件
        t5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t5.setTextColor(Color.GREEN);
                //改變其他btn為黑
                t7.setTextColor(Color.BLACK);
                t6.setTextColor(Color.BLACK);
                t4.setTextColor(Color.BLACK);
                t3.setTextColor(Color.BLACK);
                t2.setTextColor(Color.BLACK);
                t1.setTextColor(Color.BLACK);
                //將答案存入全域變數
                gv.setexit_ter1_1("5開心");
            }
        });
        //情緒4點擊事件
        t4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t4.setTextColor(Color.GREEN);
                //改變其他btn為黑
                t7.setTextColor(Color.BLACK);
                t6.setTextColor(Color.BLACK);
                t5.setTextColor(Color.BLACK);
                t3.setTextColor(Color.BLACK);
                t2.setTextColor(Color.BLACK);
                t1.setTextColor(Color.BLACK);
                //將答案存入全域變數
                gv.setexit_ter1_1("4平靜");
            }
        });
        //情緒3點擊事件
        t3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t3.setTextColor(Color.GREEN);
                //改變其他btn為黑
                t7.setTextColor(Color.BLACK);
                t6.setTextColor(Color.BLACK);
                t5.setTextColor(Color.BLACK);
                t4.setTextColor(Color.BLACK);
                t2.setTextColor(Color.BLACK);
                t1.setTextColor(Color.BLACK);
                //將答案存入全域變數
                gv.setexit_ter1_1("3不高興");
            }
        });
        //情緒2點擊事件
        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t2.setTextColor(Color.GREEN);
                //改變其他btn為黑
                t7.setTextColor(Color.BLACK);
                t6.setTextColor(Color.BLACK);
                t5.setTextColor(Color.BLACK);
                t4.setTextColor(Color.BLACK);
                t3.setTextColor(Color.BLACK);
                t1.setTextColor(Color.BLACK);
                //將答案存入全域變數
                gv.setexit_ter1_1("2憤怒發脾氣");
            }
        });
        //情緒1點擊事件
        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t1.setTextColor(Color.GREEN);
                //改變其他btn為黑
                t7.setTextColor(Color.BLACK);
                t6.setTextColor(Color.BLACK);
                t5.setTextColor(Color.BLACK);
                t4.setTextColor(Color.BLACK);
                t3.setTextColor(Color.BLACK);
                t2.setTextColor(Color.BLACK);
                //將答案存入全域變數
                gv.setexit_ter1_1("1怒氣沖沖失去理智");
            }
        });

        //離開點擊事件
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(exit_mood_ter_step1_1_activity.this,main_activity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_TASK_ON_HOME);
                startActivity(intent);
            }
        });

        //下一步點擊事件
        nextpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳至下一頁面
                Intent intent =new Intent(exit_mood_ter_step1_1_activity.this, exit_mood_ter_step1_2_activity.class);
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