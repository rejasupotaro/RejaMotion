package com.rejasupotaro.rejamotionapp.ui;

import javax.inject.Inject;

import proton.inject.activity.ProtonFragmentActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

import com.rejasupotaro.rejamotionapp.R;
import com.rejasupotaro.rejamotionapp.model.AnimationEntity;
import com.rejasupotaro.rejamotionapp.service.ImageUploaderService;
import com.rejasupotaro.rejamotionapp.ui.helper.RejaMotionActivityHelper;

public class AnimationComposeActivity extends ProtonFragmentActivity {
    private AnimationView mAnimationView;
    private Button mPostButton;
    private Button mCloseButton;
    private SeekBar mAnimationSpeedSeekBar;
    private EditText mImageTitleEditText;
    @Inject RejaMotionActivityHelper mActivityHelper;
    private AnimationEntity mAnimationEntity;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getVeiws();
        setComponentListeners();
    }

    private void getVeiws() {
        mAnimationView = (AnimationView) findViewById(R.id.image_animation_view);
        mPostButton = (Button) findViewById(R.id.button_post);
        mCloseButton = (Button) findViewById(R.id.button_close);
        mAnimationSpeedSeekBar = (SeekBar) findViewById(R.id.seekbar_animation_speed);
        mImageTitleEditText = (EditText) findViewById(R.id.edit_text_image_title);
    }

    private void setComponentListeners() {
        mAnimationView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (mAnimationEntity.size() == 0) {
                    mActivityHelper.launchGallarey();
                }
            }
        });

        mPostButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                upload();
            }
        });

        mCloseButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mActivityHelper.launchActivity(TimelineActivity.class);
            }
        });

        mAnimationSpeedSeekBar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {}
            public void onStartTrackingTouch(SeekBar seekBar) {}
            public void onStopTrackingTouch(SeekBar seekBar) {
                mAnimationView.setAnimationInterval(seekBar.getProgress());
            }
        });

        mAnimationEntity = mActivityHelper.loadImageFromIntent(getIntent());
        if (mAnimationEntity.size() > 0) {
            mAnimationView.setupAnimation(mAnimationEntity.getBitmapList());
        }
    }

    private void upload() {
        Intent intent = new Intent(this, ImageUploaderService.class);
        mAnimationEntity.setTitle(mImageTitleEditText.getText().toString());
        mAnimationEntity.setDelay(mAnimationView.getDelay());
        intent.putExtra(ImageUploaderService.EXTRA_ANIMATION_ENTITY, mAnimationEntity);
        startService(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (requestCode == RejaMotionActivityHelper.REQUEST_GALLERY && resultCode == RESULT_OK) {
            mAnimationEntity = mActivityHelper.loadImageFromIntent(getIntent());
            if (mAnimationEntity.size() > 0) {
                mAnimationView.setImageBitmap(mAnimationEntity.getBitmap(0));
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
