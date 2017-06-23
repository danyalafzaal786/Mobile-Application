package com.example.hp.movielist;

/**
 * Created by hp on 6/20/2017.
 */

import android.app.Activity;
import android.content.Context;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Controller implements Callback<News> {

    Call<News> call;
    static final String BASE_URL = "https://newsapi.org/v1/";
    public NewsList newsList;

    public Controller(){
        newsList = null;
    }

    public Controller(NewsList newsList){
        this.newsList = newsList;
    }

    public void start() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        NewsAPI newsAPI = retrofit.create(NewsAPI.class);

        call = newsAPI.loadNews("bbc-news", "top", "03846200fdc3425182f612984e7d42bd");
        call.enqueue(this);
    }

    @Override
    public void onResponse(Call<News> call, Response<News> response) {
        if(response.isSuccessful()) {
            News news = response.body();
            newsList.createView(news);
        } else {
            System.out.println(response.errorBody());
        }
    }

    @Override
    public void onFailure(Call<News> call, Throwable t) {
        newsList.createView(null);
        t.printStackTrace();
    }

    public void cancel(){
        call.cancel();
    }
}
