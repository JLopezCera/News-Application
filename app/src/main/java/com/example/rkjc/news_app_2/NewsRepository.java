package com.example.rkjc.news_app_2;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;
import java.io.IOException;
import java.net.URL;
import java.util.List;


public class NewsRepository {

    private static NewsItemDao nNewsItemDao;
    private static LiveData<List<NewsItem>> CurrentNewsItems;

    public NewsRepository(Application application){
        NewsDatabase db = NewsDatabase.getDatabase(application.getApplicationContext());
        nNewsItemDao = db.newsItemDao();
        CurrentNewsItems = nNewsItemDao.loadAllNewsItems();
    }

    static LiveData<List<NewsItem>> getCurrentNewsItems() {
        return CurrentNewsItems;
    }


    public static void sync(){
        new insertAsyncTask(nNewsItemDao).execute();
    }


    private static class insertAsyncTask extends AsyncTask<Void, Void, Void> {
        private NewsItemDao mDao;

        insertAsyncTask(NewsItemDao dao) {
            mDao = dao;
        }

        @Override
        protected Void doInBackground(Void... voids) {

            URL url = NetworkUtils.buildUrl();
            String newsResults = "";
            mDao.clearAll();

            try {
                newsResults = NetworkUtils.getResponseFromHttpUrl(url);
            } catch (IOException e) {
                e.printStackTrace();
            }
            List<NewsItem> articles = JsonUtils.parseNews(newsResults);

            for (NewsItem article : articles) {
                mDao.insert(article);
            }

            return null;
        }
    }
}
