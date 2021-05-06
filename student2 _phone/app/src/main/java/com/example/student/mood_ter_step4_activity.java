package com.example.student;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class mood_ter_step4_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mood_ter_step4);
        getSupportActionBar().hide();//關閉標題列

        //宣告Button物件
        Button nextpage =findViewById(R.id.nextpage);
        Button uppage =findViewById(R.id.uppage);



        //下一步點擊事件
        nextpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳至下一頁面
                Intent intent =new Intent(mood_ter_step4_activity.this, mood_ter_step4_1_activity.class);
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