package com.example.student;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class logine_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        getSupportActionBar().hide();//關閉標題列

        //宣告TextView物件
        TextView register2=findViewById(R.id.register2);

        //宣告Button物件
        Button sumbit=findViewById(R.id.sumbit);

        //點我註冊觸發事件
        register2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳至註冊頁面
                Intent intent =new Intent(logine_activity.this,registered_activity.class);
                startActivity(intent);
            }
        });

        //登入觸發事件
        sumbit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳至註冊頁面
                Intent intent =new Intent(logine_activity.this,main_activity.class);
                startActivity(intent);
            }
        });

    }
}