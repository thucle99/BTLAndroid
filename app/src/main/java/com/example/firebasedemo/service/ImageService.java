package com.example.firebasedemo.service;

import com.example.firebasedemo.model.getall.Welcome;

import java.util.List;

import io.reactivex.Observable;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ImageService {
//    String str = "https://api.unsplash.com/topics/towJZFskpGg/photos?page=1&client_id=-H5uie2gFTUpwfhVJlIcqPodocHCNTQvsx3zRrgYbB4"
    static final String imageUrl  = "https://api.unsplash.com/";
    static final String clientId = "-H5uie2gFTUpwfhVJlIcqPodocHCNTQvsx3zRrgYbB4";
    static ImageService createService(){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();
        Retrofit retrofit = new Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
                .baseUrl(imageUrl)
                .client(client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        return retrofit.create(ImageService.class);
        // trả về retrofit(http request)
    }
    @GET("topics/towJZFskpGg/photos?")
    Observable<List<Welcome>> getRandomImages(@Query("page") int page, @Query("client_id") String clientId);

}
