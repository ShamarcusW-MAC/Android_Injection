package com.example.injection_test.network;

import com.example.injection_test.BuildConfig;
import com.example.injection_test.data.RandomAPI;

import javax.inject.Singleton;

import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkModule {
    private Retrofit retrofit;

    public NetworkModule(){
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
    @Provides
    @Singleton
    Retrofit provideRetrofitClient(OkHttpClient client,
                                          RxJava2CallAdapterFactory callFactory,
                                          GsonConverterFactory converterFactory){
        return new Retrofit.Builder()
                .baseUrl(RandomAPI.BASE_URL)
                .addCallAdapterFactory(callFactory)
                .addConverterFactory(converterFactory)
                .client(client)
                .build();
    }

    @Provides
    @Singleton
    OkHttpClient provideHttpClient(){
        return new OkHttpClient.Builder()
                .addInterceptor(provideHttpInterceptor())
                .build();
    }

    @Provides
    @Singleton
    HttpLoggingInterceptor provideHttpInterceptor(){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        if(BuildConfig.DEBUG) {
            interceptor.level(HttpLoggingInterceptor.Level.BODY);
        }else
        {
            interceptor.level(HttpLoggingInterceptor.Level.NONE);

        }
        return interceptor;
    }

    @Provides
    @Singleton
    GsonConverterFactory provideConverterFactory(){
        return GsonConverterFactory.create();
    }

    @Provides
    @Singleton
    RxJava2CallAdapterFactory provideExJavaCallAdapter(){
        return RxJava2CallAdapterFactory.create();
    }
}
