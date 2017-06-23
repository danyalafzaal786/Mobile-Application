package com.example.hp.newslist.Model;

import com.example.hp.newslist.Model.Articles;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by hp on 6/20/2017.
 */

public class News implements Serializable {
    public ArrayList<Articles> getArticles() {
        return articles;
    }

    public void setArticles(ArrayList<Articles> articles) {
        this.articles = articles;
    }

    private ArrayList<Articles> articles;

}
