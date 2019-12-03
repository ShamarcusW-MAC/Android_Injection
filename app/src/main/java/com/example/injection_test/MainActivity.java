package com.example.injection_test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.injection_test.data.RandomService;
import com.example.injection_test.di.Injector;
import com.example.injection_test.model.RandomUser;

public class MainActivity extends AppCompatActivity implements RandomService.Callback {

    private static final String TAG = "MainActivity_TAG";

    private RandomService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        service = Injector.provideRandomService();
        service.getRandomUser(this);
    }

    @Override
    public void onRandomUser(RandomUser user) {
        Log.d(TAG, "onRandomUser: " + user);
    }

    @Override
    public void onError(String error) {
        Log.e(TAG, "onError: " + error);

    }
}
