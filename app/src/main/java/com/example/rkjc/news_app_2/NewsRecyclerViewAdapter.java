package com.example.rkjc.news_app_2;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class NewsRecyclerViewAdapter  extends RecyclerView.Adapter<NewsRecyclerViewAdapter.NewsViewHolder> {

    Context mContext;
    List<NewsItem> mRepos;
    private NewsItemViewModel viewModel;

    public NewsRecyclerViewAdapter(Context context, NewsItemViewModel viewModel){
        this.mContext = context;
        this.viewModel = viewModel;
    }

    @Override
    public NewsRecyclerViewAdapter.NewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;

        View view = inflater.inflate(R.layout.news_item, parent, shouldAttachToParentImmediately);
        NewsViewHolder viewHolder = new NewsViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(NewsRecyclerViewAdapter.NewsViewHolder holder, int position) {
        holder.bind(position);
    }

    void setNews(List<NewsItem> newsItems){
        mRepos = newsItems;
        notifyDataSetChanged();
    }


    @Override
    public int getItemCount() {
        return mRepos.size();
    }


    public class NewsViewHolder extends RecyclerView.ViewHolder {
        TextView Title;
        TextView Description;
        TextView Date;

        public NewsViewHolder(View itemView) {
            super(itemView);
            Title = itemView.findViewById(R.id.title);
            Description = itemView.findViewById(R.id.description);
            Date = itemView.findViewById(R.id.date);


        }

        void bind(int listIndex) {
            Title.setText(String.format("Title: %s", mRepos.get(listIndex).getTitle()));
            Description.setText(String.format("Description: %s", mRepos.get(listIndex).getDescription()));
            Date.setText(String.format("Date: %s", mRepos.get(listIndex).getDate()));

            itemView.setOnClickListener((View view) -> {
                Uri webpage = Uri.parse(mRepos.get(listIndex).getUrl());
                Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
                mContext.startActivity(intent);

            });
        }


    }
}
