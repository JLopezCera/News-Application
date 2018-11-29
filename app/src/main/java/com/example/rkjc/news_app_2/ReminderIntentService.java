package com.example.rkjc.news_app_2;

import android.app.IntentService;
import android.content.Intent;

public class ReminderIntentService extends IntentService {
    public ReminderIntentService() {
        super("RefreshReminderIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        String action = intent.getAction();
        ReminderTasks.executeTask(this, action);
    }
}
