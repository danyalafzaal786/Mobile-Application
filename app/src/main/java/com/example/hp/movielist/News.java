package com.example.hp.movielist;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
