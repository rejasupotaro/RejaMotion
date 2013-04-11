package com.rejasupotaro.rejamotionapp.notification;

import javax.inject.Inject;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.rejasupotaro.rejamotionapp.R;
import com.rejasupotaro.rejamotionapp.ui.TimelineActivity;

public class RejaMotionNotificationManager {
    private static final int UPLOAD_NOTIFICATION_ID = 1000;

    @Inject private Context mContext;
    private NotificationManager mManager;

    private NotificationManager getNotificationManager() {
        if (mManager != null) {
            return mManager;
        } else {
            return (NotificationManager) mContext.getSystemService(Context.NOTIFICATION_SERVICE);
        }
    }

    private Notification buildNotification() {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(
                mContext.getApplicationContext());
        final Intent notificationIntent =
                new Intent(mContext, TimelineActivity.class);
        final PendingIntent contentIntent = PendingIntent.getActivity(mContext, 0,
                notificationIntent, 0);
        builder.setContentIntent(contentIntent);
        builder.setTicker("uploading...");
        builder.setContentTitle("uploading...");
        builder.setContentText("RejaMotion");
        builder.setSmallIcon(android.R.drawable.arrow_up_float);
        builder.setLargeIcon(BitmapFactory.decodeResource(
                mContext.getResources(), R.drawable.ic_launcher));
        builder.setWhen(System.currentTimeMillis());
        builder.setWhen(System.currentTimeMillis());
        builder.setDefaults(Notification.DEFAULT_SOUND | Notification.DEFAULT_LIGHTS);
        builder.setAutoCancel(true);

        return builder.build();
    }

    public void sendNotification() {
        getNotificationManager().notify(
                UPLOAD_NOTIFICATION_ID, buildNotification());
    }

    public void cancelNotification() {
        getNotificationManager().cancel(UPLOAD_NOTIFICATION_ID);
    }
}
