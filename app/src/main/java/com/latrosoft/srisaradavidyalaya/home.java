package com.latrosoft.srisaradavidyalaya;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class home extends AppCompatActivity implements View.OnClickListener {
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference().child("web").child("login");
    String videoString ="https://www.srisaradavidyalaya.com/vedio-subjects/";


     String materialString ="https://www.srisaradavidyalaya.com/materials/";

    AdView mAdView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        CardView mVideo =  findViewById(R.id.videoCard);
        CardView  mResult = findViewById(R.id.resultCard);
        CardView mMaterial = findViewById(R.id.materialCard);
        mVideo.setOnClickListener(this);
        mResult.setOnClickListener(this);
        mMaterial.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        Intent i;
        switch (v.getId()){
            case R.id.videoCard:
                i = new Intent(home.this,online.class);
                i.putExtra("Page", videoString);
                startActivity(i);
                break;
            case R.id.resultCard:
                i = new Intent(home.this,online.class);
                i.putExtra("Page", resultString);
                startActivity(i);
                break;
            case R.id.materialCard:
                i = new Intent(home.this,online.class);
                i.putExtra("Page", materialString);
                startActivity(i);
                break;
            default:
                i = new Intent(home.this,online.class);
                i.putExtra("Page","https://www.srisaradavidyalaya.com");
                startActivity(i);

        }
    }
}
