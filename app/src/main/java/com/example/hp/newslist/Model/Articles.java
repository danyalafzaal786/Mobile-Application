package com.example.hp.newslist.Model;

import java.io.Serializable;

/**
 * Created by hp on 6/20/2017.
 */

public class Articles implements Serializable {
    private String author;
    private String title;
    private String description;
    private String url;
    private String urlToImage;
    private String publishedAt;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImageUrl() {
        return urlToImage;
    }

    public void setImageUrl(String imageUrl) {
        this.urlToImage = imageUrl;
    }

    public String getPublishDate() {
        return publishedAt;
    }

    public void setPublishDate(String publishDate) {
        this.publishedAt = publishDate;
    }
}
