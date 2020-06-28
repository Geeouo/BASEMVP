package com.houserentmanage.api;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Create by Gee on 2020/6/9.
 */
public class RetrofitClient {
    public  static RetrofitClient instance = new RetrofitClient();
    private Api apiService;
    private Retrofit retrofit;
    private RetrofitClient(){}

    public static RetrofitClient getInstance(){
        return instance;
    }

    public Api getApiService(){
     return apiService != null? apiService:createApi();
    }

    private Api createApi()  {
        if (retrofit == null) {
            synchronized (RetrofitClient.class) {
                if (retrofit == null) {
                    OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder();
                    okHttpClientBuilder.connectTimeout(30, TimeUnit.SECONDS);
                    okHttpClientBuilder.readTimeout(30, TimeUnit.SECONDS);
                    Retrofit.Builder builder = new Retrofit.Builder();
                    retrofit = builder
                            .baseUrl(Constants.baseUrl)
                            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                            .addConverterFactory(GsonConverterFactory.create())
                            .client(okHttpClientBuilder.build())
                            .build();
                }
                if (apiService == null) {
                    apiService  = retrofit.create(Api.class);
                }
            }
        }

        return apiService;
    }
}
