package com.example.rkjc.news_app_2;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


public class NewsRepository {

    private NewsItemDao nNewsItemDao;
    private LiveData<List<NewsItem>> CurrentNewsItems;

    public NewsRepository(Application application){
        NewsDatabase db = NewsDatabase.getDatabase(application.getApplicationContext());
        nNewsItemDao = db.newsItemDao();
        CurrentNewsItems = nNewsItemDao.loadAllNewsItems();
    }

    LiveData<List<NewsItem>> getCurrentNewsItems() {
        return CurrentNewsItems;
    }


    public void sync(URL url){
        new insertAsyncTask(nNewsItemDao).execute(url);
    }


    private static class insertAsyncTask extends AsyncTask<URL, Void, Void> {
        private NewsItemDao mDao;

        insertAsyncTask(NewsItemDao dao) {
            mDao = dao;
        }

        @Override
        protected Void doInBackground(final URL... urls) {
            String newsResults = "";

            try {
                newsResults = NetworkUtils.getResponseFromHttpUrl(urls[0]);
            } catch (IOException e) {
                e.printStackTrace();
            }

            List<NewsItem> articles = JsonUtils.parseNews(newsResults);
            mDao.clearAll();
            for (NewsItem article : articles) {
                mDao.insert(article);
            }
            return null;


        }

    }
}
