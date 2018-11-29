package com.example.rkjc.news_app_2;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;


public class NewsItemViewModel extends AndroidViewModel {

    private static NewsRepository mRepository;

    private LiveData<List<NewsItem>> CurrentNewsItems;

    public NewsItemViewModel(Application application){
        super(application);
        mRepository = new NewsRepository(application);
        CurrentNewsItems = NewsRepository.getCurrentNewsItems();
    }

    public LiveData<List<NewsItem>> getCurrentNewsItems(){
        return CurrentNewsItems;
    }

    public static void sync(){
        NewsRepository.sync();
    }


}
