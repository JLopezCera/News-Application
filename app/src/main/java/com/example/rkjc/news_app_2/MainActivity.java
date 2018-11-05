package com.example.rkjc.news_app_2;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;



public class MainActivity extends AppCompatActivity {
    private ProgressBar mProgressBar;
    private static final String TAG = "MainActivity";
<<<<<<< HEAD:app/src/main/java/com/example/rkjc/news_app_2/MainActivity.java

    private NewsRecyclerViewAdapter mAdapter;
=======
    private RecyclerView mRecyclerView;
    private NewsAdapter mAdapter;
>>>>>>> 3433b9678d80914691a81f664ddab01d5cf48e2b:app/src/main/java/com/example/android/datafrominternet/MainActivity.java
    private ArrayList<NewsItem> repos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
<<<<<<< HEAD:app/src/main/java/com/example/rkjc/news_app_2/MainActivity.java
        mProgressBar = findViewById(R.id.progress);
        RecyclerView mRecyclerView = findViewById(R.id.news_recyclerview);
        mAdapter = new NewsRecyclerViewAdapter(this, repos);
=======
        mProgressBar = (ProgressBar) findViewById(R.id.progress);
        mRecyclerView = (RecyclerView) findViewById(R.id.news_recyclerview);
        mAdapter = new NewsAdapter(this, repos);
>>>>>>> 3433b9678d80914691a81f664ddab01d5cf48e2b:app/src/main/java/com/example/android/datafrominternet/MainActivity.java
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        URL url = NetworkUtils.buildUrl();
        NewsQueryTask task = new NewsQueryTask();
        task.execute(url);

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemThatWasClickedId = item.getItemId();
        if (itemThatWasClickedId == R.id.action_search) {
            URL url = NetworkUtils.buildUrl();
            NewsQueryTask task = new NewsQueryTask();
            task.execute(url);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

<<<<<<< HEAD:app/src/main/java/com/example/rkjc/news_app_2/MainActivity.java
=======

    // DONE (1) Create a class called GithubQueryTask that extends AsyncTask<URL, Void, String>
>>>>>>> 3433b9678d80914691a81f664ddab01d5cf48e2b:app/src/main/java/com/example/android/datafrominternet/MainActivity.java
    @SuppressLint("StaticFieldLeak")
    class NewsQueryTask extends AsyncTask<URL, Void, String> {


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mRecyclerView.setVisibility(View.GONE);
            mProgressBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected String doInBackground(URL... urls) {
            String NewsResults = "";
            try {
                NewsResults = NetworkUtils.getResponseFromHttpUrl(urls[0]);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return NewsResults;
        }


        @Override
        protected void onPostExecute(String s) {
            Log.d("mycode", s);
            super.onPostExecute(s);
            mProgressBar.setVisibility(View.GONE);
<<<<<<< HEAD:app/src/main/java/com/example/rkjc/news_app_2/MainActivity.java
            repos = JsonUtils.parseNews(s);
=======
            mRecyclerView.setVisibility(View.VISIBLE);
            repos = JSONUtils.parseNews(s);
>>>>>>> 3433b9678d80914691a81f664ddab01d5cf48e2b:app/src/main/java/com/example/android/datafrominternet/MainActivity.java
            mAdapter.mRepos.addAll(repos);
            mAdapter.notifyDataSetChanged();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

}
