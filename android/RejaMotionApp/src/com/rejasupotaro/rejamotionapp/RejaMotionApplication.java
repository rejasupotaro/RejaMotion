package com.rejasupotaro.rejamotionapp;

import proton.inject.Proton;
import android.app.Application;

public class RejaMotionApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Proton.initialize(this, new RejaMotionModule());
    }

}
