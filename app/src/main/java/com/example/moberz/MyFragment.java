package com.example.moberz;
//****나의 이벤트 프래그먼트

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.R.id.*;
import android.widget.ListView;

import java.io.ByteArrayOutputStream;

import static com.kakao.usermgmt.StringSet.nickname;

public class MyFragment  extends ListFragment {
    ListViewAdapter adapter ;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Adapter 생성 및 Adapter 지정.
        adapter = new ListViewAdapter() ;
        setListAdapter(adapter) ;

        adapter.addItem(ContextCompat.getDrawable(getActivity(), R.drawable.pink),
                "마노르블랑 핑크뮬리축제", "서귀포시 안덕면 일주서로 2100번길 46","2019.09.09 - 2019.11.30") ;
        adapter.addItem(ContextCompat.getDrawable(getActivity(), R.drawable.artjeju),
                "제주 국제 아트페어 아트제주", "메종글래드 제주 ","2019.11.28 - 2019.12.01") ;
        adapter.addItem(ContextCompat.getDrawable(getActivity(), R.drawable.bang),
                "최남단방어축제", "서귀포시 모슬포항","2019.11.21 - 2019.11.24") ;
        adapter.addItem(ContextCompat.getDrawable(getActivity(), R.drawable.hanrim),
                "아름다운 한림공원 국화축제", "제주시 한림읍 한림로 300","2019.11.08 - 2019.11.24") ;
        adapter.addItem(ContextCompat.getDrawable(getActivity(), R.drawable.flower),
                "봄의 낭만을 즐기는 벚꽃 축제", "제주시 전농로","2019.03.27 - 2019.03.29") ;


        return super.onCreateView(inflater, container, savedInstanceState);
    }
    @Override
    public void onListItemClick (ListView l, View v, int position, long id) {
        // get TextView's Text.
        ListViewItem item = (ListViewItem) l.getItemAtPosition(position) ;
        String titleStr = item.getTitle();
        String descStr = item.getDesc() ;
        String gps = item.getGps() ;
        Drawable iconDrawable = item.getIcon() ;

        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        Bitmap bitmap = ((BitmapDrawable)iconDrawable).getBitmap();
        float scale = (float) (1024/(float)bitmap.getWidth());
        int image_w = (int) (bitmap.getWidth() * scale);
        int image_h = (int) (bitmap.getHeight() * scale);
        Bitmap resize = Bitmap.createScaledBitmap(bitmap, image_w, image_h, true);
        resize.compress(Bitmap.CompressFormat.JPEG, 100, stream);
        byte[] byteArray = stream.toByteArray();

        //fragment에서는
        Intent intent = new Intent(getActivity(), EventActivity.class);
        intent.putExtra("titleStr",titleStr );
        intent.putExtra("descStr",descStr);
        intent.putExtra("gps",gps);
        intent.putExtra("image", byteArray);
        startActivity(intent);

        // TODO : use item data.
    }
    public void addItem(Drawable icon, String title, String gps, String desc) {
        adapter.addItem(icon, title, gps, desc) ;
    }
}