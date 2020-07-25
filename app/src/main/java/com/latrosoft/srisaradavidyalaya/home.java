package com.latrosoft.srisaradavidyalaya;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class home extends AppCompatActivity implements View.OnClickListener {

    String videoString = "https://www.srisaradavidyalaya.com/vedio-subjects/";
    String resultString = "https://www.srisaradavidyalaya.com/wp-login.php";
    String materialString = "https://www.srisaradavidyalaya.com/materials/";

    AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        CardView mVideo = findViewById(R.id.videoCard);
        CardView mResult = findViewById(R.id.resultCard);
        CardView mMaterial = findViewById(R.id.materialCard);
        CardView mNoti = findViewById(R.id.notificationCard);
        mVideo.setOnClickListener(this);
        mResult.setOnClickListener(this);
        mMaterial.setOnClickListener(this);
        mNoti.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        Intent i;
        switch (v.getId()) {
            case R.id.videoCard:
                i = new Intent(home.this, online.class);
                i.putExtra("Page", videoString);
                startActivity(i);
                break;
            case R.id.resultCard:
                i = new Intent(home.this, online.class);
                i.putExtra("Page", resultString);
                startActivity(i);
                break;
            case R.id.materialCard:
                i = new Intent(home.this, online.class);
                i.putExtra("Page", materialString);
                startActivity(i);
                break;
            case R.id.notificationCard:
                i = new Intent(home.this, Notification.class);
                startActivity(i);
                break;
            default:
                i = new Intent(home.this, online.class);
                i.putExtra("Page", "https://www.srisaradavidyalaya.com");
                startActivity(i);

        }
    }
}
