package com.rejasupotaro.rejamotionapp.ui;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.util.Log;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.rejasupotaro.hybridge.annotation.Bridge;
import com.rejasupotaro.hybridge.bridge.HybridgeWebView;

public class RejaMotionWebView extends HybridgeWebView {
    private Activity activity;
    private LoadStateListener listener;

    public RejaMotionWebView(Context context) {
        super(context);
    }

    public RejaMotionWebView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public RejaMotionWebView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public void init(Activity activity, LoadStateListener listener) {
        super.init();

        this.activity = activity;
        this.listener = listener;
        super.registerBridge(this);
        setupWebViewClient();
    }

    private void setupWebViewClient() {
        setWebChromeClient(new WebChromeClient() {});

        setWebViewClient(new WebViewClient(){
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                listener.onPageStarted();
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                listener.onPageFinished();
            }
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
    }

    @Bridge("system.toast.show")
    public void log(JSONObject params) {
        try {
            Toast.makeText(activity, params.getString("message"), Toast.LENGTH_SHORT).show();
        } catch (JSONException e) {
            Log.e("DEBUG", e.getMessage(), e);
        }
    }

    interface LoadStateListener {
        void onPageFinished();
        void onPageStarted();
    }
}
