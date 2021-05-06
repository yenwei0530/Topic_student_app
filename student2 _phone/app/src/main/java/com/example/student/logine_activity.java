package com.example.student;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class logine_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        getSupportActionBar().hide();//關閉標題列

        //建立共用變數類別
        GlobalVariable gv = (GlobalVariable)getApplicationContext();

        //宣告Button物件
        Button sumbit=findViewById(R.id.sumbit);

        //宣告EditText物件
        EditText UserId=findViewById(R.id.UserId);
        EditText Password=findViewById(R.id.Password);

        //登入觸發事件
        sumbit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //將帳號密碼存入全域變數
                /*gv.setuser(Integer.parseInt(UserId.getText().toString()));
                gv.setpassword(Password.getText().toString());*/

                //跳至註冊頁面
                Intent intent =new Intent(logine_activity.this,scale0_activity.class);
                startActivity(intent);
            }
        });
    }
}