package com.example.student;

import android.app.Application;

public class GlobalVariable extends Application {
    private String name;     //帳號
    private String user;     //帳號
    private String password;  //密碼
    private String sex;  //性別
    private String scale1;  //社會適應表Q1
    private String scale2;  //社會適應表Q2
    private String scale3;  //社會適應表Q3
    private String scale4;  //社會適應表Q4
    private String scale5;  //社會適應表Q5
    private String scale6;  //社會適應表Q6
    private String scale7;  //社會適應表Q7
    private String scale8;  //社會適應表Q8
    private String scale9;  //社會適應表Q9
    private String scale10;  //社會適應表Q10
    private String diary1="非常快樂";  //心情日記Q1
    private String diary2="晴天";  //心情日記Q2
    private String diary3="自己";  //心情日記Q3
    private String diary4="早上";  //心情日記Q4
    private String diary5;  //心情日記Q5
    private String diary6;  //心情日記Q6
    private String diary7;  //心情日記Q7
    private String diary8;  //心情日記Q8
    private String diary9_start;  //心情日記Q9開始時間
    private String diary9_end;  //心情日記Q9結束時間
    private int diary10;  //心情日記Q10
    private String ter1_1="7非常快樂";  //心情溫度計sp1_1
    private String ter1_2="非常快樂";  //心情溫度計sp1_2
    private String ter1_3="呼吸變急";  //心情溫度計sp1_3
    private String ter1_4="想打自己";  //心情溫度計sp1_4
    private String ter3_1="提醒自己的話";  //心情溫度計sp3_1
    private String ter6_1="7非常快樂";  //心情溫度計sp6_1
    private String exit_ter1_1="7非常快樂";  //離開_心情溫度計sp1_1
    private String exit_ter1_2="非常快樂";  //離開_心情溫度計sp1_2
    private String abc="T";     //帳號


    //修改 變數値
    public void setname(String name) {
        this.name = name;
    }

    public void setuser(String user) {
        this.user = user;
    }

    public void setpassword(String password) {
        this.password = password;
    }

    public void setsex(String sex) {
        this.sex = sex;
    }

    public void setscale1(String scale1) {
        this.scale1 = scale1;
    }

    public void setscale2(String scale2) {
        this.scale2 = scale2;
    }

    public void setscale3(String scale3) {
        this.scale3 = scale3;
    }

    public void setscale4(String scale4) {
        this.scale4 = scale4;
    }

    public void setscale5(String scale5) {
        this.scale5 = scale5;
    }

    public void setscale6(String scale6) {
        this.scale6 = scale6;
    }

    public void setscale7(String scale7) {
        this.scale7 = scale7;
    }

    public void setscale8(String scale8) {
        this.scale8 = scale8;
    }

    public void setscale9(String scale9) {
        this.scale9 = scale9;
    }

    public void setscale10(String scale10) {
        this.scale10 = scale10;
    }

    public void setdiary1(String diary1) {
        this.diary1 = diary1;
    }

    public void setdiary2(String diary2) {
        this.diary2 = diary2;
    }

    public void setdiary3(String diary3) {
        this.diary3 = diary3;
    }

    public void setdiary4(String diary4) {
        this.diary4 = diary4;
    }

    public void setdiary5(String diary5) {
        this.diary5 = diary5;
    }

    public void setdiary6(String diary6) {
        this.diary6 = diary6;
    }

    public void setdiary7(String diary7) {
        this.diary7 = diary7;
    }

    public void setdiary8(String diary8) {
        this.diary8 = diary8;
    }

    public void setdiary9_start(String diary9_start) {
        this.diary9_start = diary9_start;
    }

    public void setdiary9_end(String diary9_end) {
        this.diary9_end = diary9_end;
    }

    public void setdiary10(int diary10) {
        this.diary10 = diary10;
    }

    public void setter1_1(String ter1_1) {
        this.ter1_1 = ter1_1;
    }

    public void setter1_2(String ter1_2) {
        this.ter1_2 = ter1_2;
    }

    public void setter1_3(String ter1_3) {
        this.ter1_3 = ter1_3;
    }

    public void setter1_4(String ter1_4) {
        this.ter1_4 = ter1_4;
    }

    public void setter3_1(String ter3_1) {
        this.ter3_1 = ter3_1;
    }

    public void setter6_1(String ter6_1) {
        this.ter6_1 = ter6_1;
    }

    public void setexit_ter1_1(String exit_ter1_1) {
        this.exit_ter1_1 = exit_ter1_1;
    }

    public void setexit_ter1_2(String exit_ter1_2) {
        this.exit_ter1_2 = exit_ter1_2;
    }

    public void setabc(String abc) {
        this.abc = abc;
    }

    //取得 變數值
    public String getname() { return name;  }

    public String getuser() { return user;  }

    public String getpassword() {
        return password;
    }

    public String getscale1() {
        return scale1;
    }

    public String getscale2() {
        return scale2;
    }

    public String getscale3() {
        return scale3;
    }

    public String getscale4() {
        return scale4;
    }

    public String getscale5() {
        return scale5;
    }

    public String getscale6() {
        return scale6;
    }

    public String getscale7() {
        return scale7;
    }

    public String getscale8() {
        return scale8;
    }

    public String getscale9() {
        return scale9;
    }

    public String getscale10() {
        return scale10;
    }

    public String getdiary1() {
        return diary1;
    }

    public String getdiary2() {
        return diary2;
    }

    public String getdiary3() {
        return diary3;
    }

    public String getdiary4() {
        return diary4;
    }

    public String getdiary5() {
        return diary5;
    }

    public String getdiary6() {
        return diary6;
    }

    public String getdiary7() {
        return diary7;
    }

    public String getdiary8() {
        return diary8;
    }

    public String getdiary9_start() {
        return diary9_start;
    }

    public String getdiary9_end() {
        return diary9_end;
    }

    public int getdiary10() {
        return diary10;
    }

    public String getexit_ter1_1() {
        return exit_ter1_1;
    }

    public String getexit_ter1_2() {
        return exit_ter1_2;
    }

    public String getter1_3() {
        return ter1_3;
    }

    public String getter1_4() {
        return ter1_4;
    }

    public String getter1_1() {
        return ter1_1;
    }

    public String getter1_2() {
        return ter1_2;
    }

    public String getter3_1() {
        return ter3_1;
    }

    public String getter6_1() {
        return ter6_1;
    }

    public String getsex() {
        return sex;
    }

    public String getabc() {
        return abc;
    }



}