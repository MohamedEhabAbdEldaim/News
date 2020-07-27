package com.midooabdaim.news.data.api;


import com.midooabdaim.news.data.model.NewsModel.News;

import io.reactivex.Single;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;


public interface ApiService {

    @GET("top-headlines")
    Single<News> getNewsForCountry(@Query("apiKey") String apiKey,
                                   @Query("country") String country,
                                   @Query("page") int page);

    @GET("top-headlines")
    Single<News> getNewsWithCategory(@Query("apiKey") String apiKey,
                                     @Query("country") String country,
                                     @Query("category") String category,
                                     @Query("page") int page);


}
