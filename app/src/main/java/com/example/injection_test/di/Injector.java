//package com.example.injection_test.di;
//
//
//import com.example.injection_test.data.RandomAPI;
//import com.example.injection_test.data.RandomService;
//import com.example.injection_test.network.NetworkModule;
//
//import retrofit2.Retrofit;
//
////inversion pf control
//public class Injector {
//
//    public static RandomService provideRandomService(){
//        return new RandomService(provideRandomAPI());
//    }
//
//    private static RandomAPI provideRandomAPI(){
//        return provideNetworkManager()
//                .provideRetrofitClient()
//                .create(RandomAPI.class);
//    }
//    private static NetworkModule provideNetworkManager(){
//        return new NetworkModule();
//    }
//}
