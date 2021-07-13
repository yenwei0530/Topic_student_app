package com.example.student;

//import android.support.v7.app.AppCompatActivity;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class mood_game_activity extends Activity
{
    public ImageButton imageButton3;
    public ImageButton imageButton4;
    public ImageButton imageButton5;
    public ImageButton imageButton6;
    public ImageButton imageButton7;
    public ImageButton imageButton8;
    public ImageButton imageButton9;
    public ImageButton imageButton10;
    public ImageButton imageButton11;
    public ImageButton imageButton12;
    public ImageButton imageButton13;
    public ImageButton imageButton14;
    public ImageView imageView4;
    public TextView textView16;
    public TextView textView18;
    public TextView textView19;
    public TextView textView20;
    public TextView textView23;
    public TextView textView24;
    public TextView textView25;
    public TextView textView26;
    public TextView textView27;
    public TextView textView28;
    public TextView textView29;
    public TextView textView30;
    public TextView textView32;
    public Button exit;
    public int mode;
    public int total_score = 0;
    public String[] happy;
    public String[] sad;
    public String[] scared;
    public String[] angry;
    public String[] moving;
    public String[] hate;
    public ArrayList<Integer> have_seen;
    private static Chronometer chronometer;

    private static Handler handler;
    private static Runnable runner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mood_game);
        //建立共用變數類別
        GlobalVariable gv = (GlobalVariable)getApplicationContext();

        //宣告TextView物件
        TextView textView7=findViewById(R.id.textView7);
        TextView textView8=findViewById(R.id.textView8);
        TextView textView9=findViewById(R.id.textView9);


        chronometer =findViewById(R.id.chronometer);
        chronometer.start();

        Random rnd = new Random();
        mode = rnd.nextInt(6);
        happy = new String[] {"game_ecstasy","game_happy","game_glad","game_jolly","game_pleasant","game_surprise","game_tension","game_panic","game_fear","game_confound","game_guilt","game_hate"};
        sad = new String[] {"game_disappointed","game_exhausted","game_alone","game_sorrowful","game_wronged","game_sad","game_ecstasy","game_happy","game_glad","game_comfortable","game_relax","game_blessed"};
        scared = new String[] {"game_uneasy","game_worried","game_scared","game_tension","game_panic","game_fear","game_proud","game_calm","game_moving","game_happy","game_pleasant","game_ecstasy"};
        angry = new String[] {"game_setback","game_jealous","game_moot","game_crazy","game_anger","game_angry","game_jolly","game_pleasant","game_relax","game_proud","game_calm","game_comfortable"};
        moving = new String[] {"game_comfortable","game_relax","game_blessed","game_proud","game_calm","game_moving","game_wronged","game_alone","game_sad","game_moot","game_crazy","game_anger",};
        hate = new String[] {"game_awkward","game_bored","game_confound","game_guilt","game_hate","game_shock","game_ecstasy","game_jolly","game_glad","game_moving","game_calm","game_blessed"};
        have_seen = new ArrayList<>(12);
        imageButton3 = (ImageButton) findViewById(R.id.imageButton3);
//        imageButton3.setVisibility(View.INVISIBLE);
        imageButton4 = (ImageButton) findViewById(R.id.imageButton4);
//        imageButton4.setVisibility(View.INVISIBLE);
        imageButton5 = (ImageButton) findViewById(R.id.imageButton5);
//        imageButton5.setVisibility(View.INVISIBLE);
        imageButton6 = (ImageButton) findViewById(R.id.imageButton6);
//        imageButton6.setVisibility(View.INVISIBLE);
        imageButton7 = (ImageButton) findViewById(R.id.imageButton7);
//        imageButton7.setVisibility(View.INVISIBLE);
        imageButton8 = (ImageButton) findViewById(R.id.imageButton8);
//        imageButton8.setVisibility(View.INVISIBLE);
        imageButton9 = (ImageButton) findViewById(R.id.imageButton9);
//        imageButton9.setVisibility(View.INVISIBLE);
        imageButton10 = (ImageButton) findViewById(R.id.imageButton10);
//        imageButton10.setVisibility(View.INVISIBLE);
        imageButton11 = (ImageButton) findViewById(R.id.imageButton11);
