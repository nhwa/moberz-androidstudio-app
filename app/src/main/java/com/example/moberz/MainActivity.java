package com.example.moberz;

import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.NonNull;
import android.util.Base64;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.kakao.usermgmt.UserManagement;
import com.kakao.usermgmt.callback.LogoutResponseCallback;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MainActivity extends AppCompatActivity {
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

        //지도 homefragment
        if (savedInstanceState == null) {
            HomeFragment homeFragment = new HomeFragment();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.frame_layout, homeFragment, "home")
                    .commit();
        }

        // 첫 화면 지정
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation_view);

        // BottomNavigationView 메뉴를 선택할 때마다 위치가 변하지 않도록
        BottomNavigationHelper.disableShiftMode(bottomNavigationView);

        //fragment 교체
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.frame_layout, fragment_home).commitAllowingStateLoss();

        //닉네임,프로필 전송
        Kakaoinfo();

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                switch (item.getItemId()) {
                    case R.id.navigation_home: {
                        transaction.replace(R.id.frame_layout, fragment_home).commitAllowingStateLoss();
                        break;
                    }
                    case R.id.navigation_MyEvent: {
                        transaction.replace(R.id.frame_layout, fragment_my).commitAllowingStateLoss();
                        break;
                    }
                    case R.id.navigation_TodayEvent: {
                        transaction.replace(R.id.frame_layout, fragment_today).commitAllowingStateLoss();
                        break;
                    }
                    case R.id.navigation_setting: {
                        transaction.replace(R.id.frame_layout, fragment_setting).commitAllowingStateLoss();
                        break;
                    }
                }
                return true;
            }
        });
    }
    //로그아웃기능
    public void onClickLogout() {
        UserManagement.requestLogout(new LogoutResponseCallback() {
            @Override
            public void onCompleteLogout() {
                final Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
    public void Kakaoinfo(){
        //카카오로그인 닉네임+프로필 이미지 받아와서 fragment_setting 에다가 bundle로 정보전송
        Intent intent = getIntent();
        String nickname = intent.getExtras().getString("nickname");
        String profileImagePath = intent.getExtras().getString("profileImagePath");
        Bundle bundle = new Bundle();
        bundle.putString("nickname", nickname);
        bundle.putString("profileImagePath", profileImagePath);
        fragment_setting.setArguments(bundle);
    }

//    public void Listviewmaker(){
//        MyFragment fragment_my = (MyFragment) getSupportFragmentManager().findFragmentById(R.id.customlistfragment);
//        fragment_my.addItem(ContextCompat.getDrawable(this, R.drawable.gps),
//                "New Box", "New Account Box Black 36dp") ;
//    }

}