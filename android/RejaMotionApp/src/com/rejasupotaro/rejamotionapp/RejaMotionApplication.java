package com.rejasupotaro.rejamotionapp;

import proton.inject.Proton;
import android.app.Application;

import com.rejasupotaro.hybridge.Hybridge;

public class RejaMotionApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Proton.initialize(this, new RejaMotionModule());
        Hybridge.initialize(this);
    }

    @Override
    public void onTerminate() {
        Hybridge.dispose();
    }
}
