package com.example.student;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class explanation1_activity extends AppCompatActivity {

    TextView txt2,txt3,txt1;
    ImageView imageView5;
    SeekBar  seek_bar;
    Button nextpage;
    Animation atg,packageimg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.explanation1);
        getSupportActionBar().hide();//關閉標題列

        //宣告TextView物件
        txt1=findViewById(R.id.txt1);
        txt2=findViewById(R.id.txt2);
        txt3=findViewById(R.id.txt3);

        //宣告ImageView物件
        imageView5=findViewById(R.id.imageView5);

        //宣告Button物件
        nextpage=findViewById(R.id.nextpage);

        //宣告SeekBar物件
        seek_bar=findViewById(R.id.seek_bar);

        //建立共用變數類別
        GlobalVariable gv = (GlobalVariable)getApplicationContext();

        //是否注音
        if(gv.getabc().equals("T")){
            txt1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/kai08mz.TTC"));
            txt2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/kai08mz.TTC"));
            txt3.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/kai08mz.TTC"));
            nextpage.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/kai08mz.TTC"));
        }else {
            txt1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ZCOOLKuaiLe-Regular.ttf"));
            txt2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ZCOOLKuaiLe-Regular.ttf"));
            txt3.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ZCOOLKuaiLe-Regular.ttf"));
            nextpage.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ZCOOLKuaiLe-Regular.ttf"));

        }

        atg= AnimationUtils.loadAnimation(this, R.anim.atg);
        packageimg= AnimationUtils.loadAnimation(this, R.anim.packageimg);


        seek_bar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                //根據移動SeekBar數值改變文字及圖片
                if(progress==1){
                    txt2.setText("情緒溫度計");
                    txt3.setText("情緒溫度計讓情緒障礙兒童覺察即辨識自己情緒，幫助情緒障礙兒童思考使用冷靜的方法");
                    imageView5.setImageResource(R.drawable.thermometer);

                    imageView5.startAnimation(packageimg);
                    txt2.startAnimation(atg);
                    txt3.startAnimation(atg);
                }else if(progress==2){
                    txt2.setText("心情日記");
                    txt3.setText("紀錄情緒障礙兒童各種事件，讓兒童以文字敘說自己的內在情緒與想法");
                    imageView5.setImageResource(R.drawable.diary);

                    imageView5.startAnimation(packageimg);
                    txt2.startAnimation(atg);
                    txt3.startAnimation(atg);
                }else if(progress==3){
                    txt2.setText("拼圖遊戲");
                    txt3.setText("設計拼圖遊戲，鼓勵兒童完成遊戲");
                    imageView5.setImageResource(R.drawable.jigsaw);

                    imageView5.startAnimation(packageimg);
                    txt2.startAnimation(atg);
                    txt3.startAnimation(atg);
                }else if(progress==4){
                    txt2.setText("認識情緒");
                    txt3.setText("讓兒童從遊戲中，重新認識各種情緒表現");
                    imageView5.setImageResource(R.drawable.mood);

                    imageView5.startAnimation(packageimg);
                    txt2.startAnimation(atg);
                    txt3.startAnimation(atg);
                }else if(progress==5){
                    txt2.setText("上傳影片");
                    txt3.setText("兒童可以將喜歡的影片或音樂連結上傳至自己的空間");
                    imageView5.setImageResource(R.drawable.play);

                    imageView5.startAnimation(packageimg);
                    txt2.startAnimation(atg);
                    txt3.startAnimation(atg);
                }
                else if(progress==6){
                    txt2.setText("我的收藏");
                    txt3.setText("兒童可以隨時隨地播放喜歡的影片或音樂，藉此提升兒童快樂的心情");
                    imageView5.setImageResource(R.drawable.cabinet);

                    imageView5.startAnimation(packageimg);
                    txt2.startAnimation(atg);
                    txt3.startAnimation(atg);
                }else if(progress==7){
                    txt2.setText("個人專區");
                    txt3.setText("將兒童曾經紀錄的心情指數紀錄，並回饋兒童心情進步情形");
                    imageView5.setImageResource(R.drawable.user);

                    imageView5.startAnimation(packageimg);
                    txt2.startAnimation(atg);
                    txt3.startAnimation(atg);
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
                finish();
            }
        });


    }
}