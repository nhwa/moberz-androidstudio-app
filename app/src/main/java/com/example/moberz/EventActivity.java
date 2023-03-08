package com.example.moberz;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class EventActivity extends AppCompatActivity {
    private TextView event_title;
    private TextView date;
    private TextView location;
    private TextView etc;
    private ImageButton close_button;
    private ImageView imageView;
    private String str;
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        close_button = (ImageButton)findViewById(R.id.close_button);
        close_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
            });

        //리스트뷰에서 누른 객체 인텐트로 보내 받음
         Bundle extras = getIntent().getExtras();

        String titleStr = extras.getString("titleStr");
        String descStr = extras.getString("descStr");
        String gps = extras.getString("gps");
        byte[] byteArray = getIntent().getByteArrayExtra("image");
        Bitmap bitmap = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);

        imageView =(ImageView)findViewById(R.id.imageView);
        imageView.setImageBitmap(bitmap);

        event_title = (TextView)findViewById(R.id.event_title);
        event_title.setText(titleStr);

        date = (TextView)findViewById(R.id.date);
        date.setText(descStr);

        location= (TextView)findViewById(R.id.location);
        location.setText(gps);

        etc = (TextView)findViewById(R.id.etc);

        switch (titleStr){
            case "마노르블랑 핑크뮬리축제":
                str="대한민국 핑크뮬리 성지!!! 마노르블랑에서 핑크뮬리축제의 향연이 시작된다. 마노르블랑은 서귀포시에 위치한 가든 카페이다. 이곳은 작년에 이어 올해에도 핑크뮬리축제를 맞이하고 있다. 우리나라 최남단에 위치하고 있으며 핑크뮬리가 우리나라에서 가장 빨리 개화중이다. 9월에는 사랑과 정성으로 가꾸어진 핑크뮬리와 유럽수국을 오직 마노르블랑에서만 함께 볼 수 있다.";
                break;

            case "제주 국제 아트페어 아트제주":
               str= "제주 최대 규모의 국제 아트페어 아트제주가 올해 4회를 맞이한다. 30여개의 갤러리가 선별한 현대미술품 1,000여점을 한 자리에서 만나보자. 아트제주2019에 대한 소식은 인스타그램 공식계정 @artjejukorea를 통해 자세히 알 수 있다";
                break;

            case "최남단방어축제":
                str="제주의 대표적 해양문화축제로써 매년 11월 제주바다의 대명사인 방어를 테마로 한 특산물 축제이다. 싱싱한 방어회를 비롯한 다양한 방어요리를 맛 볼 수 있으며, 각종 방어낚시, 현장 방어경매, 손으로 방어 잡기 등 직접 참여할 수 있는 프로그램이 주를 이뤄 가족 및 단체 관광객들이 자유롭게 축제를 즐길 수가 있다.";
                break;

            case "아름다운 한림공원 국화축제":
                str="올해로 26회를 맞이하는 한림공원 국화축제에서는 올 봄부터 사랑과 정성을 다해 정성껏 가꾸어온 50여종 10,000여 점의 국화 작품이 어우러져 “아름다운 국화 정원”을 만들 예정이다. 이번 행사에는 국화로 만든 대형 국화 꽃 탑을 비롯하여 현애, 아치, 토피어리, 입국·다륜대작, 목부작, 석부작, 분재작등 아름다운 국화꽃을 감상할 수 있다.";
                break;

            case "봄의 낭만을 즐기는 벚꽃 축제":
                str="제주도를 대표하는 벚꽃 명소는 대부분 제주시에 몰려 있다. 그 중 둘째가라면 서러워할 곳이 바로 전농로이다. 구도심에 있는 전농로는 KAL호텔 사거리에서 남성오거리까지 약 1.2km에 이르는 왕복 2차선 도로로, 오래전부터 제주도에서 제일가는 벚꽃거리로 명성을 떨쳐왔다. 수십 년 된 왕벚나무들이 줄지어 서 있는 이 거리는 해마다 봄이면 벚꽃이 만발해 그야말로 꽃천지를 이룬다.";
                break;
        }

            etc.setText(str);

    }
}
