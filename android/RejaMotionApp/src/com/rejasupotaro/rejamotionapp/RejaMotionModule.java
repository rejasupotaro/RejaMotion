package com.rejasupotaro.rejamotionapp;

import roboguice.inject.ContextSingleton;

import com.google.inject.AbstractModule;
import com.rejasupotaro.rejamotionapp.ui.helper.RejaMotionActivityHelper;

public class RejaMotionModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(RejaMotionActivityHelper.class).in(ContextSingleton.class);
    }

}
