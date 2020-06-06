package com.latrosoft.srisaradavidyalaya;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.DownloadListener;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class online extends AppCompatActivity {
    AdView mAdView;
    WebView webView;
    @Override
    protected void onPause() {
        webView.goBack();
        super.onPause();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_online);
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        webView = findViewById(R.id.webview);
        webView.getSettings().setJavaScriptEnabled(true);

        final ProgressDialog progDailog = ProgressDialog.show(online.this, "Loading..","Please wait.. ", true);
        progDailog.setCancelable(false);
        webView.getSettings().setUseWideViewPort(true);
        webView.getSettings().setLoadWithOverviewMode(true);
        Bundle bundle = getIntent().getExtras();
        String message = bundle.getString("Page");
        webView.loadUrl(message);
        webView.setDownloadListener(new DownloadListener() {
            @Override
            public void onDownloadStart(String url, String userAgent, String contentDisposition, String mimetype, long contentLength) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

        webView.setWebViewClient(new WebViewClient() {


            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String Url) {
                progDailog.show();
                view.loadUrl(Url);
                return true;
            }

            @Override
            public void onPageFinished(WebView view, String url)
            {
                progDailog.dismiss();
                // hide element by class name
                // hide element by id

                view.loadUrl("javascript:(function() { " +
                        "document.getElementById('backtoblog').style.display='none';})()");
                view.loadUrl("javascript:(function() { " +
                        "document.getElementsByClassName('elementor-container')[0].style.display='none';})()");
                view.loadUrl("javascript:(function() { " +
                        "document.getElementsByClassName('main-header-bar-wrap')[0].style.display='none';})()");

            }
        });
    }
}

