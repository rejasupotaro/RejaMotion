package com.rejasupotaro.rejamotionapp;

import proton.inject.DefaultModule;
import proton.inject.scope.ContextScoped;

import com.rejasupotaro.rejamotionapp.ui.helper.RejaMotionActivityHelper;

public class RejaMotionModule extends DefaultModule {
    @Override
    protected void configure() {
        super.configure();
        bind(RejaMotionActivityHelper.class).in(ContextScoped.class);
    }
}
