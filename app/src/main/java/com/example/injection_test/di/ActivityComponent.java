package com.example.injection_test.di;

import com.example.injection_test.MainActivity;
import com.example.injection_test.data.RandomAPI;
import com.example.injection_test.network.NetworkModule;

import java.util.Random;

import dagger.Component;

@Component(modules = {NetworkModule.class, RandomAPI.class})
public interface ActivityComponent {

    RandomAPI randomAPI();
    MainActivity inject(MainActivity activity);
}
