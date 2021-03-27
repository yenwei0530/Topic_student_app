package com.example.student;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class main_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        getSupportActionBar().hide();//關閉標題列

        //宣告TextView物件
        CardView card2=findViewById(R.id.card2);
        CardView card4=findViewById(R.id.card4);

        //心情日記觸發事件
        card2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳至心情日記頁面
                Intent intent =new Intent(main_activity.this,diary_activity.class);
                startActivity(intent);
            }
        });

        //認識情緒觸發事件
        card4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳至認識情緒頁面
                Intent intent =new Intent(main_activity.this,mood_game_activity.class);
                startActivity(intent);
            }
        });
    }
}