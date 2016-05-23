package com.seniorzhai.dagger2sample.reject.module;

import com.seniorzhai.dagger2sample.presenter.MainActivityPresenter;
import com.seniorzhai.dagger2sample.model.ApiService;
import com.seniorzhai.dagger2sample.view.MainActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by zhai on 16/5/23.
 */

@Module
public class MainActivityModule {

    private MainActivity mainActivity;

    public MainActivityModule(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }


    @Provides
    MainActivity provideMainActivity() {
        return mainActivity;
    }


    @Provides
    MainActivityPresenter provideMainActivityPresenter(ApiService apiService) {
        return new MainActivityPresenter(apiService);
    }
}
