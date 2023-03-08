package com.example.moberz191114;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.NonNull;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    Intent intent = getIntent(); /*데이터 수신*/
    String nickname = intent.getExtras().getString("nickname");

    // FrameLayout에 각 메뉴의 Fragment를 바꿔 줌
    private FragmentManager fragmentManager = getSupportFragmentManager();
    // 4개의 메뉴에 들어갈 Fragment들
    private HomeFragment fragment_home = new HomeFragment();
    private MyFragment fragment_my = new MyFragment();
    private TodayFragment fragment_today = new TodayFragment();
    private SettingFragment fragment_setting = new SettingFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.nav_view);
        // 첫 화면 지정
        // BottomNavigationView 메뉴를 선택할 때마다 위치가 변하지 않도록
        BottomNavigationHelper.disableShiftMode(bottomNavigationView);
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.frame_layout, fragment_home).commitAllowingStateLoss();
        //fragment 교체

//        Bundle bundle = new Bundle(1); // 파라미터는 전달할 데이터 개수
//        bundle.putString("nickname", nickname); // key , value
//        fragment_setting.setArguments(bundle);

        bottomNavigationView.setOnNavigationItemSelectedLi