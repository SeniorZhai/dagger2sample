package com.seniorzhai.dagger2sample.reject.components

import com.seniorzhai.dagger2sample.model.ApiService
import com.seniorzhai.dagger2sample.reject.module.ApiServiceModule
import dagger.Component
import javax.inject.Singleton

/**
 * Created by zhai on 16/5/23.
 * AppComponent
 */
@Singleton
@Component(modules = arrayOf(ApiServiceModule::class))
interface AppComponent {
    val apiService: ApiService
}