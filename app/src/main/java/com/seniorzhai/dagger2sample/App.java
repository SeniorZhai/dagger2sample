package com.seniorzhai.dagger2sample;

import android.app.Application;
import android.content.Context;

import com.seniorzhai.dagger2sample.reject.components.AppComponent;
import com.seniorzhai.dagger2sample.reject.components.DaggerAppComponent;
import com.seniorzhai.dagger2sample.reject.module.ApiServiceModule;
import com.seniorzhai.dagger2sample.reject.module.AppModule;

/**
 * Created by zhai on 16/5/23.
 */

public class App extends Application {
    private AppComponent appComponent;

    public static App get(Context context){
        return (App) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        // 注入AppModule ApiServiceModule
        appComponent= DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .apiServiceModule(new ApiServiceModule())
                .build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
