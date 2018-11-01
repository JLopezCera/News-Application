package com.example.android.datafrominternet;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.datafrominternet.model.NewsItem;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.RepoHolder>{
    Context mContext;
    ArrayList<NewsItem> mRepos;


    public NewsAdapter(Context context, ArrayList<NewsItem> repos){
        this.mContext = context;
        this.mRepos = repos;
    }

    @Override
    public NewsAdapter.RepoHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;

        View view = inflater.inflate(R.layout.item, parent, shouldAttachToParentImmediately);
        RepoHolder viewHolder = new RepoHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(NewsAdapter.RepoHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return mRepos.size();
    }


    public class RepoHolder extends RecyclerView.ViewHolder {
        TextView Title;
        TextView Description;
        TextView Date;

        public RepoHolder(View itemView) {
            super(itemView);
            Title = (TextView) itemView.findViewById(R.id.title);
            Description = (TextView) itemView.findViewById(R.id.description);
            Date = (TextView) itemView.findViewById(R.id.date);


        }

        void bind(int listIndex) {
            Title.setText(String.format("Title: %s", mRepos.get(listIndex).getTitle()));
            Description.setText(String.format("Description: %s", mRepos.get(listIndex).getDescription()));
            Date.setText(String.format("Date: %s", mRepos.get(listIndex).getDate()));

        }


    }
}