//        imageButton11.setVisibility(View.INVISIBLE);
        imageButton12 = (ImageButton) findViewById(R.id.imageButton12);
//        imageButton12.setVisibility(View.INVISIBLE);
        imageButton13 = (ImageButton) findViewById(R.id.imageButton13);
//        imageButton13.setVisibility(View.INVISIBLE);
        imageButton14 = (ImageButton) findViewById(R.id.imageButton14);
//        imageButton14.setVisibility(View.INVISIBLE);
        textView16 = (TextView) findViewById(R.id.textView16);
        textView16.setVisibility(View.INVISIBLE);
        textView18 = (TextView) findViewById(R.id.textView18);
        textView18.setVisibility(View.INVISIBLE);
        textView19 = (TextView) findViewById(R.id.textView19);
        textView19.setVisibility(View.INVISIBLE);
        textView20 = (TextView) findViewById(R.id.textView20);
        textView20.setVisibility(View.INVISIBLE);
        textView23 = (TextView) findViewById(R.id.textView23);
        textView23.setVisibility(View.INVISIBLE);
        textView24 = (TextView) findViewById(R.id.textView24);
        textView24.setVisibility(View.INVISIBLE);
        textView25 = (TextView) findViewById(R.id.textView25);
        textView25.setVisibility(View.INVISIBLE);
        textView26 = (TextView) findViewById(R.id.textView26);
        textView26.setVisibility(View.INVISIBLE);
        textView27 = (TextView) findViewById(R.id.textView27);
        textView27.setVisibility(View.INVISIBLE);
        textView28 = (TextView) findViewById(R.id.textView28);
        textView28.setVisibility(View.INVISIBLE);
        textView29 = (TextView) findViewById(R.id.textView29);
        textView29.setVisibility(View.INVISIBLE);
        textView30 = (TextView) findViewById(R.id.textView30);
        textView30.setVisibility(View.INVISIBLE);
        textView32 = (TextView) findViewById(R.id.textView32);
        exit= (Button) findViewById(R.id.exit);
        imageView4=(ImageView) findViewById(R.id.imageView4);


        if(gv.getabc().equals("T")){
            textView7.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/kai08mz.TTC"));
            textView8.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/kai08mz.TTC"));
            textView9.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/kai08mz.TTC"));
            textView32.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/kai08mz.TTC"));
            exit.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/kai08mz.TTC"));
        }else {
            textView7.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ZCOOLKuaiLe-Regular.ttf"));
            textView8.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ZCOOLKuaiLe-Regular.ttf"));
            textView9.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ZCOOLKuaiLe-Regular.ttf"));
            textView32.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ZCOOLKuaiLe-Regular.ttf"));
            exit.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ZCOOLKuaiLe-Regular.ttf"));
        }

        final ArrayList<String> happyMood = new ArrayList<>();
        happyMood.add("game_ecstasy");
        happyMood.add("game_happy");
        happyMood.add("game_glad");
        happyMood.add("game_jolly");
        happyMood.add("game_pleasant");
        happyMood.add("game_surprise");
        final ArrayList<String> scaredMood = new ArrayList<>();
        scaredMood.add("game_uneasy");
        scaredMood.add("game_worried");
        scaredMood.add("game_scared");
        scaredMood.add("game_tension");
        scaredMood.add("game_panic");
        scaredMood.add("game_fear");
        final ArrayList<String> hateMood = new ArrayList<>();
        hateMood.add("game_awkward");
        hateMood.add("game_bored");
        hateMood.add("game_confound");
        hateMood.add("game_guilt");
        hateMood.add("game_hate");
        hateMood.add("game_shock");
        final ArrayList<String> movingMood = new ArrayList<>();
        movingMood.add("game_blessed");
        movingMood.add("game_calm");
        movingMood.add("game_comfortable");
        movingMood.add("game_moving");
        movingMood.add("game_proud");
        movingMood.add("game_relax");
        final ArrayList<String> sadMood = new ArrayList<>();
        sadMood.add("game_alone");
        sadMood.add("game_disappointed");
        sadMood.add("game_exhausted");
        sadMood.add("game_sad");
        sadMood.add("game_wronged");
        sadMood.add("game_sorrowful");
        final ArrayList<String> angryMood = new ArrayList<>();
        angryMood.add("game_angry");
        angryMood.add("game_anger");
        angryMood.add("game_crazy");
        angryMood.add("game_jealous");
        angryMood.add("game_moot");
        angryMood.add("game_setback");

        final ArrayList<TextView> textViews = new ArrayList<>();
        textViews.add(textView16);
        textViews.add(textView18);
        textViews.add(textView19);
        textViews.add(textView20);
        textViews.add(textView23);
        textViews.add(textView24);
        textViews.add(textView25);
        textViews.add(textView26);
        textViews.add(textView27);
        textViews.add(textView28);
        textViews.add(textView29);
        textViews.add(textView30);

        final ArrayList<ImageButton> imageButtons = new ArrayList<>();
        imageButtons.add(imageButton3);
        imageButtons.add(imageButton4);
        imageButtons.add(imageButton5);
        imageButtons.add(imageButton6);
        imageButtons.add(imageButton7);
        imageButtons.add(imageButton8);
        imageButtons.add(imageButton9);
        imageButtons.add(imageButton10);
        imageButtons.add(imageButton11);
        imageButtons.add(imageButton12);
        imageButtons.add(imageButton13);
        imageButtons.add(imageButton14);



        imageButton3.setOnClickListener(new ImageButton.OnClickListener(){
            public void onClick(View v){
                imageButton3.setVisibility(View.INVISIBLE);
                if(mode==0){
                    print_imagebutton_res_name(imageButton3, textViews.get(10), textView32, sadMood);
                }
                else if(mode==1){
                    print_imagebutton_res_name(imageButton3, textViews.get(10),textView32, happyMood);
                }
                else if(mode==2){
                    print_imagebutton_res_name(imageButton3, textViews.get(10),textView32, angryMood);
                }
                else if(mode==3){
                    print_imagebutton_res_name(imageButton3, textViews.get(10),textView32, scaredMood);
                }
                else if(mode==4){
                    print_imagebutton_res_name(imageButton3, textViews.get(10),textView32, movingMood);
                }
                else if(mode==5){
                    print_imagebutton_res_name(imageButton3, textViews.get(10),textView32, hateMood);
                }

            }
        });
        imageButton4.setOnClickListener(new ImageButton.OnClickListener(){
            public void onClick(View v){
                imageButton4.setVisibility(View.INVISIBLE);
                if(mode==0){
                    print_imagebutton_res_name(imageButton4, textViews.get(9),textView32, sadMood);
                }
                else if(mode==1){
                    print_imagebutton_res_name(imageButton4, textViews.get(9),textView32, happyMood);
                }
                else if(mode==2){
                    print_imagebutton_res_name(imageButton4, textViews.get(9),textView32, angryMood);
                }
                else if(mode==3){
                    print_imagebutton_res_name(imageButton4, textViews.get(9),textView32, scaredMood);
                }
                else if(mode==4){
                    print_imagebutton_res_name(imageButton4, textViews.get(9),textView32, movingMood);
                }
                else if(mode==5){
                    print_imagebutton_res_name(imageButton4, textViews.get(9),textView32, hateMood);
                }
            }
        });
        imageButton5.setOnClickListener(new ImageButton.OnClickListener(){
            public void onClick(View v){
                imageButton5.setVisibility(View.INVISIBLE);
                if(mode==0){
                    print_imagebutton_res_name(imageButton5, textViews.get(11),textView32, sadMood);
                }
                else if(mode==1){
                    print_imagebutton_res_name(imageButton5, textViews.get(11),textView32, happyMood);
                }
                else if(mode==2){
                    print_imagebutton_res_name(imageButton5, textViews.get(11),textView32, angryMood);
                }
                else if(mode==3){
                    print_imagebutton_res_name(imageButton5, textViews.get(11),textView32, scaredMood);
                }
                else if(mode==4){
                    print_imagebutton_res_name(imageButton5, textViews.get(11),textView32, movingMood);
                }
                else if(mode==5){
                    print_imagebutton_res_name(imageButton5, textViews.get(11),textView32, hateMood);
                }
            }
        });
        imageButton6.setOnClickListener(new ImageButton.OnClickListener(){
            public void onClick(View v){
                imageButton6.setVisibility(View.INVISIBLE);
                if(mode==0){
                    print_imagebutton_res_name(imageButton6, textViews.get(6),textView32, sadMood);
                }
                else if(mode==1){
                    print_imagebutton_res_name(imageButton6, textViews.get(6),textView32, happyMood);
                }
                else if(mode==2){
                    print_imagebutton_res_name(imageButton6, textViews.get(6),textView32, angryMood);
                }
                else if(mode==3){
                    print_imagebutton_res_name(imageButton6, textViews.get(6),textView32, scaredMood);
                }
                else if(mode==4){
                    print_imagebutton_res_name(imageButton6, textViews.get(6),textView32, movingMood);
                }
                else if(mode==5){
                    print_imagebutton_res_name(imageButton6, textViews.get(6),textView32, hateMood);
                }
            }
        });
        imageButton7.setOnClickListener(new ImageButton.OnClickListener(){
            public void onClick(View v){
                imageButton7.setVisibility(View.INVISIBLE);
                if(mode==0){
                    print_imagebutton_res_name(imageButton7, textViews.get(7),textView32, sadMood);
                }
                else if(mode==1){
                    print_imagebutton_res_name(imageButton7, textViews.get(7),textView32, happyMood);
                }
                else if(mode==2){
                    print_imagebutton_res_name(imageButton7, textViews.get(7),textView32, angryMood);
                }
                else if(mode==3){
                    print_imagebutton_res_name(imageButton7, textViews.get(7),textView32, scaredMood);
                }
                else if(mode==4){
                    print_imagebutton_res_name(imageButton7, textViews.get(7),textView32, movingMood);
                }
                else if(mode==5){
                    print_imagebutton_res_name(imageButton7, textViews.get(7),textView32, hateMood);
                }
            }
        });
        imageButton8.setOnClickListener(new ImageButton.OnClickListener(){
            public void onClick(View v){
                imageButton8.setVisibility(View.INVISIBLE);
                if(mode==0){
                    print_imagebutton_res_name(imageButton8, textViews.get(8),textView32, sadMood);
                }
                else if(mode==1){
                    print_imagebutton_res_name(imageButton8, textViews.get(8),textView32, happyMood);
                }
                else if(mode==2){
                    print_imagebutton_res_name(imageButton8, textViews.get(8),textView32, angryMood);
                }
                else if(mode==3){
                    print_imagebutton_res_name(imageButton8, textViews.get(8),textView32, scaredMood);
                }
                else if(mode==4){
                    print_imagebutton_res_name(imageButton8, textViews.get(8),textView32, movingMood);
                }
                else if(mode==5){
                    print_imagebutton_res_name(imageButton8, textViews.get(8),textView32, hateMood);
                }
            }
        });
        imageButton9.setOnClickListener(new ImageButton.OnClickListener(){
            public void onClick(View v){
                imageButton9.setVisibility(View.INVISIBLE);
                if(mode==0){
                    print_imagebutton_res_name(imageButton9, textViews.get(3),textView32, sadMood);
                }
                else if(mode==1){
                    print_imagebutton_res_name(imageButton9, textViews.get(3),textView32, happyMood);
                }
                else if(mode==2){
                    print_imagebutton_res_name(imageButton9, textViews.get(3),textView32, angryMood);
                }
                else if(mode==3){
                    print_imagebutton_res_name(imageButton9, textViews.get(3),textView32, scaredMood);
                }
                else if(mode==4){
                    print_imagebutton_res_name(imageButton9, textViews.get(3),textView32, movingMood);
                }
                else if(mode==5){
                    print_imagebutton_res_name(imageButton9, textViews.get(3),textView32, hateMood);
                }
            }
        });
        imageButton10.setOnClickListener(new ImageButton.OnClickListener(){
            public void onClick(View v){
                imageButton10.setVisibility(View.INVISIBLE);
                if(mode==0){
                    print_imagebutton_res_name(imageButton10, textViews.get(4),textView32, sadMood);
                }
                else if(mode==1){
                    print_imagebutton_res_name(imageButton10, textViews.get(4),textView32, happyMood);
                }
                else if(mode==2){
                    print_imagebutton_res_name(imageButton10, textViews.get(4),textView32, angryMood);
                }
                else if(mode==3){
                    print_imagebutton_res_name(imageButton10, textViews.get(4),textView32, scaredMood);
                }
                else if(mode==4){
                    print_imagebutton_res_name(imageButton10, textViews.get(4),textView32, movingMood);
                }
                else if(mode==5){
                    print_imagebutton_res_name(imageButton10, textViews.get(4),textView32, hateMood);
                }
            }
        });
        imageButton11.setOnClickListener(new ImageButton.OnClickListener(){
            public void onClick(View v){
                imageButton11.setVisibility(View.INVISIBLE);
                if(mode==0){
                    print_imagebutton_res_name(imageButton11, textViews.get(5),textView32, sadMood);
                }
                else if(mode==1){
                    print_imagebutton_res_name(imageButton11, textViews.get(5),textView32, happyMood);
                }
                else if(mode==2){
                    print_imagebutton_res_name(imageButton11, textViews.get(5), textView32,angryMood);
                }
                else if(mode==3){
                    print_imagebutton_res_name(imageButton11, textViews.get(5),textView32, scaredMood);
                }
                else if(mode==4){
                    print_imagebutton_res_name(imageButton11, textViews.get(5),textView32, movingMood);
                }
                else if(mode==5){
                    print_imagebutton_res_name(imageButton11, textViews.get(5),textView32, hateMood);
                }
            }
        });
        imageButton12.setOnClickListener(new ImageButton.OnClickListener(){
            public void onClick(View v){
                imageButton12.setVisibility(View.INVISIBLE);
                if(mode==0){
                    print_imagebutton_res_name(imageButton12, textViews.get(1),textView32, sadMood);
                }
                else if(mode==1){
                    print_imagebutton_res_name(imageButton12, textViews.get(1),textView32, happyMood);
                }
                else if(mode==2){
                    print_imagebutton_res_name(imageButton12, textViews.get(1),textView32, angryMood);
                }
                else if(mode==3){
                    print_imagebutton_res_name(imageButton12, textViews.get(1),textView32, scaredMood);
                }
                else if(mode==4){
                    print_imagebutton_res_name(imageButton12, textViews.get(1),textView32, movingMood);
                }
                else if(mode==5){
                    print_imagebutton_res_name(imageButton12, textViews.get(1),textView32, hateMood);
                }
            }
        });
        imageButton13.setOnClickListener(new ImageButton.OnClickListener(){
            public void onClick(View v){
                imageButton13.setVisibility(View.INVISIBLE);
                if(mode==0){
                    print_imagebutton_res_name(imageButton13, textViews.get(2),textView32, sadMood);
                }
                else if(mode==1){
                    print_imagebutton_res_name(imageButton13, textViews.get(2),textView32, happyMood);
                }
                else if(mode==2){
                    print_imagebutton_res_name(imageButton13, textViews.get(2),textView32, angryMood);
                }
                else if(mode==3){
                    print_imagebutton_res_name(imageButton13, textViews.get(2),textView32, scaredMood);
                }
                else if(mode==4){
                    print_imagebutton_res_name(imageButton13, textViews.get(2),textView32, movingMood);
                }
                else if(mode==5){
                    print_imagebutton_res_name(imageButton13, textViews.get(2), textView32,hateMood);
                }
            }
        });
        imageButton14.setOnClickListener(new ImageButton.OnClickListener(){
            public void onClick(View v){
                imageButton14.setVisibility(View.INVISIBLE);
                if(mode==0){
                    print_imagebutton_res_name(imageButton14, textViews.get(0),textView32, sadMood);
                }
                else if(mode==1){
                    print_imagebutton_res_name(imageButton14, textViews.get(0),textView32, happyMood);
                }
                else if(mode==2){
                    print_imagebutton_res_name(imageButton14, textViews.get(0),textView32, angryMood);
                }
                else if(mode==3){
                    print_imagebutton_res_name(imageButton14, textViews.get(0),textView32, scaredMood);
                }
                else if(mode==4){
                    print_imagebutton_res_name(imageButton14, textViews.get(0),textView32, movingMood);
                }
                else if(mode==5){
                    print_imagebutton_res_name(imageButton14, textViews.get(0),textView32, hateMood);
                }
            }
        });
        init_game(mode);

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳至主頁面
                Intent intent =new Intent(mood_game_activity.this,main_activity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_TASK_ON_HOME);
                startActivity(intent);
            }
        });
    }

    private void init_game(int mode){
        System.out.println(mode);
        have_seen.clear();
        total_score = 0;
        textView32.setText("總分 : 0");
        // set title
        imageButton3.setVisibility(View.VISIBLE);
        imageButton4.setVisibility(View.VISIBLE);
        imageButton5.setVisibility(View.VISIBLE);
        imageButton6.setVisibility(View.VISIBLE);
        imageButton7.setVisibility(View.VISIBLE);
        imageButton8.setVisibility(View.VISIBLE);
        imageButton9.setVisibility(View.VISIBLE);
        imageButton10.setVisibility(View.VISIBLE);
        imageButton11.setVisibility(View.VISIBLE);
        imageButton12.setVisibility(View.VISIBLE);
        imageButton13.setVisibility(View.VISIBLE);
        imageButton14.setVisibility(View.VISIBLE);


        if(mode==0){
            TextView title = findViewById(R.id.textView8);
            title.setText("難過");
            title.setTextColor(Color.parseColor("#5A5AAD"));
            imageView4.setImageResource(R.drawable.sad_game);
            //語音
            MediaPlayer mp = MediaPlayer.create(this, R.raw.mood_game);
            mp.start();
        }
        else if(mode==1){
            TextView title = findViewById(R.id.textView8);
            title.setText("快樂");
            title.setTextColor(Color.parseColor("#FF0000"));
            imageView4.setImageResource(R.drawable.smile_game);
            //語音
            MediaPlayer mp = MediaPlayer.create(this, R.raw.mood_game2);
            mp.start();
        }
        else if(mode==2){
            TextView title = findViewById(R.id.textView8);
            title.setText("生氣");
            title.setTextColor(Color.parseColor("#000079"));
            imageView4.setImageResource(R.drawable.angry_game);
            //語音
            MediaPlayer mp = MediaPlayer.create(this, R.raw.mood_game3);
            mp.start();
        }
        else if(mode==3){
            TextView title = findViewById(R.id.textView8);
            title.setText("害怕");
            title.setTextColor(Color.parseColor("#930093"));
            imageView4.setImageResource(R.drawable.scare_game);
            //語音
            MediaPlayer mp = MediaPlayer.create(this, R.raw.mood_game4);
            mp.start();
        }
        else if(mode==4){
            TextView title = findViewById(R.id.textView8);
            title.setText("感動");
            title.setTextColor(Color.parseColor("#FF0080"));
            imageView4.setImageResource(R.drawable.thank_you_game);
            //語音
            MediaPlayer mp = MediaPlayer.create(this, R.raw.mood_game5);
            mp.start();
        }
        else if(mode==5){
            TextView title = findViewById(R.id.textView8);
            title.setText("討厭");
            title.setTextColor(Color.parseColor("#009100"));
            imageView4.setImageResource(R.drawable.hate_game);
            //語音
            MediaPlayer mp = MediaPlayer.create(this, R.raw.mood_game6);
            mp.start();
        }


        // set visible
//        for (int i = 0; i < 5; i++) {
//            generator();
//        }

        // set picture
        for (int i = 1; i < 13; i++) {
            if (mode==0){
                random_switch_image(i, sad, have_seen);
            }
            else if(mode==1){
                random_switch_image(i, happy, have_seen);
            }
            else if(mode==2){
                random_switch_image(i, angry, have_seen);
            }
            else if(mode==3){
                random_switch_image(i, scared, have_seen);
            }
            else if(mode==4){
                random_switch_image(i, moving, have_seen);
            }
            else if(mode==5){
                random_switch_image(i, hate, have_seen);
            }
        }
    }

    private void print_imagebutton_res_name(ImageButton imagebotton, final TextView textView, TextView show_score, ArrayList moods){
        Boolean got_score = false;
        for (int i = 0
             ; i<moods.size(); i++) {
            if (imagebotton.getTag().toString() == moods.get(i)) {
                total_score += 1;
                got_score = true;
                textView.setText("+1");
                System.out.println("總分 : " + Integer.toString(total_score));
                show_score.setText("總分 : " + Integer.toString(total_score));
                textView.setVisibility(View.VISIBLE);
                if(total_score == 6){
                    //停止計時
                    chronometer.stop();

                    //實體化layout
                    LayoutInflater inflater=this.getLayoutInflater();
                    final View textEntryView = inflater.inflate(R.layout.custom_dialog, null);

                    //用setView把layout放進去
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setView(textEntryView);

                    //創建一個Dialog
                    AlertDialog alert = builder.create();
                    //建立共用變數類別
                    GlobalVariable gv = (GlobalVariable)getApplicationContext();
                    //時間計算
                    int temp0 = Integer. parseInt (chronometer.getText().toString().split( ":" )[ 0 ]);
                    int temp1 =Integer. parseInt (chronometer.getText().toString().split( ":" )[ 1 ]);
                    int temp=temp0* 60 +temp1;

                    //layout中Button結束事件
                    TextView t1=(TextView) textEntryView.findViewById(R.id.t1);
                    TextView t2=(TextView) textEntryView.findViewById(R.id.t2);
                    Button finsh = (Button) textEntryView.findViewById(R.id.finsh);
                    Button ag = (Button) textEntryView.findViewById(R.id.ag);

                    if(gv.getabc().equals("T")){
                        t1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/kai08mz.TTC"));
                        t2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/kai08mz.TTC"));
                        finsh.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/kai08mz.TTC"));
                        ag.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/kai08mz.TTC"));
                    }else {
                        t1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ZCOOLKuaiLe-Regular.ttf"));
                        t2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ZCOOLKuaiLe-Regular.ttf"));
                        finsh.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ZCOOLKuaiLe-Regular.ttf"));
                        ag.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ZCOOLKuaiLe-Regular.ttf"));
                    }
                    finsh.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            //寫入資料
                            new Thread(new Runnable(){
                                @Override
                                public void run(){
                                    MysqlCon con = new MysqlCon();
                                    con.insertgame(gv.getuser(),"2",String.valueOf(temp));
                                }
                            }).start();
                            finish();
                        }
                    });

                    //layout中Button繼續事件
                    ag.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            //寫入資料
                            new Thread(new Runnable(){
                                @Override
                                public void run(){
                                    MysqlCon con = new MysqlCon();
                                    con.insertgame(gv.getuser(),"2",String.valueOf(temp));
                                }
                            }).start();
                            chronometer.setBase(SystemClock.elapsedRealtime());
                            chronometer.start();
                            mode = (mode + 1) % 6;
                            init_game(mode);
                            alert.cancel();
                        }
                    });
                    alert.show();
                }
                textView.postDelayed(
                        new Runnable() {
                            @Override
                            public void run() {
                                textView.setVisibility(View.INVISIBLE);


                            }
                        }, 3000);
            }
        }
        if(!got_score){
            textView.setText("+0");
            textView.setVisibility(View.VISIBLE);
            textView.postDelayed(
                    new Runnable() {
                        @Override
                        public void run() {
                            textView.setVisibility(View.INVISIBLE);
                        }
                    }, 3000);
        }
    }
    protected final static int getResourceID(final String resName, final String resType, final Context ctx)
    {
        final int ResourceID =
                ctx.getResources().getIdentifier(resName, resType,
                        ctx.getApplicationInfo().packageName);
        if (ResourceID == 0)
        {

           throw new IllegalArgumentException("No resource string found with name " + resName);
        }
        else
        {
            return ResourceID;
        }

    }

    public void random_switch_image(int imagebutton_num, String[] topic, ArrayList<Integer> have_seen){
        Random rnd = new Random();
        int index = 0;
        while (true){
            index = rnd.nextInt(12);
            if(!have_seen.contains(index)){
                break;
            }
        }
        have_seen.add(index);

        final String str = topic[index]; //"img_" + rnd.nextInt(11);


        switch (imagebutton_num) {
            case 1:
                imageButton3.setImageDrawable(
                        getResources().getDrawable(getResourceID(str, "drawable", getApplicationContext()))
                );
                imageButton3.setTag(str);

                break;
            case 2:
                imageButton4.setImageDrawable(
                        getResources().getDrawable(getResourceID(str, "drawable", getApplicationContext()))
                );
                imageButton4.setTag(str);

                break;
            case 3:
                imageButton5.setImageDrawable(
                        getResources().getDrawable(getResourceID(str, "drawable", getApplicationContext()))
                );
                imageButton5.setTag(str);

                break;
            case 4:
                imageButton6.setImageDrawable(
                        getResources().getDrawable(getResourceID(str, "drawable", getApplicationContext()))
                );
                imageButton6.setTag(str);

                break;
            case 5:
                imageButton7.setImageDrawable(
                        getResources().getDrawable(getResourceID(str, "drawable", getApplicationContext()))
                );
                imageButton7.setTag(str);

                break;
            case 6:
                imageButton8.setImageDrawable(
                        getResources().getDrawable(getResourceID(str, "drawable", getApplicationContext()))
                );
                imageButton8.setTag(str);

                break;
            case 7:
                imageButton9.setImageDrawable(
                        getResources().getDrawable(getResourceID(str, "drawable", getApplicationContext()))
                );
                imageButton9.setTag(str);

                break;
            case 8:
                imageButton10.setImageDrawable(
                        getResources().getDrawable(getResourceID(str, "drawable", getApplicationContext()))
                );
                imageButton10.setTag(str);

                break;
            case 9:
                imageButton11.setImageDrawable(
                        getResources().getDrawable(getResourceID(str, "drawable", getApplicationContext()))
                );
                imageButton11.setTag(str);

                break;
            case 10:
                imageButton12.setImageDrawable(
                        getResources().getDrawable(getResourceID(str, "drawable", getApplicationContext()))
                );
                imageButton12.setTag(str);

                break;
            case 11:
                imageButton13.setImageDrawable(
                        getResources().getDrawable(getResourceID(str, "drawable", getApplicationContext()))
                );
                imageButton13.setTag(str);

                break;
            case 12:
                imageButton14.setImageDrawable(
                        getResources().getDrawable(getResourceID(str, "drawable", getApplicationContext()))
                );
                imageButton14.setTag(str);

                break;
        }
    }

    public void generator () {
        Random rand = new Random();
        int number = rand.nextInt(12)+1;

        switch (number){
            case 1:
                imageButton3 = (ImageButton) findViewById(R.id.imageButton3);
                imageButton3.setVisibility(View.VISIBLE);

                break;
            case 2:
                imageButton4 = (ImageButton) findViewById(R.id.imageButton4);
                imageButton4.setVisibility(View.VISIBLE);

                break;
            case 3:
                imageButton5 = (ImageButton) findViewById(R.id.imageButton5);
                imageButton5.setVisibility(View.VISIBLE);

                break;
            case 4:
                imageButton6 = (ImageButton) findViewById(R.id.imageButton6);
                imageButton6.setVisibility(View.VISIBLE);

                break;
            case 5:
                imageButton7 = (ImageButton) findViewById(R.id.imageButton7);
                imageButton7.setVisibility(View.VISIBLE);

                break;
            case 6:
                imageButton8 = (ImageButton) findViewById(R.id.imageButton8);
                imageButton8.setVisibility(View.VISIBLE);

                break;
            case 7:
                imageButton9 = (ImageButton) findViewById(R.id.imageButton9);
                imageButton9.setVisibility(View.VISIBLE);

                break;
            case 8:
                imageButton10 = (ImageButton) findViewById(R.id.imageButton10);
                imageButton10.setVisibility(View.VISIBLE);

                break;
            case 9:
                imageButton11 = (ImageButton) findViewById(R.id.imageButton11);
                imageButton11.setVisibility(View.VISIBLE);

                break;
            case 10:
                imageButton12 = (ImageButton) findViewById(R.id.imageButton12);
                imageButton12.setVisibility(View.VISIBLE);

                break;
            case 11:
                imageButton13 = (ImageButton) findViewById(R.id.imageButton13);
                imageButton13.setVisibility(View.VISIBLE);

                break;
            case 12:
                imageButton14 = (ImageButton) findViewById(R.id.imageButton14);
                imageButton14.setVisibility(View.VISIBLE);

                break;
        }
    }

}
