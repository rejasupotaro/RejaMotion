package com.rejasupotaro.rejamotionapp.service;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

import com.rejasupotaro.rejamotionapp.api.RejaMotionApiClient;
import com.rejasupotaro.rejamotionapp.model.AnimationEntity;

public class ImageUploaderService extends IntentService {

    private static final String TAG = ImageUploaderService.class.getSimpleName();
    public static final String EXTRA_ANIMATION_ENTITY = "extra_animation_entity";

    public ImageUploaderService() {
        super(TAG);
    }

    public ImageUploaderService(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        AnimationEntity animationEntity = intent.getParcelableExtra(EXTRA_ANIMATION_ENTITY);
        RejaMotionApiClient apiClient = new RejaMotionApiClient(this, animationEntity);
        boolean result = apiClient.execute();
        Log.d("DEBUG", "upload result: " + result);
    }

}
