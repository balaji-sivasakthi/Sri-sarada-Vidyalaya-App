package com.latrosoft.srisaradavidyalaya;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;

public class Dash extends AppCompatActivity {
    final  String online_test ="https://www.srisaradavidyalaya.com/wp-login.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash);
        Button btn = findViewById(R.id.next);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Dash.this,home.class);
                startActivity(i);
            }
        });
        final Button online = findViewById(R.id.online);
        online.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Dash.this,online.class);
                i.putExtra("Page", online_test);
                startActivity(i);
            }
        });
    }
}
