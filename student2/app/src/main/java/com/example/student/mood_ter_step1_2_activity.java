package com.example.student;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class mood_ter_step1_2_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mood_ter_step1_2);
        getSupportActionBar().hide();//關閉標題列

        //建立共用變數類別
        GlobalVariable gv = (GlobalVariable)getApplicationContext();

        //宣告Button物件
        Button nextpage =findViewById(R.id.nextpage);
        Button uppage =findViewById(R.id.uppage);

        //宣告ImageButton物件
        ImageButton exit =findViewById(R.id.exit);

        //宣告Imageview物件
        ImageView g1 =findViewById(R.id.g1);
        ImageView g2 =findViewById(R.id.g2);
        ImageView g3 =findViewById(R.id.g3);
        ImageView g4 =findViewById(R.id.g4);
        ImageView g5 =findViewById(R.id.g5);
        ImageView g6 =findViewById(R.id.g6);
        ImageView g7 =findViewById(R.id.g7);

        //宣告LinearLayout物件
        LinearLayout L1=findViewById(R.id.L1);
        LinearLayout L2=findViewById(R.id.L2);
        LinearLayout L3=findViewById(R.id.L3);
        LinearLayout L4=findViewById(R.id.L4);
        LinearLayout L5=findViewById(R.id.L5);
        LinearLayout L6=findViewById(R.id.L6);
        LinearLayout L7=findViewById(R.id.L7);
        LinearLayout LL1=findViewById(R.id.LL1);
        LinearLayout LL2=findViewById(R.id.LL2);
        LinearLayout LL3=findViewById(R.id.LL3);
        LinearLayout LL4=findViewById(R.id.LL4);
        LinearLayout LL5=findViewById(R.id.LL5);
        LinearLayout LL6=findViewById(R.id.LL6);
        LinearLayout LL7=findViewById(R.id.LL7);

        //宣告TextView物件
        TextView txt1=findViewById(R.id.txt1);

        if(gv.getabc().equals("T")){
            txt1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/kai08mz.TTC"));
            nextpage.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/kai08mz.TTC"));
            uppage.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/kai08mz.TTC"));
        }else {
            txt1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ZCOOLKuaiLe-Regular.ttf"));
            nextpage.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ZCOOLKuaiLe-Regular.ttf"));
            uppage.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ZCOOLKuaiLe-Regular.ttf"));
        }

        //閃爍動畫
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.alpha);

        //依照前一頁面以圖形核對心情
        if(gv.getter1_1()=="7非常快樂"){
            LL7.startAnimation(animation);
            g7.setVisibility(View.VISIBLE);
            gv.setter1_2("非常快樂");
        }
        else  if(gv.getter1_1()=="6興奮"){
            LL6.startAnimation(animation);
            g6.setVisibility(View.VISIBLE);
            gv.setter1_2("興奮");
        }
        else  if(gv.getter1_1()=="5開心"){
            LL5.startAnimation(animation);
            g5.setVisibility(View.VISIBLE);
            gv.setter1_2("開心");
        }
        else  if(gv.getter1_1()=="4平靜"){
            LL4.startAnimation(animation);
            g4.setVisibility(View.VISIBLE);
            gv.setter1_2("平靜");
        }
        else  if(gv.getter1_1()=="3不高興"){
            LL3.startAnimation(animation);
            g3.setVisibility(View.VISIBLE);
            gv.setter1_2("不高興");
        }
        else  if(gv.getter1_1()=="2憤怒發脾氣"){
            LL2.startAnimation(animation);
            g2.setVisibility(View.VISIBLE);
            gv.setter1_2("憤怒發脾氣");
        }
        else  if(gv.getter1_1()=="1怒氣沖沖失去理智"){
            LL1.startAnimation(animation);
            g1.setVisibility(View.VISIBLE);
            gv.setter1_2("怒氣沖沖失去理智");
        }

        //情緒7點擊事件
        L7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //啟用動畫
                LL7.startAnimation(animation);
                //關閉其他動畫
                LL6.clearAnimation();
                LL5.clearAnimation();
                LL4.clearAnimation();
                LL3.clearAnimation();
                LL2.clearAnimation();
                LL1.clearAnimation();
                //顯示
                g7.setVisibility(View.VISIBLE);
                //隱藏
                g6.setVisibility(View.INVISIBLE);
                g5.setVisibility(View.INVISIBLE);
                g4.setVisibility(View.INVISIBLE);
                g3.setVisibility(View.INVISIBLE);
                g2.setVisibility(View.INVISIBLE);
                g1.setVisibility(View.INVISIBLE);
                //將答案存入全域變數
                gv.setter1_2("非常快樂");

                if(gv.getter1_1()!="7非常快樂"){
                    //實體化layout
                    LayoutInflater inflater=getLayoutInflater();
                    final View textEntryView = inflater.inflate(R.layout.custom_dialog2, null);

                    //用setView把layout放進去
                    AlertDialog.Builder builder = new AlertDialog.Builder(mood_ter_step1_2_activity.this);
                    builder.setView(textEntryView);

                    //創建一個Dialog
                    AlertDialog alert = builder.create();

                    //layout中Button結束事件
                    TextView t1=(TextView) textEntryView.findViewById(R.id.t1);
                    TextView t2=(TextView) textEntryView.findViewById(R.id.t2);
                    Button finsh = (Button) textEntryView.findViewById(R.id.finsh);

                    if(gv.getabc().equals("T")){
                        t1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/kai08mz.TTC"));
                        t2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/kai08mz.TTC"));
                        finsh.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/kai08mz.TTC"));
                    }else {
                        t1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ZCOOLKuaiLe-Regular.ttf"));
                        t2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ZCOOLKuaiLe-Regular.ttf"));
                        finsh.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ZCOOLKuaiLe-Regular.ttf"));
                    }
                    finsh.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            finish();
                        }
                    });
                    alert.show();
                }
            }
        });
        //情緒6點擊事件
        L6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //啟用動畫
                LL6.startAnimation(animation);
                //關閉其他動畫
                LL7.clearAnimation();
                LL5.clearAnimation();
                LL4.clearAnimation();
                LL3.clearAnimation();
                LL2.clearAnimation();
                LL1.clearAnimation();
                //顯示
                g6.setVisibility(View.VISIBLE);
                //改變其他btn為黑
                g7.setVisibility(View.INVISIBLE);
                g5.setVisibility(View.INVISIBLE);
                g4.setVisibility(View.INVISIBLE);
                g3.setVisibility(View.INVISIBLE);
                g2.setVisibility(View.INVISIBLE);
                g1.setVisibility(View.INVISIBLE);
                //將答案存入全域變數
                gv.setter1_2("興奮");

                if(gv.getter1_1()!="6興奮"){
                    //實體化layout
                    LayoutInflater inflater=getLayoutInflater();
                    final View textEntryView = inflater.inflate(R.layout.custom_dialog2, null);

                    //用setView把layout放進去
                    AlertDialog.Builder builder = new AlertDialog.Builder(mood_ter_step1_2_activity.this);
                    builder.setView(textEntryView);

                    //創建一個Dialog
                    AlertDialog alert = builder.create();

                    //layout中Button結束事件
                    TextView t1=(TextView) textEntryView.findViewById(R.id.t1);
                    TextView t2=(TextView) textEntryView.findViewById(R.id.t2);
                    Button finsh = (Button) textEntryView.findViewById(R.id.finsh);

                    if(gv.getabc().equals("T")){
                        t1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/kai08mz.TTC"));
                        t2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/kai08mz.TTC"));
                        finsh.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/kai08mz.TTC"));
                    }else {
                        t1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ZCOOLKuaiLe-Regular.ttf"));
                        t2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ZCOOLKuaiLe-Regular.ttf"));
                        finsh.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ZCOOLKuaiLe-Regular.ttf"));
                    }
                    finsh.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            finish();
                        }
                    });
                    alert.show();
                }
            }
        });
        //情緒5點擊事件
        L5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //啟用動畫
                LL5.startAnimation(animation);
                //關閉其他動畫
                LL7.clearAnimation();
                LL6.clearAnimation();
                LL4.clearAnimation();
                LL3.clearAnimation();
                LL2.clearAnimation();
                LL1.clearAnimation();
                //顯示
                g5.setVisibility(View.VISIBLE);
                //改變其他btn為黑
                g7.setVisibility(View.INVISIBLE);
                g6.setVisibility(View.INVISIBLE);
                g4.setVisibility(View.INVISIBLE);
                g3.setVisibility(View.INVISIBLE);
                g2.setVisibility(View.INVISIBLE);
                g1.setVisibility(View.INVISIBLE);
                //將答案存入全域變數
                gv.setter1_2("開心");

                if(gv.getter1_1()!="5開心"){
                    //實體化layout
                    LayoutInflater inflater=getLayoutInflater();
                    final View textEntryView = inflater.inflate(R.layout.custom_dialog2, null);

                    //用setView把layout放進去
                    AlertDialog.Builder builder = new AlertDialog.Builder(mood_ter_step1_2_activity.this);
                    builder.setView(textEntryView);

                    //創建一個Dialog
                    AlertDialog alert = builder.create();

                    //layout中Button結束事件
                    TextView t1=(TextView) textEntryView.findViewById(R.id.t1);
                    TextView t2=(TextView) textEntryView.findViewById(R.id.t2);
                    Button finsh = (Button) textEntryView.findViewById(R.id.finsh);

                    if(gv.getabc().equals("T")){
                        t1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/kai08mz.TTC"));
                        t2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/kai08mz.TTC"));
                        finsh.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/kai08mz.TTC"));
                    }else {
                        t1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ZCOOLKuaiLe-Regular.ttf"));
                        t2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ZCOOLKuaiLe-Regular.ttf"));
                        finsh.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ZCOOLKuaiLe-Regular.ttf"));
                    }
                    finsh.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            finish();
                        }
                    });
                    alert.show();
                }
            }
        });
        //情緒4點擊事件
        L4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //啟用動畫
                LL4.startAnimation(animation);
                //關閉其他動畫
                LL7.clearAnimation();
                LL5.clearAnimation();
                LL6.clearAnimation();
                LL3.clearAnimation();
                LL2.clearAnimation();
                LL1.clearAnimation();
                //顯示
                g4.setVisibility(View.VISIBLE);
                //改變其他btn為黑
                g7.setVisibility(View.INVISIBLE);
                g6.setVisibility(View.INVISIBLE);
                g5.setVisibility(View.INVISIBLE);
                g3.setVisibility(View.INVISIBLE);
                g2.setVisibility(View.INVISIBLE);
                g1.setVisibility(View.INVISIBLE);
                //將答案存入全域變數
                gv.setter1_2("平靜");

                if(gv.getter1_1()!="4平靜"){
                    //實體化layout
                    LayoutInflater inflater=getLayoutInflater();
                    final View textEntryView = inflater.inflate(R.layout.custom_dialog2, null);

                    //用setView把layout放進去
                    AlertDialog.Builder builder = new AlertDialog.Builder(mood_ter_step1_2_activity.this);
                    builder.setView(textEntryView);

                    //創建一個Dialog
                    AlertDialog alert = builder.create();

                    //layout中Button結束事件
                    TextView t1=(TextView) textEntryView.findViewById(R.id.t1);
                    TextView t2=(TextView) textEntryView.findViewById(R.id.t2);
                    Button finsh = (Button) textEntryView.findViewById(R.id.finsh);

                    if(gv.getabc().equals("T")){
                        t1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/kai08mz.TTC"));
                        t2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/kai08mz.TTC"));
                        finsh.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/kai08mz.TTC"));
                    }else {
                        t1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ZCOOLKuaiLe-Regular.ttf"));
                        t2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ZCOOLKuaiLe-Regular.ttf"));
                        finsh.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ZCOOLKuaiLe-Regular.ttf"));
                    }
                    finsh.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            finish();
                        }
                    });
                    alert.show();
                }
            }
        });
        //情緒3點擊事件
        L3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //啟用動畫
                LL3.startAnimation(animation);
                //關閉其他動畫
                LL7.clearAnimation();
                LL5.clearAnimation();
                LL4.clearAnimation();
                LL6.clearAnimation();
                LL2.clearAnimation();
                LL1.clearAnimation();
                //顯示
                g3.setVisibility(View.VISIBLE);
                //改變其他btn為黑
                g7.setVisibility(View.INVISIBLE);
                g6.setVisibility(View.INVISIBLE);
                g5.setVisibility(View.INVISIBLE);
                g4.setVisibility(View.INVISIBLE);
                g2.setVisibility(View.INVISIBLE);
                g1.setVisibility(View.INVISIBLE);
                //將答案存入全域變數
                gv.setter1_2("不高興");

                if(gv.getter1_1()!="3不高興"){
                    //實體化layout
                    LayoutInflater inflater=getLayoutInflater();
                    final View textEntryView = inflater.inflate(R.layout.custom_dialog2, null);

                    //用setView把layout放進去
                    AlertDialog.Builder builder = new AlertDialog.Builder(mood_ter_step1_2_activity.this);
                    builder.setView(textEntryView);

                    //創建一個Dialog
                    AlertDialog alert = builder.create();

                    //layout中Button結束事件
                    TextView t1=(TextView) textEntryView.findViewById(R.id.t1);
                    TextView t2=(TextView) textEntryView.findViewById(R.id.t2);
                    Button finsh = (Button) textEntryView.findViewById(R.id.finsh);

                    if(gv.getabc().equals("T")){
                        t1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/kai08mz.TTC"));
                        t2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/kai08mz.TTC"));
                        finsh.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/kai08mz.TTC"));
                    }else {
                        t1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ZCOOLKuaiLe-Regular.ttf"));
                        t2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ZCOOLKuaiLe-Regular.ttf"));
                        finsh.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ZCOOLKuaiLe-Regular.ttf"));
                    }
                    finsh.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            finish();
                        }
                    });
                    alert.show();
                }
            }
        });
        //情緒2點擊事件
        L2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //啟用動畫
                LL2.startAnimation(animation);
                //關閉其他動畫
                LL7.clearAnimation();
                LL5.clearAnimation();
                LL4.clearAnimation();
                LL3.clearAnimation();
                LL6.clearAnimation();
                LL1.clearAnimation();
                //顯示
                g2.setVisibility(View.VISIBLE);
                //改變其他btn為黑
                g7.setVisibility(View.INVISIBLE);
                g6.setVisibility(View.INVISIBLE);
                g5.setVisibility(View.INVISIBLE);
                g4.setVisibility(View.INVISIBLE);
                g3.setVisibility(View.INVISIBLE);
                g1.setVisibility(View.INVISIBLE);
                //將答案存入全域變數
                gv.setter1_2("憤怒發脾氣");

                if(gv.getter1_1()!="2憤怒發脾氣"){
                    //實體化layout
                    LayoutInflater inflater=getLayoutInflater();
                    final View textEntryView = inflater.inflate(R.layout.custom_dialog2, null);

                    //用setView把layout放進去
                    AlertDialog.Builder builder = new AlertDialog.Builder(mood_ter_step1_2_activity.this);
                    builder.setView(textEntryView);

                    //創建一個Dialog
                    AlertDialog alert = builder.create();

                    //layout中Button結束事件
                    TextView t1=(TextView) textEntryView.findViewById(R.id.t1);
                    TextView t2=(TextView) textEntryView.findViewById(R.id.t2);
                    Button finsh = (Button) textEntryView.findViewById(R.id.finsh);

                    if(gv.getabc().equals("T")){
                        t1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/kai08mz.TTC"));
                        t2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/kai08mz.TTC"));
                        finsh.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/kai08mz.TTC"));
                    }else {
                        t1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ZCOOLKuaiLe-Regular.ttf"));
                        t2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ZCOOLKuaiLe-Regular.ttf"));
                        finsh.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ZCOOLKuaiLe-Regular.ttf"));
                    }
                    finsh.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            finish();
                        }
                    });
                    alert.show();
                }
            }
        });
        //情緒1點擊事件
        L1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //啟用動畫
                LL1.startAnimation(animation);
                //關閉其他動畫
                LL7.clearAnimation();
                LL5.clearAnimation();
                LL4.clearAnimation();
                LL3.clearAnimation();
                LL2.clearAnimation();
                LL6.clearAnimation();
                //顯示
                g1.setVisibility(View.VISIBLE);
                //改變其他btn為黑
                g7.setVisibility(View.INVISIBLE);
                g6.setVisibility(View.INVISIBLE);
                g5.setVisibility(View.INVISIBLE);
                g4.setVisibility(View.INVISIBLE);
                g3.setVisibility(View.INVISIBLE);
                g2.setVisibility(View.INVISIBLE);
                //將答案存入全域變數
                gv.setter1_2("怒氣沖沖失去理智");

                if(gv.getter1_1()!="1怒氣沖沖失去理智"){
                    //實體化layout
                    LayoutInflater inflater=getLayoutInflater();
                    final View textEntryView = inflater.inflate(R.layout.custom_dialog2, null);

                    //用setView把layout放進去
                    AlertDialog.Builder builder = new AlertDialog.Builder(mood_ter_step1_2_activity.this);
                    builder.setView(textEntryView);

                    //創建一個Dialog
                    AlertDialog alert = builder.create();

                    //layout中Button結束事件
                    TextView t1=(TextView) textEntryView.findViewById(R.id.t1);
                    TextView t2=(TextView) textEntryView.findViewById(R.id.t2);
                    Button finsh = (Button) textEntryView.findViewById(R.id.finsh);

                    if(gv.getabc().equals("T")){
                        t1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/kai08mz.TTC"));
                        t2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/kai08mz.TTC"));
                        finsh.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/kai08mz.TTC"));
                    }else {
                        t1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ZCOOLKuaiLe-Regular.ttf"));
                        t2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ZCOOLKuaiLe-Regular.ttf"));
                        finsh.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ZCOOLKuaiLe-Regular.ttf"));
                    }
                    finsh.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            finish();
                        }
                    });
                    alert.show();
                }
            }
        });

        //離開點擊事件
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳至主頁面
                Intent intent =new Intent(mood_ter_step1_2_activity.this,main_activity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_TASK_ON_HOME);
                startActivity(intent);
            }
        });

        //下一步點擊事件
        nextpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳至下一頁面
                Intent intent =new Intent(mood_ter_step1_2_activity.this, mood_ter_step1_3_activity.class);
                startActivity(intent);
            }
        });

        //上一頁點擊事件
        uppage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //關閉目前頁面
                finish();
            }
        });



    }
}