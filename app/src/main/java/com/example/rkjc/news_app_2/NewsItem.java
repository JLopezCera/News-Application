package com.example.rkjc.news_app_2;

public class NewsItem {
    private String author_name;
    private String title;
    private String description;
    private String url;
    private String date;

    public NewsItem(String author_name, String title, String description, String url, String date) {
        this.author_name = author_name;
        this.title = title;
        this.description = description;
        this.url = url;
        this.date = date;
    }

    public String getAuthorName() {
        return author_name;
    }

    public void setAuthorName(String author_name) {
        this.author_name = author_name;
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
        this.url = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
