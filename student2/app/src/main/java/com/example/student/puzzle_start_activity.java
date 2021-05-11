package com.example.student;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class puzzle_start_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.puzzle_start);
        getSupportActionBar().hide();//關閉標題列

        //宣告Button物件
        Button nextpage =findViewById(R.id.nextpage);
        Button uppage =findViewById(R.id.uppage);


        //開始點擊事件
        nextpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳至下一頁面
                Intent intent =new Intent(puzzle_start_activity.this, puzzle_game.class);
                startActivity(intent);
            }
        });

        //上一頁點擊事件
        uppage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳至主頁面
                Intent intent =new Intent(puzzle_start_activity.this,main_activity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_TASK_ON_HOME);
                startActivity(intent);
            }
        });



    }
}