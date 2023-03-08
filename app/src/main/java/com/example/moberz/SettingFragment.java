package com.example.moberz;
//****설정  프래그먼트

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;


public class SettingFragment extends Fragment  {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        LinearLayout layout = (LinearLayout) inflater.inflate(R.layout.fragment_setting, container, false);
        TextView nicknamet = layout.findViewById(R.id.nickname);
        ImageView profileImage = layout.findViewById(R.id.profile);
        Button button = (Button) layout.findViewById(R.id.btn_logout);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //메인액티비티에있는 로그아웃기능 실행
                ((MainActivity)getActivity()).onClickLogout();
            }
        });
        //nickname 정보 받아옴
        String nickname = this.getArguments().getString("nickname");
            nicknamet.setText(nickname);
        //프로필 사진 정보 받아옴
        String profileImagePath = this.getArguments().getString("profileImagePath");
            Glide.with(this).load(profileImagePath).into(profileImage);

        return layout;
    }
}
