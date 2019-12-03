package com.example.injection_test.network;


import com.example.injection_test.data.RandomAPI;
import com.example.injection_test.data.RandomService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class RandomAPIModule {

    @Provides
    @Singleton
    RandomAPI providesRandomAPI(Retrofit retrofit){
        return retrofit.create(RandomAPI.class);
    }

}
