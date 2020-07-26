package com.latrosoft.srisaradavidyalaya;

import android.content.Intent;
import android.os.Handler;

import com.latrosoft.srisaradavidyalaya.base.BaseActivity;
import com.latrosoft.srisaradavidyalaya.databinding.ActivityMainBinding;

public class MainActivity extends BaseActivity<ActivityMainBinding> {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initViews() {
        new Handler().postDelayed(() -> {
            Intent i = new Intent(MainActivity.this, Dash.class);
            startActivity(i);
            finish();
        }, 3000);
    }
}
