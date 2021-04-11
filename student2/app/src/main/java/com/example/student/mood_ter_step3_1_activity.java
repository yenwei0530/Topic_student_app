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

public class mood_ter_step3_1_activity extends AppCompatActivity {

    //宣告全域變數紀錄選擇的方法，預設選擇第一個方法
    public Integer cool = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mood_ter_step3_1);
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
                //改變其他cool為4
                cool=4;
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
                //改變其他cool為3
                cool=3;
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
                //改變其他cool為2
                cool=2;
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
                //改變其他cool為1
                cool=1;
            }
        });

        //離開點擊事件
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳至主頁面
                Intent intent =new Intent(mood_ter_step3_1_activity.this,main_activity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_TASK_ON_HOME);
                startActivity(intent);
            }
        });

        //下一步點擊事件
        nextpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳至選擇的方法頁面
                if(cool==1){
                    //如果cool是1，跳至提醒自己的話
                    Intent intent =new Intent(mood_ter_step3_1_activity.this,mood_ter_cool_activity.class);
                    startActivity(intent);
                    //將答案存入全域變數
                    gv.setter3_1("提醒自己的話");
                }
                if(cool==2){
                    //如果cool是2，跳至放鬆訓練
                    Intent intent =new Intent(mood_ter_step3_1_activity.this,mood_ter_cool_activity2.class);
                    startActivity(intent);
                    //將答案存入全域變數
                    gv.setter3_1("放鬆訓練");
                }
                if(cool==3){
                    //如果cool是3，跳至想像法
                    Intent intent =new Intent(mood_ter_step3_1_activity.this,mood_ter_cool_activity3.class);
                    startActivity(intent);
                    //將答案存入全域變數
                    gv.setter3_1("想像法");
                }
                if(cool==4){
                    //如果cool是，跳至轉移注意力
                    Intent intent =new Intent(mood_ter_step3_1_activity.this,mood_ter_cool_activity4.class);
                    startActivity(intent);
                    //將答案存入全域變數
                    gv.setter3_1("轉移注意力");
                }

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