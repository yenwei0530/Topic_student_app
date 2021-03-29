package com.example.student;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class student_information_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_information);
        getSupportActionBar().hide();//關閉標題列

        //宣告Button物件
        Button exit=findViewById(R.id.exit);

        //返回點擊事件
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //關閉頁面
                finish();
            }
        });
    }
}