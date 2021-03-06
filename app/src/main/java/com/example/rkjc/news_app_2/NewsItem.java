package com.example.rkjc.news_app_2;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;


@Entity(tableName = "news_item")
public class NewsItem{
    @PrimaryKey(autoGenerate = true)
    private int id;
    @NonNull
    @ColumnInfo(name = "author")
    private String author_name;
    @NonNull
    @ColumnInfo(name = "title")
    private String title;
    @NonNull
    @ColumnInfo(name = "description")
    private String description;
    @NonNull
    @ColumnInfo(name = "url")
    private String url;
    @NonNull
    @ColumnInfo(name = "date")
    private String date;
    @NonNull
    @ColumnInfo(name = "urlToImage")
    private String urlToImage;

    public NewsItem(int id, @NonNull String author_name, @NonNull String title, @NonNull String description, @NonNull String url, @NonNull String urlToImage,@NonNull String date) {
        this.id = id;
        this.author_name = author_name;
        this.title = title;
        this.description = description;
        this.url = url;
        this.date = date;
        this.urlToImage = urlToImage;
    }

    @Ignore
    public NewsItem(@NonNull String author_name, @NonNull String title, @NonNull String description, @NonNull String url, @NonNull String urlToImage,@NonNull String date) {
        this.author_name = author_name;
        this.title = title;
        this.description = description;
        this.url = url;
        this.date = date;
        this.urlToImage = urlToImage;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor_name(){
        return author_name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(@NonNull String date) {
        this.date = date;
    }

    public String getUrlToImage() {
        return urlToImage;
    }
}
