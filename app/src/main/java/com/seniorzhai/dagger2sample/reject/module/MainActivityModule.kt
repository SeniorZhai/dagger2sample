package com.seniorzhai.dagger2sample.reject.module

import com.seniorzhai.dagger2sample.model.ApiService
import com.seniorzhai.dagger2sample.presenter.MainActivityPresenter
import dagger.Module
import dagger.Provides

/**
 * Created by zhai on 16/5/23.
 */

@Module
class MainActivityModule() {

    @Provides
    internal fun provideMainActivityPresenter(apiService: ApiService): MainActivityPresenter {
        return MainActivityPresenter(apiService)
    }
}
