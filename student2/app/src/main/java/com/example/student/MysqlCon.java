package com.example.student;

import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

public class MysqlCon {

    // 伺服器資料庫定義
    String mysql_ip = "184.168.97.99";
    int mysql_port = 3306; // Port 預設為 3306
    String db_name = "treatment";
    String url = "jdbc:mysql://" + mysql_ip + ":" + mysql_port + "/" + db_name + "?serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=utf-8";
    String db_user = "spopob8v48s2";
    String db_password = "Mm35176661";


    public void run() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Log.v("DB", "加載驅動成功");
        } catch (ClassNotFoundException e) {
            Log.e("DB", "加載驅動失敗");
            return;
        }

        // 連接資料庫
        try {
            Connection con = DriverManager.getConnection(url, db_user, db_password);
            Log.v("DB", "遠端連接成功");
        } catch (SQLException e) {
            Log.e("DB", "遠端連接失敗");
            Log.e("DB", e.toString());
        }
    }



    //取得student
    public ArrayList<HashMap<String, String>> getstudent() {
        ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();
        try {
            Connection con = DriverManager.getConnection(url, db_user, db_password);
            String sql = "SELECT * FROM student ";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next())
            {
                HashMap<String, String> hashMap = new HashMap<>();

                String student_id = rs.getString("student_id");
                String password = rs.getString("password");
                String student_name = rs.getString("student_name");
                String student_year = rs.getString("student_year");
                String student_class = rs.getString("student_class");
                String mom_year = rs.getString("mom_year");
                String father_year = rs.getString("father_year");
                String birthday = rs.getString("birthday");
                String sex = rs.getString("sex");

                hashMap.put("student_id", student_id);
                hashMap.put("password", password);
                hashMap.put("student_name", student_name);
                hashMap.put("student_year", student_year);
                hashMap.put("student_class", student_class);
                hashMap.put("mom_year", mom_year);
                hashMap.put("father_year", father_year);
                hashMap.put("birthday", birthday);
                hashMap.put("sex", sex);

                arrayList.add(hashMap);
            }
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    //取得student數量
    public String getstudentcount() {
        String data = "";
        try {
            Connection con = DriverManager.getConnection(url, db_user, db_password);
            String sql = "SELECT COUNT(*)  FROM `student` ";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                String count = rs.getString("COUNT(*)");
                data = count;
            }
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return data;
    }
    //寫入社會適應量表
    public void insertscale(String id, String q1, String q2, String q3, String q4, String q5, String q6, String q7, String q8, String q9, String q10) {
        try {
            SimpleDateFormat sDateFormat = null;
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                sDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            }
            String date = null;
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                date = sDateFormat.format(new java.util.Date());
            }

            Connection con = DriverManager.getConnection(url, db_user, db_password);
            String sql = "INSERT INTO `adaptation_scale_w`(`student_id`, `q1`, `q2`, `q3`, `q4`, `q5`, `q6`, `q7`, `q8`, `q9`, `q10`, `write_time`) VALUES('" + id + "','" + q1 + "','" + q2 + "','" + q3 + "','" + q4 + "','" + q5 + "','" + q6 + "','" + q7 + "','" + q8 + "','" + q9 + "','" + q10 + "','" + date + "')";
            Statement st = con.createStatement();
            st.executeUpdate(sql);
            st.close();
            Log.v("DB", "寫入資料完成：" + sql);
        } catch (SQLException e) {
            e.printStackTrace();
            Log.e("DB", "寫入資料失敗");
            Log.e("DB", e.toString());
        }
    }
    //寫入情緒溫度計
    public void insertthermometer(String id, String ter1_1, String ter1_2, String ter1_3, String ter1_4, String ter3_1, String ter6_1) {
        try {
            SimpleDateFormat sDateFormat = null;
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                sDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            }
            String date = null;
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                date = sDateFormat.format(new java.util.Date());
            }

            Connection con = DriverManager.getConnection(url, db_user, db_password);
            String sql = "INSERT INTO `mood_thermometer`(`student_id`, `tmmt_mood1`, `tmmt_mood2`, `tmmt_body`, `tmmt_idea`, `tmmt_calmidea`, `tmmt_mood3`, `write_time`) VALUES('" + id + "','" + ter1_1 + "','" + ter1_2 + "','" + ter1_3 + "','" + ter1_4 + "','" + ter3_1 + "','" + ter6_1 + "','" +  date + "')";
            Statement st = con.createStatement();
            st.executeUpdate(sql);
            st.close();
            Log.v("DB", "寫入資料完成：" + sql);
        } catch (SQLException e) {
            e.printStackTrace();
            Log.e("DB", "寫入資料失敗");
            Log.e("DB", e.toString());
        }
    }
    //寫入心情日記
    public void insertdiary(String id, String diary1, String diary2, String diary3, String diary4, String diary5, String diary6, String diary7, String diary8, String diary9_start, String diary9_end, int diary10) {
        try {
            SimpleDateFormat sDateFormat = null;
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                sDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            }
            String date = null;
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                date = sDateFormat.format(new java.util.Date());
            }

            Connection con = DriverManager.getConnection(url, db_user, db_password);
            String sql = "INSERT INTO `diary`(`student_id`, `mood`, `weather`, `person`, `time`, `content`, `content2`, `content3`, `content4`, `write_time_start`, `write_time_end`, `fraction`, `write_diary_time`) VALUES ('" + id + "','" + diary1 + "','" + diary2 + "','" + diary3 + "','" + diary4 + "','" + diary5 + "','" + diary6 + "','" +  diary7 + "','" + diary8 + "','" + diary9_start + "','" + diary9_end +"','" + diary10 + "','" + date +"')";
            Statement st = con.createStatement();
            st.executeUpdate(sql);
            st.close();
            Log.v("DB", "寫入資料完成：" + sql);
        } catch (SQLException e) {
            e.printStackTrace();
            Log.e("DB", "寫入資料失敗");
            Log.e("DB", e.toString());
        }
    }



}
