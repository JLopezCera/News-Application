package com.example.rkjc.news_app_2;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends AppCompatActivity {

    private NewsItemViewModel newsItemViewModel;
    private NewsRecyclerViewAdapter mAdapter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView mRecyclerView = findViewById(R.id.news_recyclerview);
        newsItemViewModel = ViewModelProviders.of(this).get(NewsItemViewModel.class);
        mAdapter = new NewsRecyclerViewAdapter(this, newsItemViewModel);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        FirebaseJobUtility.scheduleNotification(this);
        newsItemViewModel.getCurrentNewsItems().observe(this, newsItems -> mAdapter.setNews(newsItems));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemThatWasClickedId = item.getItemId();
        if (itemThatWasClickedId == R.id.action_search) {
            NewsItemViewModel.sync();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

}
