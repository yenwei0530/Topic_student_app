package com.example.student;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class registered_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registered);
        getSupportActionBar().hide();//關閉標題列

        TextView go_login=findViewById(R.id.go_login);
        //我已經有帳號點擊事件
        go_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //關閉頁面
                finish();
            }
        });
    }
}