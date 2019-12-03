package com.example.injection_test.data;

import android.telecom.Call;

import com.example.injection_test.model.RandomUser;
import com.example.injection_test.network.NetworkManager;

import io.reactivex.ObservableEmitter;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class RandomService {

    private RandomAPI randomAPI;

    public RandomService(){

        NetworkManager networkManager = new NetworkManager();
        Retrofit retrofit = networkManager.provideRetrofitClient(RandomAPI.BASE_URL);
        randomAPI = retrofit.create(RandomAPI.class);

    }

    public void getRandomUser(final Callback callback){
        randomAPI.getRandomUser().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<RandomUser>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(RandomUser randomUser) {

                        callback.onRandomUser(randomUser);

                    }

                    @Override
                    public void onError(Throwable e) {

                        callback.onError(e.getMessage());

                    }
                });
    }

    interface Callback{
        void onRandomUser(RandomUser user);
        void onError(String error);
    }

    //RandomService.Callback
}
