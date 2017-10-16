package com.seniorzhai.dagger2sample.reject.module

import com.seniorzhai.dagger2sample.presenter.MeiziPresenter
import dagger.Module
import dagger.Provides

/**
 * Created by zhai on 16/5/23.
 */

@Module
class MeiziActivityModule() {

    @Provides
    internal fun provideMeiziActivityPresenter(): MeiziPresenter {
        return MeiziPresenter()
    }
}