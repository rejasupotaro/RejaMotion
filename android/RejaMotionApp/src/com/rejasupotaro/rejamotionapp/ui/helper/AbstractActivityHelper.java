package com.rejasupotaro.rejamotionapp.ui.helper;

import javax.inject.Inject;

import android.app.Activity;
import android.content.Context;

public class AbstractActivityHelper {

    @Inject private Context mContext;

    protected Activity getActivity() {
        return (Activity) mContext;
    }

    protected Context getContext() {
        return mContext;
    }

    // for test
    public void setContext(Context context) {
        mContext = context;
    }
}
