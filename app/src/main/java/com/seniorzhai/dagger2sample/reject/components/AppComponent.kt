package com.seniorzhai.dagger2sample.reject.components

import android.app.Application
import com.seniorzhai.dagger2sample.model.ApiService
import com.seniorzhai.dagger2sample.reject.module.ApiServiceModule
import com.seniorzhai.dagger2sample.reject.module.AppModule
import dagger.Component
import javax.inject.Singleton

/**
 * Created by zhai on 16/5/23.
 * AppComponent
 */
@Singleton
@Component(modules = arrayOf(AppModule::class, ApiServiceModule::class))
interface AppComponent {

    val application: Application
    val apiService: ApiService

}