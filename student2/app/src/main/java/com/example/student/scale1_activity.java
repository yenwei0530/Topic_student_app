package com.example.student;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class scale1_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scale1);
        getSupportActionBar().hide();//關閉標題列

        //宣告TextView物件
        TextView t1 =findViewById(R.id.t1);

        //宣告SeekBar物件
        SeekBar seek_bar=findViewById(R.id.seek_bar);

        //宣告Button物件
        Button nextpage=findViewById(R.id.nextpage);



        seek_bar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(progress==1){
                    t1.setText(progress+"總是這樣");
                }
                if(progress==2){
                    t1.setText(progress+"經常這樣");
                }
                if(progress==3){
                    t1.setText(progress+"有時這樣");
                }
                if(progress==4){
                    t1.setText(progress+"很少這樣");
                }
                if(progress==5){
                    t1.setText(progress+"從不這樣");
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
                //跳至下一頁面
                Intent intent =new Intent(scale1_activity.this, scale2_activity.class);
                startActivity(intent);
            }
        });

        
    }
}