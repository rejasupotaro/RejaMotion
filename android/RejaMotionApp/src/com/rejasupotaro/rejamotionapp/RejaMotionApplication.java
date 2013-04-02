package com.rejasupotaro.rejamotionapp;

import proton.inject.DefaultModule;
import proton.inject.Proton;
import proton.inject.scope.ContextScoped;
import android.app.Application;

import com.rejasupotaro.rejamotionapp.ui.helper.RejaMotionActivityHelper;

public class RejaMotionApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Proton.initialize(this, new DefaultModule() {
            @Override
            protected void configure() {
                super.configure();
                bind(RejaMotionActivityHelper.class).in(ContextScoped.class);
            }
        });
    }

}
