package com.seniorzhai.dagger2sample.reject.module;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.seniorzhai.dagger2sample.model.ApiService;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by zhai on 16/5/23.
 */

@Module
public class ApiServiceModule {
    private static final String ENDPOINT = "http://gank.avosapps.com/api/";

    final Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").serializeNulls().create();

    @Provides
    @Singleton
    ApiService provideApiService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ENDPOINT)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpClient())
                .build();
        return retrofit.create(ApiService.class);
    }

    private OkHttpClient okHttpClient() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        // config log
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        return new OkHttpClient.Builder()
                .connectTimeout(60 * 1000, TimeUnit.MILLISECONDS)
                .readTimeout(60 * 1000, TimeUnit.MILLISECONDS)
                .addInterceptor(logging)
                .build();

    }
}
