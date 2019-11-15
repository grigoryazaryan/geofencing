package com.example.geofencing;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

/**
 * Created by Grigory Azaryan on 2019-11-15.
 */

public class NotificationHelper {

    final static String NOTIFICATION_CHANNEL_ID = "NOTIFICATION_CHANNEL_ID";
    static int notificationCounter;

    public static void showNotification(Context context, String title, String message) {
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(context);
        //crate notification channel for API 26+
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(NOTIFICATION_CHANNEL_ID, NOTIFICATION_CHANNEL_ID, importance);
            notificationManager.createNotificationChannel(channel);
        }

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, NOTIFICATION_CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_all_out)
                .setContentTitle(title)
                .setContentText(message)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

// notificationId is a unique int for each notification that you must define
        notificationManager.notify(++notificationCounter, builder.build());
    }
}
