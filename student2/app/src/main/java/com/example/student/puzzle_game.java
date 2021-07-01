package com.example.student;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Random;

public class puzzle_game extends AppCompatActivity {

    private static GestureDetectGridView mGridView;
    private static Chronometer chronometer;

    private static final int COLUMNS = 3;
    private static final int DIMENSIONS = COLUMNS * COLUMNS;

    private static int mColumnWidth, mColumnHeight;
    private static boolean running;
    public static final String up = "up";
    public static final String down = "down";
    public static final String left = "left";
    public static final String right = "right";
    private static String[] tileList;
    private static int aa;
    private static Activity activity = null;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.puzzle_game);
        getSupportActionBar().hide();//關閉標題列

        //建立共用變數類別
        GlobalVariable gv = (GlobalVariable)getApplicationContext();

        activity = this;
        //碼表
        chronometer =findViewById(R.id.chronometer);
        chronometer.start();

        Button exit  =findViewById(R.id.btn_exit);

        if(gv.getabc().equals("T")){
            exit.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/kai08mz.TTC"));
        }else {
            exit.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ZCOOLKuaiLe-Regular.ttf"));
        }

        init();
        scramble();
        setDimensions();
        aa=(int)(Math.random()* 9);

        //離開
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chronometer.stop();
                finish();
            }
        });

    }

    private void init() {
        mGridView = (GestureDetectGridView) findViewById(R.id.grid);
        mGridView.setNumColumns(COLUMNS);

        tileList = new String[DIMENSIONS];
        for (int i = 0; i < DIMENSIONS; i++) {
            tileList[i] = String.valueOf(i);
        }
    }

    private void scramble() {
        int index;
        String temp;
        Random random = new Random();

        for (int i = tileList.length - 1; i > 0; i--) {
            index = random.nextInt(i + 1);
            temp = tileList[index];
            tileList[index] = tileList[i];
            tileList[i] = temp;
        }
    }

    private void setDimensions() {
        ViewTreeObserver vto = mGridView.getViewTreeObserver();
        vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                mGridView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                int displayWidth = mGridView.getMeasuredWidth();
                int displayHeight = mGridView.getMeasuredHeight();

                int statusbarHeight = getStatusBarHeight(getApplicationContext());
                int requiredHeight = displayHeight - statusbarHeight;

                mColumnWidth = displayWidth / COLUMNS;
                mColumnHeight = requiredHeight / COLUMNS;

                display(getApplicationContext());
            }
        });
    }

    private int getStatusBarHeight(Context context) {
        int result = 0;
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen",
                "android");

        if (resourceId > 0) {
            result = context.getResources().getDimensionPixelSize(resourceId);
        }

        return result;
    }

    private static void display(Context context) {
        ArrayList<Button> buttons = new ArrayList<>();
        Button button;


        if(aa==0){
            for (int i = 0; i < tileList.length; i++) {
                button = new Button(context);

                if (tileList[i].equals("0"))
                    button.setBackgroundResource(R.drawable.p1_1);
                else if (tileList[i].equals("1"))
                    button.setBackgroundResource(R.drawable.p1_2);
                else if (tileList[i].equals("2"))
                    button.setBackgroundResource(R.drawable.p1_3);
                else if (tileList[i].equals("3"))
                    button.setBackgroundResource(R.drawable.p1_4);
                else if (tileList[i].equals("4"))
                    button.setBackgroundResource(R.drawable.p1_5);
                else if (tileList[i].equals("5"))
                    button.setBackgroundResource(R.drawable.p1_6);
                else if (tileList[i].equals("6"))
                    button.setBackgroundResource(R.drawable.p1_7);
                else if (tileList[i].equals("7"))
                    button.setBackgroundResource(R.drawable.p1_8);
                else if (tileList[i].equals("8"))
                    button.setBackgroundResource(R.drawable.p1_9);

                buttons.add(button);
            }
        }

        if(aa==1){
            for (int i = 0; i < tileList.length; i++) {
                button = new Button(context);

                if (tileList[i].equals("0"))
                    button.setBackgroundResource(R.drawable.p2_1);
                else if (tileList[i].equals("1"))
                    button.setBackgroundResource(R.drawable.p2_2);
                else if (tileList[i].equals("2"))
                    button.setBackgroundResource(R.drawable.p2_3);
                else if (tileList[i].equals("3"))
                    button.setBackgroundResource(R.drawable.p2_4);
                else if (tileList[i].equals("4"))
                    button.setBackgroundResource(R.drawable.p2_5);
                else if (tileList[i].equals("5"))
                    button.setBackgroundResource(R.drawable.p2_6);
                else if (tileList[i].equals("6"))
                    button.setBackgroundResource(R.drawable.p2_7);
                else if (tileList[i].equals("7"))
                    button.setBackgroundResource(R.drawable.p2_8);
                else if (tileList[i].equals("8"))
                    button.setBackgroundResource(R.drawable.p2_9);

                buttons.add(button);
            }
        }
        if(aa==2){
            for (int i = 0; i < tileList.length; i++) {
                button = new Button(context);

                if (tileList[i].equals("0"))
                    button.setBackgroundResource(R.drawable.p3_1);
                else if (tileList[i].equals("1"))
                    button.setBackgroundResource(R.drawable.p3_2);
                else if (tileList[i].equals("2"))
                    button.setBackgroundResource(R.drawable.p3_3);
                else if (tileList[i].equals("3"))
                    button.setBackgroundResource(R.drawable.p3_4);
                else if (tileList[i].equals("4"))
                    button.setBackgroundResource(R.drawable.p3_5);
                else if (tileList[i].equals("5"))
                    button.setBackgroundResource(R.drawable.p3_6);
                else if (tileList[i].equals("6"))
                    button.setBackgroundResource(R.drawable.p3_7);
                else if (tileList[i].equals("7"))
                    button.setBackgroundResource(R.drawable.p3_8);
                else if (tileList[i].equals("8"))
                    button.setBackgroundResource(R.drawable.p3_10);

                buttons.add(button);
            }
        }
        if(aa==3){
            for (int i = 0; i < tileList.length; i++) {
                button = new Button(context);

                if (tileList[i].equals("0"))
                    button.setBackgroundResource(R.drawable.p4_1);
                else if (tileList[i].equals("1"))
                    button.setBackgroundResource(R.drawable.p4_2);
                else if (tileList[i].equals("2"))
                    button.setBackgroundResource(R.drawable.p4_3);
                else if (tileList[i].equals("3"))
                    button.setBackgroundResource(R.drawable.p4_4);
                else if (tileList[i].equals("4"))
                    button.setBackgroundResource(R.drawable.p4_5);
                else if (tileList[i].equals("5"))
                    button.setBackgroundResource(R.drawable.p4_6);
                else if (tileList[i].equals("6"))
                    button.setBackgroundResource(R.drawable.p4_6_1);
                else if (tileList[i].equals("7"))
                    button.setBackgroundResource(R.drawable.p4_8);
                else if (tileList[i].equals("8"))
                    button.setBackgroundResource(R.drawable.p4_9);

                buttons.add(button);
            }
        }
        if(aa==4){
            for (int i = 0; i < tileList.length; i++) {
                button = new Button(context);

                if (tileList[i].equals("0"))
                    button.setBackgroundResource(R.drawable.p5_1);
                else if (tileList[i].equals("1"))
                    button.setBackgroundResource(R.drawable.p5_2);
                else if (tileList[i].equals("2"))
                    button.setBackgroundResource(R.drawable.p5_3);
                else if (tileList[i].equals("3"))
                    button.setBackgroundResource(R.drawable.p5_4);
                else if (tileList[i].equals("4"))
                    button.setBackgroundResource(R.drawable.p5_5);
                else if (tileList[i].equals("5"))
                    button.setBackgroundResource(R.drawable.p5_6);
                else if (tileList[i].equals("6"))
                    button.setBackgroundResource(R.drawable.p5_7);
                else if (tileList[i].equals("7"))
                    button.setBackgroundResource(R.drawable.p5_8);
                else if (tileList[i].equals("8"))
                    button.setBackgroundResource(R.drawable.p5_9);

                buttons.add(button);
            }
        }
        if(aa==5){
            for (int i = 0; i < tileList.length; i++) {
                button = new Button(context);

                if (tileList[i].equals("0"))
                    button.setBackgroundResource(R.drawable.p6_1);
                else if (tileList[i].equals("1"))
                    button.setBackgroundResource(R.drawable.p6_2);
                else if (tileList[i].equals("2"))
                    button.setBackgroundResource(R.drawable.p6_3);
                else if (tileList[i].equals("3"))
                    button.setBackgroundResource(R.drawable.p6_4);
                else if (tileList[i].equals("4"))
                    button.setBackgroundResource(R.drawable.p6_5);
                else if (tileList[i].equals("5"))
                    button.setBackgroundResource(R.drawable.p6_6);
                else if (tileList[i].equals("6"))
                    button.setBackgroundResource(R.drawable.p6_7);
                else if (tileList[i].equals("7"))
                    button.setBackgroundResource(R.drawable.p6_8);
                else if (tileList[i].equals("8"))
                    button.setBackgroundResource(R.drawable.p6_9);

                buttons.add(button);
            }
        }
        if(aa==6){
            for (int i = 0; i < tileList.length; i++) {
                button = new Button(context);

                if (tileList[i].equals("0"))
                    button.setBackgroundResource(R.drawable.p7_1);
                else if (tileList[i].equals("1"))
                    button.setBackgroundResource(R.drawable.p7_2);
                else if (tileList[i].equals("2"))
                    button.setBackgroundResource(R.drawable.p7_3);
                else if (tileList[i].equals("3"))
                    button.setBackgroundResource(R.drawable.p7_4);
                else if (tileList[i].equals("4"))
                    button.setBackgroundResource(R.drawable.p7_5);
                else if (tileList[i].equals("5"))
                    button.setBackgroundResource(R.drawable.p7_6);
                else if (tileList[i].equals("6"))
                    button.setBackgroundResource(R.drawable.p7_7);
                else if (tileList[i].equals("7"))
                    button.setBackgroundResource(R.drawable.p7_8);
                else if (tileList[i].equals("8"))
                    button.setBackgroundResource(R.drawable.p7_9);

                buttons.add(button);
            }
        }
        if(aa==7){
            for (int i = 0; i < tileList.length; i++) {
                button = new Button(context);

                if (tileList[i].equals("0"))
                    button.setBackgroundResource(R.drawable.p8_1);
                else if (tileList[i].equals("1"))
                    button.setBackgroundResource(R.drawable.p8_2);
                else if (tileList[i].equals("2"))
                    button.setBackgroundResource(R.drawable.p8_3);
                else if (tileList[i].equals("3"))
                    button.setBackgroundResource(R.drawable.p8_4);
                else if (tileList[i].equals("4"))
                    button.setBackgroundResource(R.drawable.p8_5);
                else if (tileList[i].equals("5"))
                    button.setBackgroundResource(R.drawable.p8_6);
                else if (tileList[i].equals("6"))
                    button.setBackgroundResource(R.drawable.p8_7);
                else if (tileList[i].equals("7"))
                    button.setBackgroundResource(R.drawable.p8_8);
                else if (tileList[i].equals("8"))
                    button.setBackgroundResource(R.drawable.p8_9);

                buttons.add(button);
            }
        }
        if(aa==8){
            for (int i = 0; i < tileList.length; i++) {
                button = new Button(context);

                if (tileList[i].equals("0"))
                    button.setBackgroundResource(R.drawable.p9_1);
                else if (tileList[i].equals("1"))
                    button.setBackgroundResource(R.drawable.p9_2);
                else if (tileList[i].equals("2"))
                    button.setBackgroundResource(R.drawable.p9_3);
                else if (tileList[i].equals("3"))
                    button.setBackgroundResource(R.drawable.p9_4);
                else if (tileList[i].equals("4"))
                    button.setBackgroundResource(R.drawable.p9_5);
                else if (tileList[i].equals("5"))
                    button.setBackgroundResource(R.drawable.p9_6);
                else if (tileList[i].equals("6"))
                    button.setBackgroundResource(R.drawable.p9_7);
                else if (tileList[i].equals("7"))
                    button.setBackgroundResource(R.drawable.p9_8);
                else if (tileList[i].equals("8"))
                    button.setBackgroundResource(R.drawable.p9_9);

                buttons.add(button);
            }
        }

        mGridView.setAdapter(new CustomAdapter(buttons, mColumnWidth, mColumnHeight));
    }

    private static void swap(Context context, int currentPosition, int swap) {
        String newPosition = tileList[currentPosition + swap];
        tileList[currentPosition + swap] = tileList[currentPosition];
        tileList[currentPosition] = newPosition;
        display(context);

        if (isSolved()){
            //Toast.makeText(context, "YOU WIN!", Toast.LENGTH_SHORT).show();
            //實體化layout
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE );
            final View textEntryView = inflater.inflate(R.layout.custom_dialog, null);

            //用setView把layout放進去
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setView(textEntryView);

            //創建一個Dialog
            AlertDialog alert = builder.create();

            //建立共用變數類別
            GlobalVariable gv = (GlobalVariable)context.getApplicationContext();
            //時間計算
            int temp0 = Integer. parseInt ( chronometer.getText().toString().split( ":" )[ 0 ]);
            int temp1 =Integer. parseInt ( chronometer.getText().toString().split( ":" )[ 1 ]);
            int temp=temp0* 60 +temp1;

            //layout中Button結束事件
            Button finsh = (Button) textEntryView.findViewById(R.id.finsh);
            finsh.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //寫入資料
                    new Thread(new Runnable(){
                        @Override
                        public void run(){
                            MysqlCon con = new MysqlCon();
                            con.insertgame(gv.getuser(),"1",String.valueOf(temp));
                        }
                    }).start();
                    puzzle_game.activity.finish();
                }
            });

            //layout中Button繼續事件
            Button ag = (Button) textEntryView.findViewById(R.id.ag);
            ag.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //寫入資料
                    new Thread(new Runnable(){
                        @Override
                        public void run(){
                            MysqlCon con = new MysqlCon();
                            con.insertgame(gv.getuser(),"1",String.valueOf(temp));
                        }
                    }).start();
                    Intent intent = new Intent(context,puzzle_game.class);
                    puzzle_game.activity.finish();
                    activity.startActivity(intent);
                }
            });
            alert.show();
            chronometer.stop();
        }

    }

    public static void moveTiles(Context context, String direction, int position) {

        // Upper-left-corner tile
        if (position == 0) {

            if (direction.equals(right)) swap(context, position, 1);
            else if (direction.equals(down)) swap(context, position, COLUMNS);
            else Toast.makeText(context, "Invalid move", Toast.LENGTH_SHORT).show();

            // Upper-center tiles
        } else if (position > 0 && position < COLUMNS - 1) {
            if (direction.equals(left)) swap(context, position, -1);
            else if (direction.equals(down)) swap(context, position, COLUMNS);
            else if (direction.equals(right)) swap(context, position, 1);
            else Toast.makeText(context, "Invalid move", Toast.LENGTH_SHORT).show();

            // Upper-right-corner tile
        } else if (position == COLUMNS - 1) {
            if (direction.equals(left)) swap(context, position, -1);
            else if (direction.equals(down)) swap(context, position, COLUMNS);
            else Toast.makeText(context, "Invalid move", Toast.LENGTH_SHORT).show();

            // Left-side tiles
        } else if (position > COLUMNS - 1 && position < DIMENSIONS - COLUMNS &&
                position % COLUMNS == 0) {
            if (direction.equals(up)) swap(context, position, -COLUMNS);
            else if (direction.equals(right)) swap(context, position, 1);
            else if (direction.equals(down)) swap(context, position, COLUMNS);
            else Toast.makeText(context, "Invalid move", Toast.LENGTH_SHORT).show();

            // Right-side AND bottom-right-corner tiles
        } else if (position == COLUMNS * 2 - 1 || position == COLUMNS * 3 - 1) {
            if (direction.equals(up)) swap(context, position, -COLUMNS);
            else if (direction.equals(left)) swap(context, position, -1);
            else if (direction.equals(down)) {

                // Tolerates only the right-side tiles to swap downwards as opposed to the bottom-
                // right-corner tile.
                if (position <= DIMENSIONS - COLUMNS - 1) swap(context, position,
                        COLUMNS);
                else Toast.makeText(context, "Invalid move", Toast.LENGTH_SHORT).show();
            } else Toast.makeText(context, "Invalid move", Toast.LENGTH_SHORT).show();

            // Bottom-left corner tile
        } else if (position == DIMENSIONS - COLUMNS) {
            if (direction.equals(up)) swap(context, position, -COLUMNS);
            else if (direction.equals(right)) swap(context, position, 1);
            else Toast.makeText(context, "Invalid move", Toast.LENGTH_SHORT).show();

            // Bottom-center tiles
        } else if (position < DIMENSIONS - 1 && position > DIMENSIONS - COLUMNS) {
            if (direction.equals(up)) swap(context, position, -COLUMNS);
            else if (direction.equals(left)) swap(context, position, -1);
            else if (direction.equals(right)) swap(context, position, 1);
            else Toast.makeText(context, "Invalid move", Toast.LENGTH_SHORT).show();

            // Center tiles
        } else {
            if (direction.equals(up)) swap(context, position, -COLUMNS);
            else if (direction.equals(left)) swap(context, position, -1);
            else if (direction.equals(right)) swap(context, position, 1);
            else swap(context, position, COLUMNS);
        }
    }

    private static boolean isSolved() {
        boolean solved = false;

        for (int i = 0; i < tileList.length; i++) {
            if (tileList[i].equals(String.valueOf(i))) {
                solved = true;
            } else {
                solved = false;
                break;
            }
        }

        return solved;
    }


}
