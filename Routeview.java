package com.itshareplus.googlemapdemo;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;

public class Routeview extends AppCompatActivity {
WebView website;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_routeview);
        ActionBar actionBar=getSupportActionBar();
        actionBar.hide();
        String start = getIntent().getExtras().getString("start");
        String end = getIntent().getExtras().getString("end");
        Toast.makeText(this, ""+start+end, Toast.LENGTH_SHORT).show();
        website = (WebView) findViewById(R.id.website);
        website.setWebChromeClient(new WebChromeClient() {
            ///
            public void onProgressChanged(WebView mWebView, int newProgress) {
                // Update the progress bar with page loading progress

            }
        });
        website.setWebViewClient(new WebViewClient()
        {

            public void onPageStarted(WebView view, String url, Bitmap favicon)
            {
                super.onPageStarted(view, url, favicon);

            }

            @Override
            public void onPageFinished(WebView view, String url)
            {

            }
        });
        String url = "http://esightsolutions.com/tes/chumma.php?source="+start+"&dest="+end;
        website.getSettings().setJavaScriptEnabled(true);
        website.setWebViewClient(new WebViewClient());
        website.setWebViewClient(new WebViewClient() {
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {

            }
        });
        website.setWebViewClient(new WebViewClient() {
            public void  onReceivedHttpError(WebView view, WebResourceRequest request, WebResourceResponse errorResponse){

            }
        });
        website.setWebViewClient(new WebViewClient() {
            public void  onReceivedSslError(WebView view, SslErrorHandler handler, SslError error){

            }
        });
        website.loadUrl(url);
    }
}
