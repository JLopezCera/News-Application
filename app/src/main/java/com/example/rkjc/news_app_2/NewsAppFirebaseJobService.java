package com.example.rkjc.news_app_2;

import android.content.Context;
import android.os.AsyncTask;

public class NewsAppFirebaseJobService extends com.firebase.jobdispatcher.JobService {

    private AsyncTask mBackgroundTask;

    @Override
    public boolean onStartJob(final com.firebase.jobdispatcher.JobParameters job) {
        mBackgroundTask = new AsyncTask() {
            @Override
            protected Object doInBackground(Object[] objects) {
                Context context = NewsAppFirebaseJobService.this;
                NewsRepository mRespoitory = new NewsRepository(getApplication());
                mRespoitory.sync(NetworkUtils.buildUrl());
                NewsAppTasks.executeTask(context, NewsAppTasks.ACTION_SEND_NOTIFICATION);
                return null;
            }

            @Override
            protected void onPostExecute(Object o) {
                jobFinished(job, false);
            }
        };

        mBackgroundTask.execute();
        return true;
    }

    @Override
    public boolean onStopJob(com.firebase.jobdispatcher.JobParameters job) {
        if(mBackgroundTask != null) {
            mBackgroundTask.cancel(true);
        }
        return true;
    }
}