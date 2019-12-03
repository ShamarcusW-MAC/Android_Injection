package com.example.injection_test.network;

import com.example.injection_test.BuildConfig;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkManager {
    private Retrofit retrofit;

    public NetworkManager(){
        //constructor
    }

//    public Retrofit provideRetrofitNoRx(String url){
//        return new Retrofit.Builder()
//                .baseUrl(url)
//                .addConverterFactory(provideConverterFactory())
//                .client(provideHttpClient())
//                .build();
//    }
//
    public Retrofit provideRetrofitClient(String url){
        return new Retrofit.Builder()
                .baseUrl(url)
                .addCallAdapterFactory(provideExJavaCallAdapter())
                .addConverterFactory(provideConverterFactory())
                .client(provideHttpClient())
                .build();
    }

    private OkHttpClient provideHttpClient(){
        return new OkHttpClient.Builder()
                .addInterceptor(provideHttpInterceptor())
                .build();
    }

    private HttpLoggingInterceptor provideHttpInterceptor(){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        if(BuildConfig.DEBUG) {
            interceptor.level(HttpLoggingInterceptor.Level.BODY);
        }else
        {
            interceptor.level(HttpLoggingInterceptor.Level.NONE);

        }
        return interceptor;
    }

    private GsonConverterFactory provideConverterFactory(){
        return GsonConverterFactory.create();
    }

    private RxJava2CallAdapterFactory provideExJavaCallAdapter(){
        return RxJava2CallAdapterFactory.create();
    }
}
