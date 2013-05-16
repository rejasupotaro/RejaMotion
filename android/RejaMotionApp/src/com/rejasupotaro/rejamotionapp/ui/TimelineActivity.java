package com.rejasupotaro.rejamotionapp.ui;

import javax.inject.Inject;

import org.json.JSONException;
import org.json.JSONObject;

import proton.inject.activity.ProtonActivity;
import android.graphics.Bitmap;
import android.graphics.Picture;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebView.PictureListener;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.rejasupotaro.hybridge.BuildConfig;
import com.rejasupotaro.hybridge.annotation.Bridge;
import com.rejasupotaro.hybridge.bridge.HybridgeWebView;
import com.rejasupotaro.rejamotionapp.Constants;
import com.rejasupotaro.rejamotionapp.R;
import com.rejasupotaro.rejamotionapp.ui.helper.RejaMotionActivityHelper;
import com.rejasupotaro.rejamotionapp.utils.UriUtils;

public class TimelineActivity extends ProtonActivity {

    private HybridgeWebView mWebView;
    private ProgressBar mProgressLoading;
    @Inject private RejaMotionActivityHelper mActivityHelper;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timeline);
        getViews();

        mWebView.init(this);
        if (BuildConfig.DEBUG) mWebView.clearCache(true);
        setupWebViewClient(mWebView);
        mWebView.loadUrl(Constants.APP_SITE_URL);

        mActivityHelper.setupSplashAnimation(new Handler());
    }

    private void getViews() {
        mWebView = (HybridgeWebView) findViewById(R.id.webview_timeline);
        mProgressLoading = (ProgressBar) findViewById(R.id.progress_loading);
    }

    private void setupWebViewClient(HybridgeWebView webView) {
        webView.setWebChromeClient(new WebChromeClient() {});

        webView.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                Uri uri = Uri.parse(url);
                if (Constants.PRODUCTION && !UriUtils.compareDomain(uri, Constants.DOMAIN)) {
                    throw new SecurityException();
                }

                super.onPageStarted(view, url, favicon);
                showLoadingProgress();
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                hideLoadingProgress();
            }
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });

        webView.setPictureListener(new PictureListener() {
            public void onNewPicture(WebView view, Picture picture) {
                hideLoadingProgress();
            }
        });
    }

    private void showLoadingProgress() {
        mProgressLoading.setVisibility(View.VISIBLE);
        mWebView.setVisibility(View.GONE);
    }

    private void hideLoadingProgress() {
        mProgressLoading.setVisibility(View.GONE);
        mWebView.setVisibility(View.VISIBLE);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

    public boolean onPrepareOptionsMenu(Menu menu){
        super.onPrepareOptionsMenu(menu);
        menu.findItem(R.id.menu_reload).setOnMenuItemClickListener(new OnMenuItemClickListener() {
            public boolean onMenuItemClick(MenuItem item) {
                mWebView.reload();
                return false;
            }
        });
        return true;
    }

    @Bridge("system.toast.show")
    public void log(JSONObject params) {
        try {
            Toast.makeText(this, params.getString("message"), Toast.LENGTH_SHORT).show();
        } catch (JSONException e) {
            Log.e("DEBUG", e.getMessage(), e);
        }
    }
}
