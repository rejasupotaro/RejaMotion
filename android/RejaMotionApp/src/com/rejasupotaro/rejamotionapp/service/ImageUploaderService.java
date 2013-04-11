package com.rejasupotaro.rejamotionapp.service;

import javax.inject.Inject;

import proton.inject.service.ProtonIntentService;
import android.content.Intent;
import android.util.Log;

import com.rejasupotaro.rejamotionapp.api.RejaMotionApiClient;
import com.rejasupotaro.rejamotionapp.model.AnimationEntity;
import com.rejasupotaro.rejamotionapp.notification.RejaMotionNotificationManager;

public class ImageUploaderService extends ProtonIntentService {

    private static final String TAG = ImageUploaderService.class.getSimpleName();
    public static final String EXTRA_ANIMATION_ENTITY = "extra_animation_entity";
    @Inject RejaMotionNotificationManager mNotificationManager;

    public ImageUploaderService() {
        super(TAG);
    }

    public ImageUploaderService(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        mNotificationManager.sendNotification();
        AnimationEntity animationEntity = intent.getParcelableExtra(EXTRA_ANIMATION_ENTITY);
        RejaMotionApiClient apiClient = new RejaMotionApiClient(this, animationEntity);
        boolean result = apiClient.execute();
        Log.d(TAG, "upload result: " + result);
        mNotificationManager.cancelNotification();
    }

}
