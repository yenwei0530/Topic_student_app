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

public class mood_ter_activity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mood_ter3);
        getSupportActionBar().hide();//關閉標題列

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

        //宣告LinearLayout物件
        LinearLayout L1=findViewById(R.id.L1);
        LinearLayout L2=findViewById(R.id.L2);
        LinearLayout L3=findViewById(R.id.L3);
        LinearLayout L4=findViewById(R.id.L4);



        //方法4點擊事件
        L4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                g4.setColorFilter(Color.YELLOW);
                //改變其他btn為黑
                g3.setColorFilter(Color.GRAY);
                g2.setColorFilter(Color.GRAY);
                g1.setColorFilter(Color.GRAY);
            }
        });
        //方法3點擊事件
        L3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                g3.setColorFilter(Color.YELLOW);
                //改變其他btn為黑
                g4.setColorFilter(Color.GRAY);
                g2.setColorFilter(Color.GRAY);
                g1.setColorFilter(Color.GRAY);
            }
        });
        //方法2點擊事件
        L2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                g2.setColorFilter(Color.YELLOW);
                //改變其他btn為黑
                g4.setColorFilter(Color.GRAY);
                g3.setColorFilter(Color.GRAY);
                g1.setColorFilter(Color.GRAY);
            }
        });
        //方法1點擊事件
        L1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                g1.setColorFilter(Color.YELLOW);
                //改變其他btn為黑
                g4.setColorFilter(Color.GRAY);
                g3.setColorFilter(Color.GRAY);
                g2.setColorFilter(Color.GRAY);
            }
        });

        //離開點擊事件
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳至主頁面
                Intent intent =new Intent(mood_ter_activity3.this,main_activity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_TASK_ON_HOME);
                startActivity(intent);
            }
        });

        //下一步點擊事件
        nextpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳至下一頁面
                Intent intent =new Intent(mood_ter_activity3.this,mood_ter_activity4.class);
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