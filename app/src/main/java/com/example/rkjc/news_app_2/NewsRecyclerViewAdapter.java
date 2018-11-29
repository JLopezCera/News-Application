package com.example.rkjc.news_app_2;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

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
        if(mRepos != null){
            return mRepos.size();
        }
        else {
            return 0;
        }
    }


    public class NewsViewHolder extends RecyclerView.ViewHolder {
        TextView Title;
        TextView Abstract;
        ImageView Article_image;

        public NewsViewHolder(View itemView) {
            super(itemView);
            Title = itemView.findViewById(R.id.title);
            Abstract = itemView.findViewById(R.id.article_abstract);
            Article_image = itemView.findViewById(R.id.article_image);


        }

        void bind(int listIndex) {
            Title.setText(String.format("Title: %s", mRepos.get(listIndex).getTitle()));
            Abstract.setText(mRepos.get(listIndex).getDate());
            Abstract.append(" . ");
            Abstract.append(mRepos.get(listIndex).getDescription());

            Picasso.get().load(mRepos.get(listIndex).getUrlToImage()).into(Article_image);

            itemView.setOnClickListener((View view) -> {
                Uri webpage = Uri.parse(mRepos.get(listIndex).getUrl());
                Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
                mContext.startActivity(intent);

            });
        }


    }
}
