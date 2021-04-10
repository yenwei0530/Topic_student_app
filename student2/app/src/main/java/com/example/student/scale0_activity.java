package com.example.student;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class scale0_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scale0);
        getSupportActionBar().hide();//關閉標題列


        //宣告Button物件
        Button nextpage=findViewById(R.id.nextpage);

        nextpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳至下一頁面
                Intent intent =new Intent(scale0_activity.this, scale1_activity.class);
                startActivity(intent);
            }
        });
        
    }
}