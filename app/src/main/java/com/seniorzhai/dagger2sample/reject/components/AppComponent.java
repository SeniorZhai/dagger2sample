package com.seniorzhai.dagger2sample.reject.components;

import android.app.Application;

import com.seniorzhai.dagger2sample.model.ApiService;
import com.seniorzhai.dagger2sample.reject.module.ApiServiceModule;
import com.seniorzhai.dagger2sample.reject.module.AppModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by zhai on 16/5/23.
 * AppComponent
 */
@Singleton
@Component(modules = {AppModule.class, ApiServiceModule.class})
public interface AppComponent {

    Application getApplication();
    ApiService getApiService();

}