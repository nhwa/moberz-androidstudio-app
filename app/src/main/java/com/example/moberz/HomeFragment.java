package com.example.moberz;

import android.os.Bundle;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

public class HomeFragment extends Fragment implements OnMapReadyCallback {
    View rootView;
    MapView mapView;

    public HomeFragment() {
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_home, container, false);
        mapView = (MapView) rootView.findViewById(R.id.mapview);
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(this);

        return rootView;
    }

    @Override
    public void onResume() {
        mapView.onResume();
        super.onResume();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        MapsInitializer.initialize(this.getActivity());
        // Updates the location and zoom of the MapView
        CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(new LatLng(33.457960, 126.561623), 10);
        googleMap.animateCamera(cameraUpdate);
        googleMap.addMarker(new MarkerOptions()
                .position(new LatLng(33.254377, 126.294651))
                .title("마노르블랑 핑크뮬리축제")
                .snippet("대한민국 핑크뮬리 성지! 마노르블랑에서 핑크뮬리축제의 향연이 시작된다 ")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE))
                .alpha(0.9f));

        googleMap.addMarker(new MarkerOptions()
                .position(new LatLng(33.484769, 126.488708))
                .title("아트제주2019")
                .snippet("30여개의 갤러리에서 선별한 현대미술품 천여점 전시")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE))
                .alpha(0.9f));

        googleMap.addMarker(new MarkerOptions()
                .position(new LatLng(33.216220, 126.250524))
                .title("최남단방어축제")
                .snippet("11월 제주바다의 대명사인 방어를 테마로 한 특산물 축제")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE))
                .alpha(0.9f));

        googleMap.addMarker(new MarkerOptions()
                .position(new LatLng(33.389656, 126.239683))
                .title("한림공원국화축제")
                .snippet("50여종 10,000여 점의 국화 작품이 있는 아름다운 국화 정원 ")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE))
                .alpha(0.9f));

        googleMap.addMarker(new MarkerOptions()
                .position(new LatLng(33.504432, 126.517364))
                .title("봄의 낭만을 즐기는 벚꽃축제")
                .snippet("우리나라에서 제일 먼저 벚꽃 소식을 접할 수 있는 곳, 화려한 왕벚꽃 축제")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE))
                .alpha(0.9f));
    }
}
