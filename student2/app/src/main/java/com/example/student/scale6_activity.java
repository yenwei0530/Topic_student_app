package com.example.student;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class scale6_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scale6);
        getSupportActionBar().hide();//關閉標題列

        //建立共用變數類別
        GlobalVariable gv = (GlobalVariable)getApplicationContext();

        //宣告TextView物件
        TextView t1 =findViewById(R.id.t1);

        //宣告SeekBar物件
        SeekBar seek_bar=findViewById(R.id.seek_bar);

        //宣告Button物件
        Button nextpage=findViewById(R.id.nextpage);
        Button uppage=findViewById(R.id.uppage);



        seek_bar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(progress==1){
                    t1.setText(progress+"從不這樣");
                }
                if(progress==2){
                    t1.setText(progress+"很少這樣");
                }
                if(progress==3){
                    t1.setText(progress+"有時這樣");
                }
                if(progress==4){
                    t1.setText(progress+"經常這樣");
                }
                if(progress==5){
                    t1.setText(progress+"總是這樣");
                }

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        nextpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //將答案存入全域變數
                gv.setscale6(t1.getText().toString());

                //跳至下一頁面
                Intent intent =new Intent(scale6_activity.this, scale7_activity.class);
                startActivity(intent);
            }
        });

        uppage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        
    }
}