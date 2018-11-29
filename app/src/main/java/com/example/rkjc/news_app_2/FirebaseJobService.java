package com.example.rkjc.news_app_2;

import com.firebase.jobdispatcher.JobParameters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;
import com.firebase.jobdispatcher.JobService;


public class FirebaseJobService extends JobService {
    static AsyncTask mBackgroundTask;

    @SuppressLint("StaticFieldLeak")
    @Override
    public boolean onStartJob(final JobParameters jobParameters) {
        mBackgroundTask = new AsyncTask() {

            @Override
            protected Object doInBackground(Object[] objects) {
                Context context = FirebaseJobService.this;
                NewsRepository.sync();
                ReminderTasks.executeTask(context, ReminderTasks.ACTION_NOTIFY_REFRESH_NEWS);
                return null;
            }
            @Override
            protected void onPostExecute(Object o) {
                jobFinished(jobParameters, true);
            }
        };

        mBackgroundTask.execute();
        return true;
    }

    @Override
    public boolean onStopJob(JobParameters jobParameters) {
        if (mBackgroundTask != null) mBackgroundTask.cancel(true);
        return true;
    }
}