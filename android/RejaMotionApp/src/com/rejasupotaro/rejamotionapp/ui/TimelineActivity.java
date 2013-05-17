package com.rejasupotaro.rejamotionapp.ui;

import javax.inject.Inject;

import proton.inject.activity.ProtonActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.ProgressBar;

import com.rejasupotaro.hybridge.BuildConfig;
import com.rejasupotaro.rejamotionapp.Constants;
import com.rejasupotaro.rejamotionapp.R;
import com.rejasupotaro.rejamotionapp.ui.RejaMotionWebView.LoadStateListener;
import com.rejasupotaro.rejamotionapp.ui.helper.RejaMotionActivityHelper;

public class TimelineActivity extends ProtonActivity implements LoadStateListener {

    private RejaMotionWebView mWebView;
    private ProgressBar mProgressLoading;
    @Inject private RejaMotionActivityHelper mActivityHelper;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timeline);
        initViews();
    }

    private void initViews() {
        mWebView = (RejaMotionWebView) findViewById(R.id.webview_timeline);
        mWebView.init(this, this);
        if (BuildConfig.DEBUG) mWebView.clearCache(true);
        mWebView.loadUrl(Constants.APP_SITE_URL);

        mProgressLoading = (ProgressBar) findViewById(R.id.progress_loading);
    }

    public void onPageStarted() {
        mProgressLoading.setVisibility(View.VISIBLE);
        mWebView.setVisibility(View.GONE);
    }

    public void onPageFinished() {
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

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (mWebView.browserBack()) return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
