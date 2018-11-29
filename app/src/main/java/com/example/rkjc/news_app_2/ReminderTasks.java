package com.example.rkjc.news_app_2;

import android.arch.lifecycle.LiveData;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ReminderTasks {
    public static final String ACTION_NOTIFY_REFRESH_NEWS = "notify-refresh-news";
    public static final String ACTION_DISMISS_NOTIFICATION = "dismiss-notification";

    public static void executeTask(Context context, String action) {

        if (ACTION_NOTIFY_REFRESH_NEWS.equals(action)) {
            Reminder(context);
        } else if (ACTION_DISMISS_NOTIFICATION.equals(action)) {
            NotificationUtils.clearAllNotifications(context);
        }
    }

    private static void Reminder(Context context) {
        NotificationUtils.IfDeviceCharging(context);
    }

}