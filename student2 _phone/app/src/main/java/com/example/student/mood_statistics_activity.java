package com.example.student;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import android.os.Bundle;
import android.view.MenuItem;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class mood_statistics_activity extends AppCompatActivity {

    private ViewPager viewPager;
    private MenuItem menuItem;
    private BottomNavigationView bottomNavigationView;

    // Step01-製作BottomNavigationView按下個方法:
    private BottomNavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            // Step02-BottomNavigationView按下時判斷Menu的ID，讓ViewPaper跳去相對應的Fragment:
            switch (item.getItemId()){
                case R.id.nav2:
                    viewPager.setCurrentItem(0);
                    break;
                case R.id.nav3:
                    viewPager.setCurrentItem(1);
                    break;
                case R.id.nav4:
                    finish();
                    break;
            }
            return false;
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mood_statistics);
        getSupportActionBar().hide();//關閉標題列

        // Step03-設定BottomNavigationView的按下事件監聽器:
        bottomNavigationView = findViewById(R.id.navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener);

        // Step04-設定ViewPaper的適配器:
        MainPagerAdapter adapter = new MainPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new Fragment_statistics_thermometer(), "thermometer");
        adapter.addFragment(new Fragment_statistics_diary(), "_diary");
        viewPager = findViewById(R.id.viewPagerMain);
        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(3);

        // Step05-設定ViewPaper的事件監聽器:
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }
            // ViewPaper選擇到其他頁面時:
            @Override
            public void onPageSelected(int position) {
                // Step06-將相對應的bottomNavigationView選項選取:
                menuItem = bottomNavigationView.getMenu().getItem(position).setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }
    public class MainPagerAdapter extends FragmentPagerAdapter {

        private List<Fragment> fragmentList=new ArrayList<>();
        private List<String> fragmentTitle=new ArrayList<>();

        public MainPagerAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        //計算要做出幾個分頁
        @Override
        public int getCount() {
            return fragmentList.size();
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        // 取得要新增的Fragment與你為它取名的title
        public void addFragment(Fragment fragment,String title){
            fragmentList.add(fragment);
            fragmentTitle.add(title);
        }

        // 設置ViewPager的標題，之後可以判斷目前位於哪個fragment
        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return fragmentTitle.get(position);
        }
    }

}