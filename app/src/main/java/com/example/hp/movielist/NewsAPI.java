package com.example.hp.movielist;

/**
 * Created by hp on 6/20/2017.
 */

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NewsAPI {
    @GET("articles")
    Call<News> loadNews(@Query("source") String source, @Query("sortBy") String sortBy, @Query("apiKey") String apiKey);
}
