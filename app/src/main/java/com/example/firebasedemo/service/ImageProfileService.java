package com.example.firebasedemo.service;

import com.example.firebasedemo.model.getall.Welcome;
import com.example.firebasedemo.model.user.WelcomeUser;

import java.util.List;

import io.reactivex.Observable;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ImageProfileService {
    //    String str = "https://api.unsplash.com/users/julesmarchioni67?client_id=fuOu4odHIMZNCseveRF1qVtYgBE19N5Yt9ET01QehZk"
    static final String imageUrl  = "https://api.unsplash.com/";
    static final String clientId = "33YwfB05fCHfEo45vE19VPQ4IsnDj8FOysZplsVYr1w";
    static ImageProfileService createService(){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();
        Retrofit retrofit = new Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
                .baseUrl(imageUrl)
                .client(client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        return retrofit.create(ImageProfileService.class);
        // trả về retrofit(http request)
    }
    //    @GET("topics/towJZFskpGg/photos?")
//    Observable<List<Welcome>> getRandomImages(@Query("page") int page, @Query("client_id") String clientId);
    @GET("users/{username}")
    Observable<WelcomeUser> getImagesWithUsername(@Path("username") String username, @Query("client_id") String clientId);

}
