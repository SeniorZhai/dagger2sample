package com.seniorzhai.dagger2sample.reject.module;

import com.seniorzhai.dagger2sample.presenter.MeiziPresenter;
import com.seniorzhai.dagger2sample.view.MeiziActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by zhai on 16/5/23.
 */

@Module
public class MeiziActivityModule {
    private MeiziActivity mMeiziActivity;

    public MeiziActivityModule(MeiziActivity meiziActivity) {
        mMeiziActivity = meiziActivity;
    }

    @Provides
    MeiziActivity provideActivity() {
        return mMeiziActivity;
    }


    @Provides
    MeiziPresenter provideMeiziActivityPresenter() {
        return new MeiziPresenter();
    }
}