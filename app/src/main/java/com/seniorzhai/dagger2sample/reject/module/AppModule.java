package com.seniorzhai.dagger2sample.reject.module;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by zhai on 16/5/23.
 */

@Module
public class AppModule {

    private Application application;

    public AppModule(Application application){
        this.application=application;
    }

    @Provides
    @Singleton
    public Application provideApplication(){
        return application;
    }

}
