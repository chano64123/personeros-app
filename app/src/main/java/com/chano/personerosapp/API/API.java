package com.chano.personerosapp.API;

import com.chano.personerosapp.App.Config;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class API {
    public static Retrofit _retrofit;
    public static OkHttpClient _okHttpClient;
    public static Gson _gson;

    public static Retrofit getRetrofitClient(String urlBase){
        _retrofit = null;
        if(_retrofit == null){
            _gson = new GsonBuilder().setLenient().create();
            _okHttpClient = new OkHttpClient.Builder()
                    .connectTimeout(Config.CONNECT_TIMEOUT, TimeUnit.SECONDS)
                    .readTimeout(Config.READ_TIMEOUT, TimeUnit.SECONDS)
                    .writeTimeout(Config.WRITE_TIMEOUT, TimeUnit.SECONDS)
                    .build();
            _retrofit = new Retrofit.Builder()
                    .baseUrl(urlBase)
                    .client(_okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create(_gson))
                    .build();
        }
        return _retrofit;
    }
}
