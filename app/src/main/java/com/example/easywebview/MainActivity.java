package com.example.easywebview;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

import easywebview.example.com.ewebview.EWebView;

public class MainActivity extends AppCompatActivity {

    private EWebView wv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.wv = (EWebView) findViewById(R.id.wv);
        wv.loadUrl("http://api.schmfz.com/iot/readDataAnalysisCurve_toHtml?waterPumpGroupIds=63933851441152&startTime=2018-11-27%2000:00:00&endTime=2018-11-27%2023:59:59&monitorParam=3&userId=63932804550658&companyCode=435079");
        wv.setFileChooserListener(new EWebView.fileChooserListener() {
            @Override
            public void fileChooser(WebView webView, ValueCallback<Uri[]> filePathCallback, WebChromeClient.FileChooserParams fileChooserParams) {
                Intent i = new Intent(Intent.ACTION_GET_CONTENT);
                i.addCategory(Intent.CATEGORY_OPENABLE);
                i.setType("*/*");
                startActivity(Intent.createChooser(i, "File Chooser"));
            }

            @Override
            public void fileChooser(ValueCallback<Uri> uploadMsg, String acceptType, String capture) {

            }
        });
        this.wv.addOnScrollChangedListener(new EWebView.OnScrollChangedListener() {
            @Override
            public void onPageTop(int l, int t, int oldl, int oldt) {

            }

            @Override
            public void onPageEnd(int l, int t, int oldl, int oldt) {

            }

            @Override
            public void onScrollChanged(int l, int t, int oldl, int oldt) {

            }
        });

    }


    @Override
    protected void onPause() {
        wv.getWebLifeCycle().onPause();
        super.onPause();
    }

    @Override
    protected void onResume() {
        wv.getWebLifeCycle().onResume();
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        wv.getWebLifeCycle().onDestroy();
        super.onDestroy();
    }
}
